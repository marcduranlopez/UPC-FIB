#include <iostream>
using namespace std;
int main () {
    
    char a, b, c, d;
    bool found = false;
    
    cin >> d;
    a = d;
    b = d;
    c = d;
    while (d != '.' and not found) {
        
        if (a == 'h' and b == 'o' and c == 'l' and d == 'a'){
            found = true;
        }
        a = b;
        b = c;
        c = d;
        
        cin >> d;
    }
    
    if (found) cout << "hola" << endl;
    else cout << "adeu" << endl;
   
}
