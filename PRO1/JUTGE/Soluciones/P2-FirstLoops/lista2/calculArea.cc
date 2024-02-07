#include <iostream>
using namespace std;
#include <cmath>
int main() {
    cout.setf(ios::fixed);
    cout.precision(6);
    
    int n;
    string forma;
    double a, b, c;
    
    cin >> n;
    
    for (int i = 0 ; i < n ; ++i) {
        cin >> forma;
    
    if (forma == "rectangle") {
        cin >> a >> b;
        cout << a*b << endl;
    }
    
    if (forma == "cercle") {
        cin >> c;
        cout << M_PI * (c*c) << endl;
    }
}

}

    
