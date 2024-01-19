function callcc(f) {
    let kont = new Continuation();
    return f(kont);
   }


print(callcc( function (k) { return 2 + 4 * k(5) } ))

print(2 + 4 * callcc( function (k) { return 5 } ))


/*

callcc( function (k) { return 2 + 4 * k(5) } ):

En esta expresión, callcc se llama primero y captura la continuación en k.
Luego, se evalúa 2 + 4 * k(5). Aquí, k(5) activa la continuación capturada, lo que significa que la ejecución salta al punto donde se llamó a callcc y se reanuda con el valor 5.
Como resultado, la primera impresión en la salida es 5, que es el valor devuelto por k(5).


2 + 4 * callcc( function (k) { return 5 } ):

En esta expresión, callcc se llama antes de evaluar la expresión completa.
callcc captura la continuación en k, pero en este caso, k no se utiliza en el cuerpo de la función. En cambio, la función simplemente devuelve 5.
Como resultado, la primera impresión en la salida es 5, que es el valor devuelto por callcc( function (k) { return 5 } ). Luego, la expresión se convierte en 2 + 4 * 5, que es igual a 22.
Por lo tanto, la primera impresión en ambas expresiones es 5, y la salida final es 5 en la primera expresión y 22 en la segunda expresión. Gracias por señalar el error en mi respuesta anterior.

*/