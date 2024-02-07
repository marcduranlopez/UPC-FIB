#include <iostream>
using namespace std;
int main() {
    
    int n;
    
    while (cin >> n) {
        
        if (n < 10) cout << "El producte dels digits de " << n << " es " << n  << "." << endl;
        
        else {
            while (n > 9) {
            cout << "El producte dels digits de " << n << " es ";
            
            int p = 1;
            while (n != 0) {
                
                p*= n%10;
                n/= 10;
                
                }
                cout << p << "." << endl;
                n = p;
                }
        }
        
           cout << "----------" << endl;
        }
    }

    
