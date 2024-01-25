// Singleton Pattern (second example)
// from JavaScript Patterns by Stoyan Stefanov, OReilly 2010 isbn 978-0-596-80675-0

let Universe; 

(function () {
    
    let instance; 
    
    Universe = function() {
        
	      if (instance) { 
	          return instance;
	      } 
        
	      instance = this;
        
	      // all the functionality 
	      this.start_time = 0; 
	      this.bang = "Big";
        
    }; 
}());

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

