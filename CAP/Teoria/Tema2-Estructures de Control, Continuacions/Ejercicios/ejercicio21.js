function trampoline(fn) {
    while (typeof fn === 'function') {
      fn = fn();
    }
    return fn;
}
  
function my_filter_index_trampolin(arr, f, res, i) {
    function my_filter_index_aux(arr, f, res, i) {
      if (i === arr.length) {
        return res;
      } else {
        let car = arr[i];
        if (f(car)) {
          res.push(i);
        }
        return function() {
          return my_filter_index_aux(arr, f, res, i + 1);
        };
      }
    }
  
    return trampoline(function() {
      return my_filter_index_aux(arr, f, res, i);
    });
}
  
const result = my_filter_index_trampolin(
    Array.from(Array(10000).keys()),
    x => x % 2 === 0,
    [],
    0
);
  
print(result);
  


/*

La función my_filter_index_trampolin es una versión trampolined de my_filter_index. Al igual que en otros ejemplos, se utiliza una función interna llamada my_filter_index_aux para realizar las llamadas recursivas.

En my_filter_index_aux, verificamos si hemos llegado al final del array al comparar i con la longitud del array arr. Si es así, devolvemos el resultado acumulado res.

Si no hemos llegado al final del array, verificamos si el elemento en la posición i cumple con el predicado f. Si es cierto, agregamos el índice i al resultado res.

Luego, devolvemos una función anónima que realiza una llamada recursiva a my_filter_index_aux con el mismo array arr, la misma función f, el mismo resultado res y un nuevo valor de i + 1.

Finalmente, llamamos a trampoline para envolver la llamada inicial a my_filter_index_aux, lo que permite que todas las llamadas, tanto iniciales como recursivas, se gestionen de manera iterativa a través del trampolín.

El resultado de la llamada a trampoline es el resultado final de la función my_filter_index_trampolin, y se imprime en la consola. Esta versión trampolined permite filtrar elementos de un array sin problemas de desbordamiento de la pila, incluso con un gran número de elementos en el array.

*/