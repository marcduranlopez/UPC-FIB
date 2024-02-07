#include <iostream>
#include <vector>
using namespace std;

typedef vector < vector<int> > Matriu_num;
typedef vector < vector<char> > Matriu_lletres;
typedef vector <char> String;


Matriu_lletres llegir_sopa(int f, int c) {
    Matriu_lletres sopa(f, vector<char> (c));
        
        for (int i=0; i<f; ++i) {
            for (int j=0; j<c; ++j) {
                cin >> sopa[i][j];
            }
        }
        return sopa;
}

Matriu_num llegir_valors(int f, int c) {
     Matriu_num valors(f, vector<int> (c));
        
        for (int i=0; i<f; ++i) {
            for (int j=0; j<c; ++j) {
                cin >> valors[i][j];
            }
        }
        return valors;
}

String llegir_string(int x) {
    String lletres(x);
    
    for(int i=0; i<x; ++i) {
        cin >> lletres[i];
    }
    return lletres;
}
    
    
int main () {
    int f,c;
    while (cin >> f >> c) {
        
        Matriu_lletres sopa = llegir_sopa(f,c);
        Matriu_num valors = llegir_valors(f,c);
        
        int x;
        String lletres = llegir_string(x);
        
        
    }
    



}
