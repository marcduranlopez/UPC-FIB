/**********************************************

Simplificacions:

- Els tags són strings, no poden haver tags repetits simultàniament
  (podem, però, fer servir un tag més d'un cop si no estan vigents a
  l'hora).

- No es poden fer servir non-local exits (continuacions, excepcions,
  etc)

Al tanto! Sí que es poden fer servir continuacions en la
*implementació* de my_catch i my_throw (de fet, no teniu més remei!),
el que vull dir és que en el codi que fa servir my_catch i/o my_throw,
no ha d'haver non-local exits. Això simplifica molt la implementació.

**********************************************/

function Continuation() {
  this.value = null;
  this.tag = null;
  this.isThrown = false;
}

function my_catch(tag, func) {
  var continuation = new Continuation();
  continuation.tag = tag;

  try {
    func(continuation);
    return continuation.value || continuation.returnValue;
  } catch (e) {
    if (e instanceof Continuation && e.tag === tag) {
      return e.value;
    } else {
      throw e;
    }
  }
}

function my_throw(tag, value) {
  var continuation = new Continuation();
  continuation.tag = tag;
  continuation.value = value;
  continuation.isThrown = true;
  throw continuation;
}


// Ejemplos de uso:

print('Tests enunciat:\n');

// a/
print("Caso a/ - Uso normal de my_catch sin my_throw:");
print(
  my_catch('etiqueta', function (cont) {
    cont.returnValue = 2 + 3 * 100;
  })
); // ==> imprime 302
print("\n");

print("Caso a/ - Uso de my_throw en medio de la ejecución del thunk:");
print(
  my_catch('etiqueta', function (cont) {
    cont.returnValue = 2 + 3 * my_throw('etiqueta', 100);
  })
); // ==> imprime 100
print("\n");

// b/
function test(x, cont) {
  cont.returnValue = 2 + 3 * (x === 0 ? my_throw('etiqueta', 100) : 100);
}

print("Caso b/ - Uso de my_catch en una función externa:");
print(
  my_catch('etiqueta', function (cont) {
    test(1, cont);
  })
); // imprime 302
print("\n");

print("Caso b/ - Uso de my_catch en una función externa con my_throw:");
print(
  my_catch('etiqueta', function (cont) {
    test(0, cont);
  })
); // imprime 100
print("\n");

// c/
function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}

function check(x, cont) {
  if (x === 0) {
    my_throw('zero', 'zero');
  } else if (x === 1) {
    my_throw('one', 'one');
  }
  cont.returnValue = x;
}

print("Caso c/ - Uso de my_catch en un bucle:");
print(
  my_catch('zero', function (cont) {
    for (var i = 0; i < 10; i++) {
      print(
        my_catch('one', function (cont) {
          check(getRandomInt(5), cont);
        })
      );
    }
    cont.returnValue = 'finito';
  })
);
print("\n");



print('\n' + 'Tests adicionals:' + '\n');

// Caso 1: Uso normal de my_catch sin my_throw
print("Caso 1:");
print(my_catch('tag1', function (cont) {
  cont.returnValue = 'Hello, World!';
})); // Debería imprimir 'Hello, World!'
print("\n");

// Caso 2: Uso de my_throw en medio de la ejecución del thunk
print("Caso 2:");
my_catch('tag2', function (cont) {
  print('Before my_throw');
  my_throw('tag2', 'Exception occurred!');
  print('After my_throw (never executed)');
  cont.returnValue = 'This should not be returned';
}); // Debería imprimir 'Before my_throw'
print("\n");

// Caso 3: Uso de my_throw con tag no existente
print("Caso 3:");
try {
  my_throw('nonexistent_tag', 'This should cause an error');
} catch (error) {
  print("Tag " + error.tag + " no existeix");
}
print("\n");

// Caso 4: Uso de my_catch sin tag
print("Caso 4:");
try {
  my_catch(undefined, function (cont) {
    cont.returnValue = 'This should not throw an error';
  });
  print("Success");
} catch (error) {
  print("Unexpected error");
}
// Debería imprimir "Success" ya que el uso de my_catch sin tag debería ser válido
// Resultado esperado: Success
print("\n");

// Caso 5: Uso de my_throw sin tag
print("Caso 5:");
try {
  my_throw(undefined, 'This should cause an error');
} catch (error) {
  print("Error thrown: " + error.message);
}
// Debería imprimir un error indicando que el tag no está definido
// Resultado esperado: Error thrown: Tag undefined no existe
print("\n");

