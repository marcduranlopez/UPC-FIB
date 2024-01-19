/*
a) En general, el prototipus d'un objecte-funció i el prototype d'aquest objecte-funció són el
mateix objecte?
b) Hi ha cap excepció a la regla general?
c) Per a què serveix el prototype d'un objecte-funció?


a) En general, el prototipo de un objeto-función (objecto que puede ser invocado como una función) y el objeto prototype de ese objeto-función no son el mismo objeto. El prototipo de un objeto-función es el objeto al que se accede mediante la propiedad prototype, mientras que el objeto prototype en sí es una propiedad que pertenece al objeto-función.

b) La excepción a esta regla general es que, si no se modifica explícitamente la propiedad prototype de la función, el prototipo del objeto-función y el objeto prototype serán el mismo objeto por defecto.

c) El objeto prototype de una función se utiliza principalmente para establecer propiedades y métodos que estarán disponibles en todas las instancias creadas a partir de esa función mediante el operador new. Esto se utiliza comúnmente en la programación orientada a objetos en JavaScript para definir métodos compartidos entre las instancias de un objeto.

Por ejemplo:


*/
function Person(name) {
  this.name = name;
}

// Definimos un método en el objeto prototype
Person.prototype.sayHello = function() {
  print(`Hello, my name is ${this.name}`);
}

const person1 = new Person('Alice');
const person2 = new Person('Bob');

person1.sayHello(); // "Hello, my name is Alice"
person2.sayHello(); // "Hello, my name is Bob"


/*
En este caso, el método sayHello se define en el objeto prototype de la función Person, y todas las instancias creadas a partir de Person tienen acceso a ese método. Esto ahorra memoria, ya que no se duplica el método en cada instancia, y permite compartir funcionalidad entre las instancias.

*/