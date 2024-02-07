#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

typedef vector< vector<int> > Matriu;

Matriu read_matriu(Matriu& m) {
    int f = m.size();
    int c = m[0].size();
    
    Matriu mat(f, vector<int>(c));
    for (int i = 0; i < f; ++i) {
        for (int j = 0; j < c; ++j) {
            cin >> mat[i][j];
        }
    }
    return mat;
}

bool mateixa_columna(Matriu& m, int c1, int c2) {
    for (int i = 0; i< m.size(); ++i) {
        if (m[i][c1] != m[i][c2]) return false;
    }
    return true;
}

bool new_column(Matriu& m, int j) {
    for (int i = 0; i < j; ++i) {
        if (mateixa_columna(m, j,i)) return false;
    }
    return true;
}
    

int main() {
    int f, c;
    
    while (cin >> f >> c) {
        
        Matriu m(f, vector<int>(c));
        m = read_matriu(m);
        
        int col = 0;
        for (int j = 0; j < c; ++j) {
            if (new_column(m, j)) ++col;
        }
        cout << col << endl;
    }        
}
    
    
    
