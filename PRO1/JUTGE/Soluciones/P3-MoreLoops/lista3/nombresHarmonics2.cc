#include <iostream>
using namespace std;
int main() {
    cout.setf(ios::fixed);
    cout.precision(10);
    
    int n, m;
    
    while (cin >> n >> m) {
    double hn = 0.0;
    ++m;
    
    while (m <= n) {
        hn += 1.0/m;
        ++m;
    }
        cout << hn << endl;
    }
}
