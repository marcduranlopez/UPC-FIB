function my_reduce_cps(f, arr, v, cont) {
    if (arr.length === 0) {
      return cont(v);
    } else {
        let car = arr[0];
        let cdr = arr.slice(1);
        return my_reduce_cps(f, cdr, v, function(result) {
          return f(car, result, cont);
      });
    }
}
  
  // Exemples d'ús
my_reduce_cps(
  (x, total, next) => next(x * total),
  [1, 2, 3, 4, 5, 6, 7, 8, 9],
  1,
  result => print(result) // Aquí obtindràs 362880 (9!)
);
  
my_reduce_cps(
  (x, y, next) => next(x + y),
  ['h', 'o', 'l', 'a'],
  '',
  result => print(result) // Aquí obtindràs 'hola'
);
  

/*

La versión transformada my_reduce_cps toma un argumento adicional cont, que es la función de continuación a la que se pasará el resultado. Veamos la transformación paso a paso:

En la versión original, cuando arr.length es igual a 0, se devuelve v. En la versión CPS, en cambio, se llama a la función de continuación cont(v) y se le pasa v como argumento.

Cuando arr.length no es igual a 0, se descompone el array original en una variable car que contiene el primer elemento del array y una variable cdr que contiene el resto del array.

Luego, en lugar de llamar recursivamente my_reduce, se llama a my_reduce_cps con cdr como el nuevo array, v como el valor acumulado y una función de continuación que toma result y llama a f(car, result, cont).

En la llamada recursiva, en lugar de simplemente pasar f(car, my_reduce(f, cdr, v)), se pasa f(car, result, cont), lo que significa que se aplica la función f al elemento actual car y al resultado acumulado result, y luego se llama a la función de continuación cont con el resultado.

Esta transformación a CPS permite un control más preciso del flujo de ejecución y facilita la implementación de operaciones asincrónicas o la manipulación de errores, ya que todas las operaciones terminan llamando a una función de continuación.

  */