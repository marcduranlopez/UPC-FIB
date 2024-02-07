#include <iostream>
#include <vector>
using namespace std;

typedef vector < vector <int> > Matriu;

int main() {
    int f, c;
    cin >> f >> c;
    
    Matriu hab(f, vector<int>(c));
    for (int i = 0; i < f; ++i) {
        for (int j = 0; j < c; ++j) {
            cin >> hab[i][j];
        }
    }
    int suma = 0;
    for (int j = 0; j < c; ++j) {
        
        if (j%2 == 0) {
            for (int i = 0; i < f; ++i) {
                if (hab[i][j] == 0) cout << i << ' ' << j << endl;
                else suma += hab[i][j];
            }
        }
        else if (j%2 != 0) {
            for (int i = f-1; i >= 0; --i) {
                if (hab[i][j] == 0) cout << i << ' ' << j << endl;
                else suma += hab[i][j];
            }
        }
            
        cout << "Total en columna " << j << ": " << suma << endl;
    }
}
            
    
    
