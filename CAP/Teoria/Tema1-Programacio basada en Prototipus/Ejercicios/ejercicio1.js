/*
L'introducció de let i const en ECMAScript 6 (ES6) va portar una nova semàntica a la gestió de l'abast de les variables en JavaScript. Per comprendre la diferència, primer hem d'entendre com funcionen les variables declarades amb var i després veure com let i const canvien aquest comportament.

Variables amb abast de funció (var):
Les variables declarades amb var tenen un abast de funció. Això significa que la variable està disponible des del punt en què es declara fins a la funció que la conté. Si declareu una variable amb var dins d'una funció, aquesta variable estarà disponible per a tot el cos de la funció, independentment de la ubicació de la seva declaració. A més, les variables declarades amb var són "elevades" (hoisting), el que significa que poden ser accessibles abans de la seva declaració real en el codi, però amb el valor undefined.

Exemple amb var:
*/

function example() {
  if (true) {
    var x = 10;
  }
  print(x); // La variable 'x' és accessible aquí amb el valor '10'
}


/*
Variables amb abast de bloc (let i const):
Amb l'ús de let i const, s'introdueixen variables amb abast de bloc. Això significa que la variable és accessible només dins el bloc en què es declara. Un bloc pot ser un parell de claus {} o una funció. Les variables declarades amb let i const tenen un comportament de "Temporal Dead Zone" (TDZ), el que significa que no poden ser accessibles abans de la seva declaració en el codi. Aquesta restricció evita possibles errors i fa que el comportament sigui més previsible.

Exemple amb let:
*/

function example() {
  if (true) {
    let x = 10;
  }
  print(x); // Error: 'x' no està definida a aquest punt
}


//Exemple amb const:

function example() {
  const y = 20;
  if (true) {
    print(y); // 'y' és accessible aquí amb el valor '20'
  }
  print(y); // 'y' també és accessible aquí amb el valor '20'
}


/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

En resum, la diferència principal és que var té abast de funció i no està subjecte al Temporal Dead Zone (TDZ), mentre que let i const tenen abast de bloc i estan subjectes al TDZ. Això fa que les variables declarades amb let i const siguin més previsibles i segures, evitant errors comuns relacionats amb l'abast i l'ús de les variables.


Exemple utilitzant variables let i var amb Temporal Dead zone:
*/

function example() {
  print(x); // undefined (hoisting de 'var')
  print(y); // Error: 'y' is not defined (Temporal Dead Zone de 'let')
  
  var x = 10;
  let y = 20;

  print(x); // 10
  print(y); // 20
}

example();

/*
En este ejemplo:

Se intenta acceder a la variable x antes de su declaración, y debido al hoisting de var, se muestra undefined. Sin embargo, la variable x está declarada en el ámbito de la función.

Se intenta acceder a la variable y antes de su declaración, y aquí es donde se produce el "Temporal Dead Zone" (TDZ). Intentar acceder a una variable let antes de su declaración genera un error.

Luego, se declara var x con un valor de 10 y let y con un valor de 20.

Finalmente, se muestra el valor de ambas variables x e y después de su declaración.

El TDZ ocurre cuando intentas acceder a una variable let o const antes de su declaración en el código, lo que puede generar un error, como se muestra en el ejemplo. Las variables var, en cambio, están sujetas al hoisting y pueden ser accedidas antes de su declaración, aunque con un valor undefined.


*/