function trampoline(fn) {
    while (typeof fn === 'function') {
      fn = fn();
    }
    return fn;
  }
  
  function callcc(f, cc) {
    return f(function(x, ret) {
      return cc(x);
    }, cc);
}
  
function producte_array_nombres_amb_escape_trampolined(arr, cont) {
    function producte_array_nombres_aux(arr, cont, escape) {
      if (arr.length === 0) {
        return cont(1);
      } else {
        let car = arr[0];
        let cdr = arr.slice(1);
        if (typeof car === "number") {
          if (car === 0) {
            return escape(0);
          } else {
            return function() {
              return producte_array_nombres_aux(cdr, function(result) {
                return cont(car * result);
              }, escape);
            };
          }
        } else {
          return function() {
            return producte_array_nombres_aux(car, function(result1) {
              if (result1 === 0) {
                return escape(0);
              } else {
                return function() {
                  return producte_array_nombres_aux(cdr, function(result2) {
                    return cont(result1 * result2);
                  }, escape);
                };
              }
            }, escape);
          };
        }
      }
    }
  
    return trampoline(function() {
      return callcc(function(escape, cc) {
        return producte_array_nombres_aux(arr, cc, escape);
      }, cont);
    });
}

let a1 = [[1,2,3,4],5,[6,[7,[8,9]]]]
let a2 = [[[[[1]]]],[1,2,3,4],5,[6,[7,[8,9]]]]
let a3 = [[1,2,3,4],5,[6,[0,[8,9]]]]

result1 = producte_array_nombres_amb_escape_trampolined(a2, x => x);
result2 = producte_array_nombres_amb_escape_trampolined(a3, x => x);

print(result1)
print(result2)

/*
1. trampoline: Esta función es una utilidad que se utiliza para ejecutar de manera iterativa funciones que devuelven funciones (una técnica conocida como trampolín). Básicamente, itera hasta que la función proporcionada ya no devuelve otra función, en cuyo caso devuelve el resultado final. Esto es útil para evitar problemas de desbordamiento de pila al realizar llamadas recursivas.

2. callcc: Esta función permite capturar una continuación. En el contexto de esta implementación, se utiliza para capturar una continuación y luego utilizarla para escapar inmediatamente y devolver un valor específico, en este caso, un cero.

3. producte_array_nombres_amb_escape_trampolined: Esta es la función principal que se encarga de calcular el producto de elementos en un array, manejando la posibilidad de escapar y retornar inmediatamente un cero si se encuentra un cero en el proceso.

4. producte_array_nombres_aux: Esta función interna se encarga de realizar el cálculo del producto. Se divide en varios casos:

    Si el array está vacío, llama a la función de continuación (cont) con un valor de 1 para representar el caso base de la multiplicación.

    Si el primer elemento del array es un número, se verifica si es igual a cero. Si es igual a cero, se llama a la función de escape para escapar inmediatamente y retornar un cero. Si no es cero, se realiza la multiplicación y se llama a la función de continuación con el resultado.

    Si el primer elemento del array no es un número, se maneja de manera similar a cuando es un número, con la diferencia de que se realizan llamadas recursivas para procesar tanto el primer elemento como el resto del array. También se maneja el caso de encontrar un cero en el proceso.

5. return trampoline(...): Aquí se envuelve todo el proceso de cálculo en el trampolín. La función callcc se utiliza para capturar la continuación y, si es necesario, escapar y retornar un cero. Luego, se utiliza el trampolín para ejecutar de manera iterativa todo el proceso, lo que evita problemas de desbordamiento de la pila, incluso en arrays con profundidad.

En resumen, esta implementación utiliza una combinación de Continuation Passing Style (CPS), la función callcc para capturar continuaciones y la técnica del trampolín para calcular el producto de elementos en un array, con la capacidad de escapar y retornar inmediatamente un cero si se encuentra un cero en el proceso. Esto garantiza un manejo eficiente de la pila y permite el procesamiento de arrays anidados.
*/
  