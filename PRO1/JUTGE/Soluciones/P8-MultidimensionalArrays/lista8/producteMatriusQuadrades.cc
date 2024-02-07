#include <iostream>
#include <vector>
using namespace std;

typedef vector < vector<int> > Matriu;

Matriu producte(const Matriu& a, const Matriu& b) {
    int n = a.size();
    Matriu c(n, vector<int>(n,0));
    
    for (int i = 0 ; i < n ; ++i) {
        
        for (int j = 0 ; j < n ; ++j) {
            int suma = 0;
            
            for (int k = 0; k < n ; ++k) {
                suma += a[i][k] * b[k][j];
            }
        c[i][j] = suma;
        }
    }
    return c;
}
    
