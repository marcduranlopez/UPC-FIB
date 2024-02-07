#include <iostream>
#include <vector>
#include <cmath>
using namespace std;


typedef vector<int> Fila;
typedef vector<Fila> Tablero;

Tablero check_positions(Tablero& aux, int x, int i, int j, bool& testigo) {
    int n = aux.size();
    int m = aux[0].size();
    if (i >= 0 and i < n and j >= 0 and j < m) {
        if (aux[i][j] == 0) {
            aux[i][j] = x;
            testigo = true;
        }
    }
    return aux;
}

void move_update(Tablero& tab, int k, bool& testigo) {
    Tablero aux = tab;
    int n = tab.size();
    int m = tab[0].size();
    testigo = false;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (aux[i][j] == k) {
                check_positions(aux, k+1, i+1, j+2, testigo);
                check_positions(aux, k+1, i+1, j-2, testigo); 
                check_positions(aux, k+1, i-1, j+2, testigo); 
                check_positions(aux, k+1, i-1, j-2, testigo); 
                check_positions(aux, k+1, i+2, j+1, testigo); 
                check_positions(aux, k+1, i+2, j-1, testigo); 
                check_positions(aux, k+1, i-2, j+1, testigo); 
                check_positions(aux, k+1, i-2, j-1, testigo); 
            }
        }
    }
    
    tab = aux;
}


void escribir_tablero(const Tablero& tab) {
    int m = tab.size();
    int n = tab[0].size();
    for (int i = 0; i < m; ++i) {
        cout << tab[i][0];
        for (int j = 1; j < n; ++j) cout << ' ' << tab[i][j];
        cout << endl;
    }
}


//inicializa el tablero tab a cero
void set_zero(Tablero& tab) {
    int m = tab.size();
    int n = tab[0].size();
    for (int i = 0; i < m; ++i)
        for (int j = 0; j < n; ++j)
            tab[i][j] = 0;
}


int main() {
    int m;
    while (cin >> m) {
        int n;
        cin >> n;
        Tablero tab(m, Fila(n));
        set_zero(tab);
        int i, j;
        cin >> i >> j;
        tab[i][j] = 1;
        bool testigo = true;
        int k = 1;
        while (testigo) {
            move_update(tab, k, testigo);
            ++k;
        }
        escribir_tablero(tab);
        cout << endl;
    }
}
    
    
    
    
