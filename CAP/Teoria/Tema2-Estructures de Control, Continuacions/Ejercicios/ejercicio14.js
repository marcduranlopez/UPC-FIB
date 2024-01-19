function callcc(f) {
    let kont = new Continuation();
    return f(kont);
   }

function arg_fc() {
    return callcc(function(k) {
    k( function(x) {
    k( function(y) {
    return x; })})});
};


let f = arg_fc();
f(true);
print(f(false));

/*

Voy a explicar paso a paso lo que sucede en el código:

1. La función callcc se define para tomar una función f como argumento. Dentro de callcc, se crea una nueva instancia de Continuation llamada kont y se llama a f(kont), pasando esta instancia como argumento a la función f.

2. La función arg_fc se define para llamar a callcc y pasa una función anónima como argumento. Esta función anónima toma un argumento k, que es en realidad una instancia de Continuation. Dentro de esta función, se hacen dos llamadas a k con otras funciones anónimas como argumento. Estas funciones anónimas toman x e y respectivamente y devuelven x.

3. Finalmente, se llama a arg_fc y se almacena su resultado en la variable f. Luego, se llama a f(true), lo que inicia la ejecución del flujo de continuación.



Ahora, veamos cómo se ejecuta el código:

- Cuando se llama f(true), se ejecuta la función anónima en arg_fc, que toma x como argumento y devuelve x. Como se pasó true, la función devuelve true.

- Luego, se imprime el resultado de f(false). Aquí es donde entra en juego la técnica de continuaciones. Dado que la función k (en la función anónima de arg_fc) se llamó con x, lo que hizo fue "capturar" el valor x y devolverlo. Por lo tanto, la llamada f(false) también devuelve true, ya que se capturó la continuación que contenía x.

En resumen, la técnica de continuaciones permite "capturar" y controlar el flujo de ejecución en un punto particular, lo que hace que la llamada f(false) devuelva el valor capturado x, que es true. Por lo tanto, la salida final es 'True'.

*/