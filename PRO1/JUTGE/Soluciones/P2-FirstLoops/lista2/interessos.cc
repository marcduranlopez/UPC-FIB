#include <iostream>
using namespace std;
#include <cmath>
int main() {
cout.setf(ios::fixed); 
cout.precision(4);
    
    double c, i;
    double s = 0;
    int t;
    string a;
    
    cin >> c >> i >> t >> a;
    if (a == "simple") {
    for (int k = 0 ;  k < t ; ++k) {
        s = (s + c*(i/100));
    }
    }
    if (a == "compost") {
     for (int k = 0 ;  k < t ; ++k) {
        s = (s + (c+s)*(i/100));  
     }
    }

    cout << c+s << endl;
   
}
