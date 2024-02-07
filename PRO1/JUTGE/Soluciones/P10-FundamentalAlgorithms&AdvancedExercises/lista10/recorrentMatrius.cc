#include <iostream>
#include <vector>
using namespace std;

typedef vector < vector<int> > Matriu;


void read_Matrix(Matriu& M) {
    int f = M.size();
    int c = M[0].size();
    for (int i = 0; i < f; ++i) {
        for (int j = 0; j < c; ++j) {
            cin >> M[i][j];
        }
    }
}

int suma_linia(const Matriu& M, int of, int oc, int df, int dc) {
    int suma = 0;
    int baixar = 2;
    int dreta = 2;
    if (of == df and oc < dc) dreta = 1;
    else if (of == df and oc > dc) dreta = 0;
    else if (oc == dc and of < df) baixar = 1;
    else if (oc == dc and of > df) baixar = 0;
    
    if (dreta == 1) {
        while (oc < dc) {
            ++oc;
            suma += M[of][oc];
        }
    }
    
    if (dreta == 0) {
        while (oc > dc) {
            --oc;
            suma += M[of][oc];
        }
    }
    
    if (baixar == 1) {
        while (of < df) {
            ++of;
            suma += M[of][oc];
        }
    }
    
    if (baixar == 0) {
        while (of > df) {
            --of;
            suma += M[of][oc];
        }
    }
    
    return suma;
}


int main() {
    int f,c;
    cin >> f >> c;
    
    Matriu M(f, vector<int>(c));
    read_Matrix(M);
    
    int x, y, suma = 0;
    bool primer = true;
    int of, oc;
    
    while (cin >> x >> y) {
        if (primer) {
            suma = M[x][y];
            primer = false;
        }
        else {
            suma += suma_linia(M, of, oc, x, y);
        }
        
        of = x;
        oc = y;
    }
    cout << "suma = " << suma << endl;
}
        
    
