#include <iostream>
using namespace std;
int main() {
    int b, a;
    
    cin >> b;
    
    while (cin >> a) {
        cout << a << ": ";
        
    int s = 0;
    
    for (int i = a ; i > 0 ; i/= b) {
        s += (i%b);

    
    }
cout << s << endl;
}
}       
    
    

