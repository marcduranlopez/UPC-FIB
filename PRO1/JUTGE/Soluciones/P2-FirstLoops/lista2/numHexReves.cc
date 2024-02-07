#include <iostream>
using namespace std;
int main() {
    int n, i, hex;
    cin >> n;
    
    if (n == 0)
        cout << 0;
    
    for (i = n ; i != 0 ; i= i/16) {
            hex = i%16;
            
        if (hex < 10) cout << hex;
        
        else if (hex == 10) cout << 'A';
        else if (hex == 11) cout << 'B';
        else if (hex == 12) cout << 'C';
        else if (hex == 13) cout << 'D';
        else if (hex == 14) cout << 'E';
        else if (hex == 15) cout << 'F';
    
    }
    cout << endl;
}
