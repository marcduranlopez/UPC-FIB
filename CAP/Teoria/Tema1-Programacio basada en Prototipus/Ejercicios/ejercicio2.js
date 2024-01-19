let temp
function f(x) {
    let temp = x
    return function () { return temp }
}
function g(x) {
    temp = x
    return function () { return temp }
}
// [a,b,c,...].map(foo) aplica foo a cada element i retorna
// [foo(a),foo(b),foo(c),...]
let qf = [1,2,3,4,5].map(f)
let qg = [1,2,3,4,5].map(g)
// [a,b,c,...].forEach(foo) aplica foo a cada element però no retorna res
// (undefined)
qf.forEach(function (e) {print(e())})
print("----")
qg.forEach(function (e) {print(e())})


/*

El resultado del código se debe a cómo se manejan las variables temp en las funciones f y g, y cómo se utilizan las funciones map y `forEach.

Primero, vamos a analizar el comportamiento de las funciones f y g:

La función f toma un argumento x y declara una variable local temp que almacena el valor de x. Luego, devuelve una función anidada que simplemente devuelve el valor de temp.
La función g también toma un argumento x, pero en este caso, actualiza la variable global temp con el valor de x. Luego, también devuelve una función que retorna el valor de temp.
A continuación, se utiliza map para aplicar estas funciones a un array [1, 2, 3, 4, 5] y se almacena el resultado en los arrays qf y qg. Esto crea un array de funciones que, cuando se ejecutan, devuelven el valor correspondiente de temp según la función f o g utilizada.

Finalmente, se utiliza forEach para ejecutar cada una de las funciones almacenadas en qf y qg, y se muestra el resultado.

El resultado se explica de la siguiente manera:

En el caso de qf, cada función interna captura el valor de temp en el momento de su creación. Como se utiliza let para declarar temp en f, cada función interna mantiene su propia referencia al valor de temp que se estableció cuando se creó. Por lo tanto, cuando se ejecutan, devuelven los valores 1, 2, 3, 4 y 5 respectivamente.

En el caso de qg, todas las funciones internas apuntan a la variable global temp, que se actualiza en cada llamada a g. Cuando se ejecutan las funciones internas, todas devuelven el valor actual de temp, que se establece en 5 al final del código. Por lo tanto, todas las funciones internas devuelven 5.

En resumen, qf muestra valores de 1 a 5 debido a que cada función interna captura su propio valor de temp en el momento de la creación, mientras que qg muestra 5 en todas las llamadas debido a que todas las funciones internas apuntan a la misma variable global temp, que se establece en 5 al final.

*/