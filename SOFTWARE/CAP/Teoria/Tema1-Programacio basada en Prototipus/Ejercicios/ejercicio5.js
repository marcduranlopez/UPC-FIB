/*

El problema que estás experimentando es que, aunque has configurado la herencia prototípica correctamente con B.prototype = Object.create(A.prototype), los métodos heredados de la clase A no funcionan como se esperaría en las instancias de B. Esto se debe a que los métodos heredados de A todavía hacen referencia a this como si fuera una instancia de A en lugar de B.

Para solucionar este problema, debes asegurarte de que los métodos heredados de A funcionen correctamente en las instancias de B. Puedes hacerlo llamando a los métodos heredados desde B y asegurándote de que this se refiera a la instancia de B. Esto se puede lograr utilizando el método call o apply.



Aquí hay una solución:

*/
function A() {
 this.a = 0;
 this.b = 1;
}
A.prototype.retornaA = function() { return this.a }
A.prototype.retornaB = function() { return this.b }

function B() {
 A.call(this); // Llamar al constructor de A en el contexto de B
 this.a = 100;
 this.c = 101;
}
B.prototype = Object.create(A.prototype);
B.prototype.constructor = B;
B.prototype.retornaC = function() { return this.c }

// Prueba
let aa = new A();
aa.a = aa.a + 1;
aa.b = aa.b + 1;
print(aa.retornaA()); // 1
print(aa.retornaB()); // 2

let bb = new B();
print(bb.retornaA()); // 100
print(bb.retornaB()); // 1 (heredado de A)
print(bb.retornaC()); // 101

/*

En este código, hemos llamado al constructor de A en el contexto de B utilizando A.call(this). Esto asegura que las propiedades y métodos de A se inicialicen correctamente en las instancias de B. Ahora, los métodos heredados de A funcionan correctamente en las instancias de B, y obtienes el resultado esperado.

*/