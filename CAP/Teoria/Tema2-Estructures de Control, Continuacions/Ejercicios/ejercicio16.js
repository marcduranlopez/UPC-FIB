function collatzCPS(n, cont) {
    if (n === 1) {
      return cont(0);
    } else {
      let m = (n % 2 === 0) ? n / 2 : 3 * n + 1;
      return collatzCPS(m, function(result) {
        return cont(1 + result);
      });
    }
  }
  
  collatzCPS(6, function(result) {
    print(result);
});


/*

La función collatzCPS toma dos argumentos: el número n y una función de continuación cont. La función cont se utiliza para pasar el resultado de los cálculos a medida que se avanza en la recursión.

Cuando n es igual a 1, la función simplemente llama a cont(0) para devolver 0 como resultado.

Cuando n no es igual a 1, se calcula el siguiente valor m, y luego se llama a collatzCPS(m, function(result) { return cont(1 + result); }). Aquí, en lugar de hacer una llamada recursiva directa, pasamos una función de continuación que se encargará de agregar 1 al resultado de la llamada recursiva.

Esta transformación a CPS garantiza que la recursión sea final y evita cualquier desbordamiento de la pila, ya que todas las llamadas recursivas se realizan en un contexto de paso de continuación. Puedes usar collatzCPS proporcionando la función de continuación deseada para obtener el resultado. Por ejemplo, collatzCPS(6, function(result) { console.log(result); }) imprimirá el resultado de la secuencia de Collatz para n = 6.

*/