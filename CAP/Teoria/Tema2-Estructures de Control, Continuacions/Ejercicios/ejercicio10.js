/*

Las funciones setjmp y longjmp en C permiten la implementación de saltos no locales y manejo de excepciones a nivel de sistema. Estas funciones son utilizadas para reemplazar la pila de llamadas y establecer un "punto de retorno" que puede ser saltado en cualquier momento utilizando longjmp. A continuación, se explica cómo funcionan y se compara con la función Continuation() en JavaScript/Rhino:


- setjmp: La función setjmp se utiliza para guardar el contexto actual de ejecución en una estructura de datos llamada jmp_buf. Esta estructura de datos almacena información sobre la posición actual en el código y otros datos necesarios para la ejecución. setjmp retorna 0 si se llama directamente y un valor distinto de 0 si se llama después de una llamada a longjmp. En otras palabras, establece el "punto de retorno" para futuros saltos.

- longjmp: La función longjmp se utiliza para saltar de nuevo a un "punto de retorno" previamente establecido por setjmp. Cuando se llama a longjmp, se restablece el contexto de ejecución al punto de retorno y la ejecución continúa desde ese punto.



Comparación con Continuation() en JavaScript/Rhino:

1. Similaridad: Tanto setjmp/longjmp en C como Continuation() en JavaScript/Rhino permiten la manipulación de la ejecución y la capacidad de saltar entre diferentes puntos del código.

2. Diferencias clave:

    - Contexto: En C, setjmp/longjmp trabajan a nivel de sistema y se utilizan para implementar manejo de excepciones o saltos no locales. En cambio, Continuation() en JavaScript/Rhino trabaja a nivel de función y permite la captura de continuaciones locales en un contexto más limitado.
    
    - Portabilidad: setjmp/longjmp son funciones específicas de C y pueden no estar disponibles en otros lenguajes. Continuation() es una función específica de JavaScript/Rhino y se adapta a las características del lenguaje.
    
    - Limitaciones: setjmp/longjmp pueden ser peligrosos y difíciles de usar correctamente, ya que pueden resultar en problemas de memoria y comportamientos inesperados si no se manejan con cuidado. Continuation() en JavaScript/Rhino ofrece un enfoque más controlado y limitado para capturar continuaciones dentro de funciones específicas.

En resumen, setjmp/longjmp y Continuation() son herramientas para controlar la ejecución y los saltos en el código, pero difieren en su alcance y complejidad. Las funciones en C permiten saltos no locales a nivel de sistema, mientras que Continuation() en JavaScript/Rhino permite capturar continuaciones locales en un contexto más controlado.

*/