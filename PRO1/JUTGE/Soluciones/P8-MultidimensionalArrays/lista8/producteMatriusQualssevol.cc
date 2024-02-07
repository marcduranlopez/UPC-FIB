#include <iostream>
#include <vector>
using namespace std;

typedef vector < vector<int> > Matriu;

Matriu producte(const Matriu& a, const Matriu& b) {
    int n = a.size();
    int m = a[0].size();
    int p = b[0].size();
    Matriu c(n, vector<int>(p,0));
    
    for (int i = 0 ; i < n ; ++i) {
        
        for (int j = 0 ; j < p ; ++j) {
            int suma = 0;
            
            for (int k = 0; k < m ; ++k) {
                suma += a[i][k] * b[k][j];
            }
        c[i][j] = suma;
        }
    }
    return c;
}
    
