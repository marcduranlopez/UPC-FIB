function callcc(f) {
    let kont = new Continuation();
    return f(kont);
}

function arg_fc() {
    return callcc(function(k) {
    k( function(x) {
    k( function(y) {
    return x; })})});
};


let g = arg_fc();
g(2);
print(g(1000));


/*

Aquest programa, en ser executat per primer cop, arg_fc(), retorna la funció:

function(x) {
 k( function(y) {
 return x;
})
}

que és assignada a g. En fer g(2) s’executa aquesta funció, que torna al punt on vam retornar una
funció que va ser assignada a g. Aquest cop, la funció assignada a g és:

function(y) {
 return x;
}

que, com la primera invocació ha estat amb paràmetre 2, x té com a valor 2. Aquesta funció sempre
retornarà 2, no importa quin sigui el seu argument.
Així doncs, bastant obvi a partir d’aquest experiment, hem aconseguit una funció que, a partir de la
segona invocació, sempre retornarà l’argument de la primera invocació. Així, en fer
print(g(1000)) s'escriurà 2.

*/