#include <iostream>
#include <vector>
using namespace std;

typedef vector < vector<int> > Matriu;


Matriu llegir_valors(int f, int c) {
     Matriu valors(f, vector<int> (c));
        
        for (int i=0; i<f; ++i) {
            for (int j=0; j<c; ++j) {
                cin >> valors[i][j];
            }
        }
        return valors;
}


void min_max(const Matriu& valors, int& minim, int& maxim) {
    maxim = minim = valors[0][0];
    for (int i = 0; i < valors.size(); ++i) {
        for (int j = 0; j < valors[0].size(); ++j) {
            if (valors[i][j] > maxim) maxim = valors[i][j];
            if (valors[i][j] < minim) minim = valors[i][j];
        }
    }
}
            
    
int main () {
    int f,c;
    int max, min, dif;
    max = min = 0;
    
    int num_matriu = 0;
    int maxnum = 0;
    dif = -1;
    
    while (cin >> f >> c) {
        
        Matriu valors = llegir_valors(f,c);
        
        min_max(valors, min, max);
        ++num_matriu;
        
        if (max-min > dif) {
            dif = max-min;
            maxnum = num_matriu;
        }
    }
    
    cout << "la diferencia maxima es " << dif << endl;
    cout << "la primera matriu amb aquesta diferencia es la " << maxnum << endl;
}
