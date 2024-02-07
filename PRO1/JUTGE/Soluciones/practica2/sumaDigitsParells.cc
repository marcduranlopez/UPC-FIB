#include <iostream>
#include <cmath>
#include <vector>
using namespace std;


int suma_parells(int x) {
    
    if (x < 10 and x%2 == 0) return x;
    else {
        if ((x%10)%2 == 0) {
            return (x%10 + suma_parells(x/10));
        }
        else {
            return suma_parells(x/10);
        }
    }
}
            

int main() {
    int x;
    while (cin >> x) {
        cout << suma_parells(x) << endl;
    }
}
