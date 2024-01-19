// Factory Pattern
// from JavaScript Patterns by Stoyan Stefanov, OReilly 2010 isbn 978-0-596-80675-0

// constructor
function FabricaConsoles() {}

// Mètode  de la classe pare
FabricaConsoles.prototype.marca = function () {
    return "Consola de joc: " + this.propiedad;
};

FabricaConsoles.prototype.maxfps = function () {
    return "Maxim d'fps " + this.fps;
};

// el mètode estàtic de la fàbrica

FabricaConsoles.factory = function (type) {
    let constr = type, 
        newconsole;
    
    if (typeof FabricaConsoles[constr] !== "function") {  // error si el constructor no existeix
	      throw { name: "Error",
		            message: constr + " doesn't exist"
	            };
    }
    
    if (typeof FabricaConsoles[constr].prototype.marca !== "function") { // el constructor existeix,
        FabricaConsoles[constr].prototype =  new FabricaConsoles();              // hereda el pare, només 1 cop
	    FabricaConsoles[constr].prototype.constructor = FabricaConsoles[constr];	
    }
    
    newconsole = new FabricaConsoles[constr](); // crea una nova instància 
    
    // aqui podriem fer més feina i en acabar retornem...
    
    return newconsole;
}

// defineix objectes que pot fabricar, en forma de constructors associats a propietats de la fàbrica
FabricaConsoles.ps5 = function () {
    this.propiedad = 'sony';
    this.fps = 120;
}; 
FabricaConsoles.xbox = function () {
    this.propiedad = 'microsoft';
    this.fps = 120;
}; 


let ps = FabricaConsoles.factory('ps5');
let xb = FabricaConsoles.factory('xbox');
print(ps.marca());
print(ps.maxfps());
print(xb.marca());
print(xb.maxfps());