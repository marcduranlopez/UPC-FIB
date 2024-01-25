function flip(f) {
    function aux(x,y) {
    return f(y,x)
    }
    return aux
} 

result = flip((x,y) => x - y)(5,3);
print(result);