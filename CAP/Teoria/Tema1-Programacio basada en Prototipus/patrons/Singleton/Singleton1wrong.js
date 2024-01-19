function Universe() {
	  let instance = this;
    
	  this.start_time = 0;
	  this.bang = "Big";
    
	  Universe = function Universe () {
		    return instance;
	  };
}

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

