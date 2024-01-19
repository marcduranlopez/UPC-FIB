// Singleton Pattern (first example)
// from JavaScript Patterns by Stoyan Stefanov, OReilly 2010 isbn 978-0-596-80675-0

// El problema aquí és que la propietat instance és pública (!)

function Universe() {
    
    if (typeof Universe.instance === "object") {
	      return Universe.instance;
    }
    
    this.start_time = 0;
    this.bang = "Big";
    
    Universe.instance = this;
};

Universe.prototype.nothing = true;

let uni = new Universe();

Universe.prototype.everything = true;

let uni2 = new Universe();



print(uni === uni2);
print(uni.nothing && uni.everything && uni2.everything && uni2.nothing);
print(uni.bang);
print(uni2.bang);
print(uni.start_time);
print(uni2.start_time);
print(uni.constructor === Universe);
print(uni2.constructor === Universe);
