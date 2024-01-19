//Ejemplo incorrecto del ejercicio:

(function () {
    let value = 0;
    let kont = new Continuation();
    print(value);
    if (value === 5)
    print("Ha arribat a 5 gracies a la continuacio");
    else {
    value++;
    kont(kont);
    }
})(); 


//ejercicio correcto visto en clase (slide19):

function current_continuation() {
    print("Agafem la continuacio");
    return new Continuation();
}

let value = 0,
    kont = current_continuation();

print(value);
if (value === 5) {
    print("Ha arribat a 5 gracies a la continuacio");
} else {
    value++;
    kont(kont);
}

/*

El programa que proporcionaste, a diferencia del ejemplo correcto, no imprime todos los valores del 0 al 5 porque la forma en que se utiliza la continuación es diferente y no permite que se ejecute correctamente.

En el ejemplo incorrecto, se crea una variable value inicializada en 0 y una continuación kont. Luego, se imprime el valor de value. Si value es igual a 5, se imprimirá el mensaje "Ha arribat a 5 gracies a la continuacio". De lo contrario, se incrementa value en 1 y se llama a kont(kont).

El problema principal es que en este programa, la llamada kont(kont) simplemente reanuda la ejecución en el punto en que se detuvo, que es justo antes de la impresión inicial de value. Por lo tanto, el valor de value se imprimirá repetidamente como 0, pero no se incrementa ni se permite que se llegue a 5.

En el ejemplo correcto, la continuación se captura en un contexto más apropiado, antes de la impresión inicial de value. Esto permite que el programa continúe después de la impresión, y el valor de value se incrementa correctamente en cada iteración.

Para que el programa funcione correctamente e imprima todos los valores del 0 al 5, la continuación debe capturarse en el contexto adecuado, como se muestra en el ejemplo correcto que proporcionaste.

*/

