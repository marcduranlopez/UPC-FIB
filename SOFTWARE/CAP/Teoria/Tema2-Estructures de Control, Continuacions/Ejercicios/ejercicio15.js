function callcc(f) {
    kont = new Continuation();
    return f(kont)
}

function twicecc(coll) {
    return callcc(function (f) {
        function tmp1(n) {
            return f([n,coll[1]])
        }
        function tmp2() {
            return callcc(function(q) {
                return f([coll[0],q])
            })
        } 
        return tmp1(tmp2())
    })
}

arr = twicecc([0, function(x) { return x } ])
print(arr[1](arr[0]+1))


/*

1. callcc toma una función f como argumento y crea una nueva instancia de Continuation llamada kont. Luego, llama a f(kont) con esta instancia como argumento.

2. twicecc se llama con [0, function(x) { return x; }] como argumento.

3. Dentro de twicecc, se llama a callcc con una función anónima que toma un argumento f. Dentro de esta función anónima, se definen dos funciones: tmp1 y tmp2.

4. La función tmp2 contiene otra llamada a callcc con una función anónima que toma un argumento q.

5. Cuando se ejecuta tmp2, se llama a callcc con la función anónima que toma q como argumento. Esto significa que q captura el flujo de ejecución en este punto.

6. Dentro de tmp2, se llama a f([coll[0], q]). coll[0] es 0, y q es la continuación que capturó el flujo de ejecución en el paso anterior.

7. Luego, se devuelve [0, q] y este valor se usa como argumento para tmp1.

8. Ahora, tmp1 toma [0, q] como argumento y ejecuta f([n, coll[1]]), donde n es 0 y coll[1] es la función function(x) { return x; }.

9. Dentro de tmp1, se llama a f([0, coll[1]]). La función f captura este valor y lo devuelve como resultado de la llamada a twicecc.

10. Entonces, arr contiene [0, function(x) { return x; }]. La siguiente línea de código print(arr[1](arr[0] + 1)); se traduce en print(function(x) { return x; }(0 + 1));.

11. Finalmente, print muestra el resultado, que es 2.


En este contexto específico, debido a la implementación personalizada de continuaciones, el resultado es 2. 

*/

/*

function callcc(f) {
    kont = new Continuation();
    return f(kont);
}

La función callcc toma una función f como argumento. Cuando se llama a callcc, se pasa una función anónima a f(kont). En este contexto, f es la función que se va a ejecutar con kont como argumento.

En resumen, cuando digo que una función "toma una función 'f' como argumento", significa que puedes pasar una función como argumento a esa función y utilizarla en la lógica interna de la función receptora. Esto es una característica fundamental de la programación funcional y permite una mayor flexibilidad en la manipulación de funciones.

*/