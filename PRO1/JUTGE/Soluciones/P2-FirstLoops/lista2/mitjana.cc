#include <iostream>
using namespace std;
#include <cmath>
int main() {
cout.setf(ios::fixed); 
cout.precision(2);
    
    double a, d;
    double s = 0;
    
    for (d = 0 ; cin >> a ; ++d) {
        s += a;
    }
    
    cout << s/d << endl;
   
}
