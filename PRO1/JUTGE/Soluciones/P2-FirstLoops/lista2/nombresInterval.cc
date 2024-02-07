#include <iostream>
using namespace std;
int main() {
    int a, b, i;
    cin >> a >> b;
    
    if (a <= b) {
        cout << a;
    } else { cout << "";
    }
    
    for (i = a+1; i <= b; i = i +1) {
        cout << "," << i;
    }
        cout << endl;

    }
