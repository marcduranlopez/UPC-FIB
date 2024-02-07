#include <iostream>
using namespace std;
int main() {
    int n, i, count, initial; 
    cin >> n;
    
    initial = n;
    for (i = 2; i <= 16; i = i + 1) {
        
        for (count = 1; n >= i; count= count + 1) {
           n = n / i;
        }
    
        cout << "Base " << i << ": " << count << " cifras." << endl;
        n = initial;
    }
}
