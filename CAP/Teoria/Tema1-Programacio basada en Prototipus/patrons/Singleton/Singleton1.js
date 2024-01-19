// Singleton Pattern (first example)
// from JavaScript Patterns by Stoyan Stefanov, OReilly 2010 isbn 978-0-596-80675-0

function Universe() {
    let instance;
    
    Universe = function() {
	      return instance;   // si instance = undefined retorna this (si invocat amb new)
    };
    
    Universe.prototype = this;
    
    instance = new Universe();
    
    this.constructor = Universe;
    
    instance.start_time = 0;
    instance.bang = "Big";
    
    return instance;
};

Universe.prototype.nothing = true;

let uni = new Universe;

Universe.prototype.everything = true;

let uni2 = new Universe;

print(uni === uni2);
print(uni.nothing && uni.everything && uni2.everything && uni2.nothing);
print(uni.bang);
print(uni2.bang);
print(uni.start_time);
print(uni2.start_time);
print(uni.constructor === Universe);
print(uni2.constructor === Universe);
