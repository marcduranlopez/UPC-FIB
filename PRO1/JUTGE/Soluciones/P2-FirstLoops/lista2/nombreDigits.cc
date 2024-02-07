#include <iostream>
using namespace std;
int main() {
    int n, count; 
    cin >> n;
    
    cout << "El nombre de digits de " << n << " es ";
    for (count = 1; n > 9; count = count + 1) {
        n/=10;
    }
        cout << count << "." << endl;
    }
