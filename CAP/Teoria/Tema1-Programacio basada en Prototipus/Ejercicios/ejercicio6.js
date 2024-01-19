/*
Para lograr que los objetos creados por la función constructora C hereden propiedades de las funciones constructoras A y B, puedes establecer la cadena de prototipos adecuadamente. En JavaScript, puedes lograrlo utilizando el método Object.create() para establecer los prototipos.

Aquí hay un ejemplo de cómo puedes definir las funciones constructoras A, B y C para que funcionen de la manera que describiste:

*/

function A() {
    this.propA = "a";
  }
  
  function B() {
    this.propB = "b";
  }
  
  // Utilizamos Object.create para establecer el prototipo de B como una instancia de A
  B.prototype = Object.create(A.prototype);
  
  function C() {
    this.propC = "c";
  }
  
  // Utilizamos Object.create para establecer el prototipo de C como una instancia de B
  C.prototype = Object.create(B.prototype);
  
  let c = new C();
  
  console.log(c.propA); // "a"
  console.log(c.propB); // "b"
  console.log(c.propC); // "c"
  

/*

En este código, hemos establecido el prototipo de B como una instancia de A usando Object.create(A.prototype). Luego, establecemos el prototipo de C como una instancia de B usando Object.create(B.prototype). De esta manera, los objetos creados por la función constructora C heredan las propiedades de A y B, como se muestra en la salida.

*/