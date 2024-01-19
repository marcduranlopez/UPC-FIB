function trampoline(fn) {
    while (typeof fn === 'function') {
      fn = fn();
    }
    return fn;
  }

/*

Claro, la función trampoline es una función de utilidad que se utiliza para aplicar la técnica de trampolín y gestionar las llamadas recursivas de manera iterativa. Esta función se encarga de ejecutar de manera iterativa las funciones que devuelve hasta que se obtiene un resultado final que no es una función. Aquí tienes una explicación más detallada de cómo funciona:

trampoline toma una función fn como argumento.
En un bucle while, trampoline verifica si fn es una función.
Si fn es una función, se llama a fn() y el resultado se asigna nuevamente a fn. Esto permite que las funciones se llamen de manera secuencial sin que se acumulen en la pila de llamadas.
El bucle continúa hasta que fn no sea una función, lo que significa que se ha alcanzado el resultado final.
En ese momento, trampoline devuelve el resultado final.
La clave aquí es que el bucle while permite que las llamadas a funciones sean iterativas en lugar de recursivas, lo que evita el desbordamiento de la pila. La función trampoline asegura que todas las funciones se ejecuten en un bucle hasta que se obtenga un valor final, lo que es útil cuando se utilizan técnicas como el trampolining para evitar problemas de desbordamiento de pila en llamadas recursivas profundas.

En el contexto de la función suma_ridicula_trampolin, la función trampolín se utiliza para llamar a suma_ridicula_aux de manera iterativa, lo que permite evitar el desbordamiento de la pila y calcular el resultado de la función de manera eficiente, incluso en casos de llamadas recursivas profundas.

*/

  function suma_ridicula_trampolin(m, n) {
    function suma_ridicula_aux(m, n) {
      if (n === 0) {
        return m;
      } else {
        return function() {
          return suma_ridicula_aux(m + 1, n - 1);
        };
      }
    }
  
    return trampoline(suma_ridicula_aux(m, n));
}
  
const result = suma_ridicula_trampolin(2, 16000);
print(result);
  

/*

En esta versión, hemos introducido una función trampoline que se encarga de llamar repetidamente a la función pasada como argumento hasta que el resultado final no sea una función. Luego, devuelve ese resultado final.

La función suma_ridicula_trampolin utiliza una función auxiliar suma_ridicula_aux que está anidada. Cuando n no es igual a 0, en lugar de realizar una llamada recursiva directa, se devuelve una función que realiza la llamada recursiva. Esta función de retorno se adapta a la técnica de trampolín, ya que no realiza llamadas recursivas directas y, en su lugar, se puede gestionar de manera iterativa a través del trampolín.

El resultado se obtiene llamando a suma_ridicula_trampolin(2, 16000) y se imprime por medio de console.log. Esta versión evita el desbordamiento de la pila y es capaz de manejar tareas recursivas profundas sin problemas.

*/