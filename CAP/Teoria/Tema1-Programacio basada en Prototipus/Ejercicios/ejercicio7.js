/*

El problema con el código en Singleton1wrong.js es que no implementa correctamente el patrón de Singleton. El Singleton es un patrón de diseño que garantiza que una clase tenga una única instancia y proporciona un punto de acceso global a esa instancia. En este código, el Singleton no se implementa correctamente debido a la forma en que se redefine la función Universe.

Aquí está el funcionamiento del programa y en qué punto falla:

Se define la función constructora Universe, que inicialmente almacena la instancia actual en la variable instance.

Se redefine la función Universe para que, en lugar de crear una nueva instancia, simplemente devuelva la instancia existente.

Se crea una instancia uni de Universe, y se establece la propiedad nothing en true en su prototipo.

Se crea una segunda instancia uni2 de Universe. Aquí es donde comienza el problema. Aunque uni2 se inicializa como una nueva instancia, debido a la redefinición de Universe, uni2 se convierte en una referencia a la misma instancia que uni.

A medida que se accede a las propiedades en los objetos uni y uni2, se nota que no todas las propiedades están definidas en su prototipo. Por lo tanto, uni.everything y uni2.everything son undefined, ya que se agregaron después de crear las instancias. Solo uni.nothing tiene un valor definido.

Además, las propiedades en el objeto uni y uni2 son compartidas y se refieren a los mismos valores. Por lo tanto, uni.bang y uni2.bang son iguales, al igual que uni.start_time y uni2.start_time.

Las comparaciones uni.constructor === Universe y uni2.constructor === Universe devuelven false, lo que indica que la redefinición de la función constructora ha afectado al objeto constructor.

En resumen, el problema radica en que las instancias uni y uni2 no son independientes, como se esperaría en un patrón Singleton. En cambio, se refieren a la misma instancia debido a la redefinición de la función constructora Universe. Esto hace que el patrón Singleton sea incorrecto en este código.

*/


/*
El problema és que en fer

Universe = function Universe () {
return instance;
};

mantenim el prototipus de l’objecte resultat de la primera crida a new Universe() i per tant
qualsevol propietat que s’hagi definit després de crear la primera (i única) instància de
Universe es perdrà (no serà visible).
*/