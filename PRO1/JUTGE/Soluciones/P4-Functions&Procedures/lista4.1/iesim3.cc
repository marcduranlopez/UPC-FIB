#include <iostream>
using namespace std;
int main() {
    
    int n, m, pos = 1;

    cin >> n;
    
    bool found = false;
    
   while (not found and cin >> m) {
   if (pos == n) found = true;
   else ++pos;
   }
        
   if (found) cout << "A la posicio " << n << " hi ha un " << m << "." << endl;
       
   else cout << "Posicio incorrecta." << endl;
       
   
}


