function Cafe() { 
    this.price = 1;
    this.ingredients = "Cafe";
} 

Cafe.prototype.getPrice = function () {
    return this.price;
};

Cafe.prototype.getIngredients = function () {
    return this.ingredients;
};

Cafe.prototype.decorate = function (decorator) { 
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

// Els objecte decoradors s'implementaran com a propietats d'una 
// propietat del constructor
Cafe.decorators = {};

Cafe.decorators.llet = { 
    getPrice: function () {
      var price = this.uber.getPrice(); 
      price += 0.5; // suposem que afegir llet val 0.5 euros
      return price;
    },
        getIngredients: function () {
            var ing = this.uber.getIngredients(); 
            return ing + ", llet"
        }
};

Cafe.decorators.xocolata = { 
    getPrice: function () {
      var price = this.uber.getPrice(); 
      price += 0.75; // suposem que afegir xocolata val 0.75 euros
      return price;
    },
        getIngredients: function () {
        var ing = this.uber.getIngredients(); 
            return ing + ", xocolata"
        }
};

Cafe.decorators.crema = { 
    getPrice: function () {
      var price = this.uber.getPrice(); 
      price += 0.5; // suposem que afegir crema val 0.5 euros
      return price;
    },
        getIngredients: function () {
            var ing = this.uber.getIngredients(); 
            return ing + ", crema"
        }
};


var c = new Cafe(); 
c = c.decorate('llet'); 
c = c.decorate('xocolata'); 
c = c.decorate('crema'); 
print(c.getPrice());
print(c.getIngredients());
