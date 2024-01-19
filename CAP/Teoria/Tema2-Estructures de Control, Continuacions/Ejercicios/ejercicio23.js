/*
Primero, transformaremos la función suma_array_nombres en una versión CPS (Continuation Passing Style) y luego aplicaremos la técnica del trampolín para evitar problemas de desbordamiento de pila. Aquí tienes la versión CPS de la función:

function suma_array_nombres_cps(arr, cont) {
  function suma_array_nombres_aux(arr, cont) {
    if (arr.length === 0) {
      return cont(0);
    } else {
      let primer_element = arr[0];
      let resto = arr.slice(1);
      if (typeof primer_element === "number") {
        return suma_array_nombres_aux(resto, function(result) {
          return cont(primer_element + result);
        });
      } else {
        return suma_array_nombres_aux(primer_element, function(result1) {
          return suma_array_nombres_aux(resto, function(result2) {
            return cont(result1 + result2);
          });
        });
      }
    }
  }

  return suma_array_nombres_aux(arr, cont);
}


La función suma_array_nombres_cps toma dos argumentos: arr (el array que queremos sumar) y cont (la función de continuación que manejará el resultado).

La función interna suma_array_nombres_aux se encarga de realizar la suma. Si el array está vacío, se llama a la función de continuación con 0. Si el primer elemento del array es un número, se llama a suma_array_nombres_aux de manera recursiva con el resto del array y se suma el primer elemento al resultado. Si el primer elemento no es un número, se realizan llamadas recursivas en serie para procesar el primer elemento y el resto del array, y se suman los resultados.

Ahora, aplicaremos la técnica del trampolín a suma_array_nombres_cps para evitar problemas de desbordamiento de la pila:
*/

function trampoline(fn) {
    while (typeof fn === 'function') {
      fn = fn();
    }
    return fn;
  }
  
function suma_array_nombres_cps_tr(arr, cont) {
    function suma_array_nombres_aux(arr, cont) {
      if (arr.length === 0) {
        return cont(0);
      } else {
        let car = arr[0];
        let cdr = arr.slice(1);
        if (typeof car === "number") {
          return function() {
            return suma_array_nombres_aux(cdr, function(result) {
              return cont(car + result);
            });
          };
        } else {
          return function() {
            return suma_array_nombres_aux(car, function(result1) {
              return suma_array_nombres_aux(cdr, function(result2) {
                return cont(result1 + result2);
              });
            });
          };
        }
      }
    }
  
    return trampoline(function() {
      return suma_array_nombres_aux(arr, cont);
    });
}

const result = suma_array_nombres_cps_tr(Array.from(Array(1000).keys()), x => x);
print(result)


/*
La función trampoline es la misma que se ha explicado en respuestas anteriores. Se utiliza para ejecutar de manera iterativa las funciones devueltas hasta que se obtiene un resultado final que no es una función.

En suma_array_nombres_cps_tr, llamamos a trampoline para envolver la llamada inicial a suma_array_nombres_aux, lo que permite que todas las llamadas, tanto iniciales como recursivas, se gestionen de manera iterativa a través del trampolín.

De esta manera, puedes utilizar suma_array_nombres_cps_tr para sumar elementos en un array, incluso cuando el array contiene arrays anidados, sin problemas de desbordamiento de la pila, incluso con un gran número de elementos en el array.
*/
  