
//Exemple del cafe

function Cafe() { 
    this.price = 1;
    this.ingredients = [];
} 

Cafe.prototype.getPrice = function () {
    let price = this.price,
        max = this.ingredients.length,
        name;
    
    for (let i=0; i < max; i += 1) {     // això s'ha de fer per a tots els mètodes "decorables"
	      name = this.ingredients[i];
	      price = this.constructor.decorators[name].getPrice(price);
    }
    
    return price;
};


Cafe.prototype.decorate = function (decorator) { 
    this.ingredients.push(decorator);
};

Cafe.prototype.getIngredients = function() {
    return this.ingredients;
}

// Els objecte decoradors s'implementaran com a propietats d'una propietat del constructor
Cafe.decorators = {};

Cafe.decorators.llet = { 
    getPrice: function (price) {
	      return price + 0.5; 
    }
};

Cafe.decorators.xocolata = { 
    getPrice: function (price) {
	      return price + 0.75; 
    }
};

Cafe.decorators.crema = { 
    getPrice: function (price) {
	      return price + 0.5; 
    }
};


var c = new Cafe();
c.decorate('llet');
c.decorate('xocolata');
c.decorate('crema');
print(c.getPrice());
print('Cafe, ' + c.getIngredients().join(', '));