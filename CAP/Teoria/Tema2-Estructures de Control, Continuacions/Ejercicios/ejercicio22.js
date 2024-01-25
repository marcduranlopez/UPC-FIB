/*
Primero, transformemos la función member en una versión CPS (Continuation Passing Style). Luego, aplicaremos la técnica del trampolín para evitar problemas de desbordamiento de la pila. Aquí tienes la versión CPS de la función member:

function member_cps(x, arr, cont) {
  function member_aux(x, arr, cont) {
    if (arr.length === 0) {
      return cont(false);
    } else {
      let car = arr[0];
      let cdr = arr.slice(1);
      if (x === car) {
        return cont(true);
      } else {
        return member_aux(x, cdr, cont);
      }
    }
  }

  return member_aux(x, arr, cont);
}

La función member_cps toma tres argumentos: x (el valor que estamos buscando), arr (el array en el que estamos buscando) y cont (la función de continuación que manejará el resultado).

La función interna member_aux se encarga de realizar la búsqueda. Si el array está vacío, se llama a la función de continuación con false. Si el primer elemento del array (car) es igual a x, se llama a la función de continuación con true. De lo contrario, se llama a member_aux de manera recursiva con el resto del array (cdr).

Ahora, aplicaremos la técnica del trampolín a member_cps para evitar problemas de desbordamiento de la pila:
*/

function trampoline(fn) {
    while (typeof fn === 'function') {
      fn = fn();
    }
    return fn;
  }
  
  function member_cps_trampolined(x, arr, cont) {
    function member_aux(x, arr, cont) {
      if (arr.length === 0) {
        return cont(false);
      } else {
        let car = arr[0];
        let cdr = arr.slice(1);
        if (x === car) {
          return cont(true);
        } else {
          return function() {
            return member_aux(x, cdr, cont);
          };
        }
      }
    }
  
    return trampoline(function() {
      return member_aux(x, arr, cont);
    });
}


/*
La función trampoline es la misma que se ha explicado en respuestas anteriores. Se utiliza para ejecutar de manera iterativa las funciones devueltas hasta que se obtiene un resultado final que no es una función.

En member_cps_trampolined, llamamos a trampoline para envolver la llamada inicial a member_aux, lo que permite que todas las llamadas, tanto iniciales como recursivas, se gestionen de manera iterativa a través del trampolín.

De esta manera, puedes utilizar member_cps_trampolined para buscar elementos en un array sin problemas de desbordamiento de la pila, incluso con un gran número de elementos en el array.
*/

