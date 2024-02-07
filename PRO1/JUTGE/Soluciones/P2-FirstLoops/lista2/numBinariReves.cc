#include <iostream>
using namespace std;
int main() {
    int n, i;
    cin >> n;
    
    if (n == 0)
        cout << 0;
    
    for (i = n ; i != 0 ; i= i/2) {

    cout << i%2;
    }
    cout << endl;
}

    
