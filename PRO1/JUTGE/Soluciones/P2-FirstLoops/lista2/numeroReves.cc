#include <iostream>
using namespace std;
int main() {
    int n;
    cin >> n;
    
    if (n == 0)
        cout << 0;
    
    
    for (int i = n; i > 0; i = i/10) {
        cout << i % 10;
    }
        cout << endl;
    }
