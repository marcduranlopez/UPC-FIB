#include <iostream>
using namespace std;
int main() {
    cout.setf(ios::fixed);
     cout.precision(2);
     
    double n, x; 
    double s = 0;
    double v = 0;
    cin >> n;
    
    while (cin >> x) {
    
    v += (1/ (n-1))* x*x;
    s += x;
}
    v-= (1/(n*(n-1))) * s*s;
    
    cout << v << endl;
}
        
        
    
    

