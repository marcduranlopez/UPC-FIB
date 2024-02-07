#include <iostream>
#include <cmath>
using namespace std;

int quadrat(int x) {
    x = x*x;
    return x;
}

double arrel_quadrada(double x) {
    cout.setf(ios::fixed);
    cout.precision(6);    
    
    x = sqrt(x);
    return x;
}

int main() {
    int x;
    
    while (cin >> x) {
     cout << quadrat(x) << ' ' << arrel_quadrada(x) << endl;    
        
    }
    
}
