function trampoline(fn) {
    while (typeof fn === 'function') {
      fn = fn();
    }
    return fn;
}
  
function reverse(arr, res) {
    if (arr.length === 0) {
      return res;
    } else {
        let car = arr[0];        
        let cdr = arr.slice(1);
        res.unshift(car);
        return function() {
         return reverse(cdr, res);
      };
    }
  }
  
const result = trampoline(function() {
    return reverse(Array.from(Array(10000).keys()), []);
});
  
print(result);
  

/*

La función trampoline es la misma que se explicó anteriormente: se utiliza para llamar de manera iterativa a las funciones devueltas hasta que se obtiene un resultado final que no es una función.

La función reverse en esta versión sigue el mismo patrón que la función original, pero en lugar de realizar llamadas recursivas directas, devuelve una función anónima que realizará la llamada recursiva cuando se invoque. Esto es lo que permite la técnica del trampolín para evitar el desbordamiento de la pila. La llamada a trampoline envuelve la llamada inicial a reverse y gestiona las llamadas de manera iterativa.

*/