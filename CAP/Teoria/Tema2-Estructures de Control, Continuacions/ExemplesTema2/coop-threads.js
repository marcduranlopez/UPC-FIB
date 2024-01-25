// Needs Rhino (https://developer.mozilla.org/es/docs/Rhino)
// Ported from the original scheme program in http://matt.might.net/articles/programming-with-continuations--exceptions-backtracking-search-threads-generators-coroutines/
// *MUST* be called:
// java -cp <<location of rhino-1.7.14.jar>> org.mozilla.javascript.tools.shell.Main -opt -2 coop-threads.js
// (this adds tail-call elimination, among other things)

function current_continuation() {
    return new Continuation();
}

function make_thread_system() {
    
    let thread_queue = [];
    let halt         = false;
    
    function spawn(thunk) {
	      let cc = current_continuation();
	      if (cc instanceof Continuation) {
	          thread_queue.push(cc);
	      } else {
	          thunk();
	          quit();
	      }
    };
    
    function relinquish() {
	      let cc = current_continuation();
	      if ((cc instanceof Continuation) && (thread_queue.length > 0)) {
	          let next_thread = thread_queue.shift();
	          thread_queue.push(cc);
	          next_thread('resume'); // resume
	      }
    };
    
    function quit() {
	      if (thread_queue.length > 0) {
	          let next_thread = thread_queue.shift();
	          next_thread('resume'); // resume
	      } else {
	          halt();
	      }
    };
    
    function start_threads() {
	      let cc = current_continuation();
	      if (cc) {
	          halt = function () { cc(false) };
	          if (thread_queue.length > 0) {
		            let next_thread = thread_queue.shift();
		            next_thread('resume'); // resume
	          }
	      }
    };
    
    return {
	      spawn: spawn,
	      relinquish: relinquish,
	      quit: quit,
	      start_threads: start_threads	
    };
    
};

//-------------------------------------------------------------
//------- Example of use --------------------------------------
//-------------------------------------------------------------

let counter = 10;
  
function make_thread_thunk(name, thread_system) {
    function loop() {
	      if (counter < 0) {
	          thread_system.quit();
	      }
	      print('in thread',name,'; counter =',counter);
	      counter--;
	      thread_system.relinquish();
	      loop();
    };
    return loop;
}

let thread_sys =  make_thread_system();

thread_sys.spawn(make_thread_thunk('a', thread_sys));
thread_sys.spawn(make_thread_thunk('b', thread_sys));
thread_sys.spawn(make_thread_thunk('c', thread_sys));

thread_sys.start_threads();



print("\nFIBONACCI(9)");
const TAG = "[NFIB]";

let fibs = [];
function make_fib_thunk(n, thread_system) {
    function nFib() {
        if (n <= 1) {
            print(TAG, "Base case:");
            print("         Fibonacci(0) = 0");
            print("         Fibonacci(1) = 1");
            fibs[0] = 0;
            fibs[1] = 1;
            //thread_system.quit();
        } else {
            print(TAG, "No previous Fibonacci values, spawn Fibonacci("
                + (n - 1) + ") thunk");
            thread_system.spawn(make_fib_thunk(n - 1, thread_system));
            while (fibs[n - 1] === undefined || fibs[n - 2] === undefined) {
                thread_system.relinquish();
            }
            fibs[n] = fibs[n - 1] + fibs[n - 2];
            print(TAG, "n =", n, "| Fibonacci(" + n + ") =", fibs[n]);
            //thread_system.quit();
        }
    };
    return nFib;
}

let fib_thread_sys = make_thread_system();
fib_thread_sys.spawn(make_fib_thunk(9, fib_thread_sys));
fib_thread_sys.start_threads();
print(TAG, fibs);


/*
En el código que proporcionaste, la variable halt se utiliza como una función que detiene el sistema de subprocesos (threads) implementado. Cuando se llama a la función halt(), se detienen todos los subprocesos en el sistema y se detiene la ejecución del programa.

En el contexto del sistema de subprocesos que se está implementando, halt se utiliza como una forma de finalizar y cerrar todos los subprocesos activos y liberar cualquier recurso asociado a ellos. Esto es útil cuando deseas terminar la ejecución de todos los subprocesos de manera controlada antes de finalizar el programa principal.

La función halt se define de la siguiente manera:
halt = function () { cc(false) };

Aquí, halt toma una función cc (que generalmente es una continuación) y llama a esa función con el valor false. Esto actúa como una señal para finalizar y detener la ejecución de los subprocesos.

En resumen, halt es una función que se utiliza para detener todos los subprocesos activos en el sistema de subprocesos implementado en el código. Cuando se llama a halt(), se inicia un proceso de finalización controlada de los subprocesos.

*/