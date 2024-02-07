#include <iostream>
#include <vector>
using namespace std;

typedef vector < vector<char> > Matriu;
typedef vector<string> Llista;


Llista llegir_llista(int x) {
    Llista s(x);
    
        for (int i = 0 ; i < x ; ++i) {
            cin >> s[i];
        }
        return s;
}

Matriu llegir_sopa(int n, int m) {
    Matriu sopa(n, vector<char>(m));
    
    for (int i = 0 ; i < n ; ++i) {
        for (int j = 0 ; j < m ; ++j) {
            cin >> sopa[i][j];
        }
    }
    return sopa;
}

bool esta(const Matriu& aux, string s, int i, int j, int inici_i, int inici_j) {
    int k = 0;
    while(i < aux.size() and j < aux[0].size() and k < s.length()) {
        if (s[k] != aux[i][j]) return false;
        i += inici_i;
        j += inici_j;
        ++k;
    }
    return k == s.length();
}

void convertir_mayusculas(Matriu& sopa, int l, int i, int j, int inici_i, int inici_j) {
    int k = 0;
    while (k < l) {
        if (sopa[i][j] >= 'a' and sopa[i][j] <= 'z') sopa[i][j] = char(int(sopa[i][j])-int('a')+int('A'));
        i += inici_i;
        j += inici_j;
        ++k;
    }
}


void sopa_lletres(Matriu& aux, Matriu& sopa, Llista s) {
    for (int k = 0; k < s.size(); ++k) {
        int i = 0;
        string s1 = s[k];
        while (i < sopa.size()) {
            int j = 0;
            while (j < sopa[0].size()) {
                if (s1[0] == aux[i][j]) {
                    if (esta(aux, s1, i, j, 0, 1)) convertir_mayusculas(sopa, s1.length(),i ,j, 0, 1);
                    if (esta(aux, s1, i, j, 1, 0)) convertir_mayusculas(sopa, s1.length(),i ,j, 1, 0);
                    if (esta(aux, s1, i, j, 1, 1)) convertir_mayusculas(sopa, s1.length(),i ,j, 1, 1);
                }
                ++j;
            }
            ++i;
        }
    }
}


void imprimir_sopa(const Matriu& sopa) {
    for (int i = 0; i < sopa.size(); ++i) {
        bool primer = true;
        for (int j = 0; j < sopa[0].size(); ++j) {
            if (not primer) cout << ' ';
            else primer = false;
            cout << sopa[i][j];
        }
        cout << endl;
    }
}


int main() {
    int x,n,m;
    bool primer = true;
    while (cin >> x >> n >> m) {
        
        Llista s = llegir_llista(x);
        Matriu sopa = llegir_sopa(n, m);
        Matriu aux = sopa;
        
        sopa_lletres(aux, sopa, s);
        
        if (not primer) cout << endl;
        else primer = false;
        imprimir_sopa (sopa);
    }
}
