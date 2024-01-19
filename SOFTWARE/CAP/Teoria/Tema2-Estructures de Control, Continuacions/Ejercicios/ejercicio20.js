function trampoline(fn) {
    while (typeof fn === 'function') {
      fn = fn();
    }
    return fn;
}
  
function my_map_trampolin(arr, f, res) {
    function my_map_aux(arr, f, res, index) {
      if (index === arr.length) {
        return res;
      } else {
        res.push(f(arr[index]));
        return function() {
          return my_map_aux(arr, f, res, index + 1);
        };
      }
    }
  
    return trampoline(function() {
      return my_map_aux(arr, f, res, 0);
    });
}
  
const result = my_map_trampolin(Array.from(Array(10000).keys()), x => x + 1, []);
print(result);
  


/*

La función my_map_trampolin toma tres argumentos: arr (el array a mapear), f (la función a aplicar a cada elemento) y res (el resultado acumulado).

Dentro de my_map_trampolin, definimos una función interna llamada my_map_aux. Esta función lleva un índice adicional llamado index, que se utiliza para rastrear la posición actual en el array.

Si index es igual a la longitud de arr, significa que hemos mapeado todos los elementos y podemos devolver el resultado acumulado res.

Si index no es igual a la longitud de arr, entonces aún tenemos elementos para mapear. En este caso, aplicamos la función f al elemento en la posición index y agregamos el resultado a res utilizando res.push(f(arr[index])).

Luego, devolvemos una función que realiza una llamada recursiva a my_map_aux con el mismo array arr, la misma función f, el mismo resultado res y un nuevo valor de index + 1. Esta función anónima es fundamental para la técnica de trampolining, ya que permite que las llamadas recursivas se gestionen de manera iterativa.

return trampoline(function() {
    return my_map_aux(arr, f, res, 0);
  });
}

Finalmente, en my_map_trampolin, llamamos a trampoline para envolver la llamada inicial a my_map_aux. Esto asegura que todas las llamadas, tanto iniciales como recursivas, se gestionen de manera iterativa a través del trampolín.

El resultado de la llamada a trampoline es el resultado final del mapeo del array, y se devuelve como resultado de my_map_trampolin.

En resumen, esta versión de my_map utiliza la técnica de trampolining para evitar problemas de desbordamiento de la pila al realizar mapeos en arrays grandes. Las llamadas recursivas se gestionan de manera iterativa a través de una función trampolín, lo que permite el procesamiento eficiente de grandes conjuntos de datos.

*/