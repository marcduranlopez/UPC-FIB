#include <iostream>
#include <vector>
using namespace std;

typedef vector <int> Fila;
typedef vector <Fila> Matriu;


void llegir_matriu(Matriu& M) {
    int f = M.size();
    int c = M[0].size();
    
    for (int i =0; i < f; ++i) {
        for (int j=0; j < c; ++j) {
            cin >> M[i][j];
        }
    }
}

bool incresing_d (const Matriu& M, int a, int b) {
    int f = M.size();
    int c = M[0].size();
    
    int i = a-1, j = b+1, comp = M[a][b];
    while (i >= 0 and j < c) {
        if (M[i][j] > comp) comp = M[i][j];
        else return false;
        --i;
        ++j;
    }
    
    i = a-1, j = b-1, comp = M[a][b];
    while (i >= 0 and j >= 0) {
        if (M[i][j] > comp) comp = M[i][j];
        else return false;
        --i;
        --j;
    }
    
    i = a+1, j = b-1, comp = M[a][b];
    while (i < f and j >= 0) {
        if (M[i][j] > comp) comp = M[i][j];
        else return false;
        ++i;
        --j;
    }
    
    i = a+1, j = b+1, comp = M[a][b];
    while (i < f and j < c) {
        if (M[i][j] > comp) comp = M[i][j];
        else return false;
        ++i;
        ++j;
    }
    return true;
}
    

int main() {
    int f, c;
    while (cin >> f >> c) {
        
        Matriu M(f, Fila(c));
        llegir_matriu(M);
        
        cin >> f >> c;
        if (incresing_d(M, f, c)) cout << "si" << endl;
        else if (not incresing_d(M, f, c)) cout << "no" << endl;
    }
}
