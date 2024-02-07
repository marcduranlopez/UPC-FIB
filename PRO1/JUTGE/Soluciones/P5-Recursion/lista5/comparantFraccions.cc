#include <iostream>
#include <cmath>
using namespace std;

bool c_frac(int n1, int d1, int n2, int d2) {
    double a = double(n1)/d1;
    double b = double(n2)/d2;
    return a < b;
    
}


int main () {
    int n1, d1, n2, d2;
    cin >> n1>> d1 >> n2 >> d2;
        
    
    cout << (c_frac(n1, d1, n2, d2)) << endl;
    
}
