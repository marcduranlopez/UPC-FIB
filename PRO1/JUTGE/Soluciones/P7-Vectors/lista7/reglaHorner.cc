#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int avalua(const vector<int>& p, int x) {
    int n = p.size(), suma = 0, aux;
    for (int i = 0 ; i < n ; ++i) {
        aux = pow(x,i);
        suma += (p[i] * aux);
    }
    return suma;
}

int main() {
    int n, x;
    
    cin >> n;
    
    vector <int> v(n);
    for (int i = 0; i < n ; ++i) {
        cin >> v[i];
    }
    cin >> x;
    cout << avalua(v, x) << endl;
}

