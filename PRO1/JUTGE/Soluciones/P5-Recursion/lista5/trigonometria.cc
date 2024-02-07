#include <iostream>
#include <cmath>
using namespace std;

double fsin(double x) {
    cout.setf(ios::fixed);
    cout.precision(6);
    
    x = (x*M_PI)/180;
    x = sin(x);
    return x;
}

double fcos(double x) {
    cout.setf(ios::fixed);
    
    cout.precision(6);    
    x = (x*M_PI)/180;
    x = cos(x);
    return x;
}

int main() {
    double x;
    
    while (cin >> x) {
     cout << fsin(x) << ' ' << fcos(x) << endl;    
        
    }
    
}
