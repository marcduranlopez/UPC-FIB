#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

double producte_escalar(const vector<double>& u, const vector<double>& v) {
    int n = u.size();
    double suma = 0;
    for (int i = 0 ; i < n ; ++i) {
        suma += (u[i]*v[i]);
    }
    return suma;
}

int main() {
    int n;
    cin >> n;
    vector <double> u(n);
    vector <double> v(n);
    
    for (int i = 0 ; i < n ; ++i) {
        cin >> u[i];
        cin >> v[i];
    }
    cout << producte_escalar(u, v) << endl;
}

