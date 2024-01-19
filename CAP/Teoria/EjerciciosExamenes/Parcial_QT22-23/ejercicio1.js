function Arbre() {
    this.arbrenadal = 'Arbre';
}

Arbre.prototype.print = function () {
    return this.arbrenadal;
};
   
// No canvia respecte la que ja vam veure a classe...
Arbre.prototype.decorate = function (decorator) { 
    let overrides = this.constructor.decorators[decorator], // this és l'objecte que està a l'esquerra del '.'
        newobj;                                             // this.constructor seria l'objecte 'Sale'
    
    newobj = Object.create(this)
    newobj.uber = this   
    
    for (let i in overrides) {
	      if (overrides.hasOwnProperty(i)) { 
	          newobj[i] = overrides[i];  // copiem a newobj totes les propietats del decorador, en aquest cas només 
	      }                              // hi ha 'get_price'
    }
    
    return newobj;
};

// Els decoradors s'implementaran com a propietats d'una propietat del constructor
   
Arbre.decorators = {};

Arbre.decorators.Bola = {
    print: function () {
    let an = this.uber.print();
    an = 'Bola, ' + an;
    return an;
    }
};

Arbre.decorators.Cinta = {
    print: function () {
    let an = this.uber.print();
    an = 'Cinta, ' + an;
    return an;
    }
};

Arbre.decorators.Caramel = {
    print: function () {
    let an = this.uber.print();
    an = 'Caramel, ' + an;
    return an;
    }
};

ad = new Arbre();
ad = ad.decorate('Cinta');
ad = ad.decorate('Bola');
ad = ad.decorate('Bola');
print(ad.print()); // retorna ==> 'Bola, Bola, Cinta, Arbre'

ad = new Arbre();
ad = ad.decorate('Bola');
ad = ad.decorate('Caramel');
ad = ad.decorate('Cinta');
print(ad.print()); // retorna ==> 'Cinta, Caramel, Bola, Arbre'
