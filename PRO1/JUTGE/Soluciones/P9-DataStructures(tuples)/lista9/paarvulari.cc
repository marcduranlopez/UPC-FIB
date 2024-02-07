#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Professor {
    string nom;
    int pastanaga;
    int caramel;
};


bool custom_sort (Professor& a, Professor& b) {
    if (a.caramel == b.caramel) {
            if (a.pastanaga == b.pastanaga) {
                    if (a.nom.size() == b.nom.size()) {
                        int y = a.nom.size();
                        for (int i = 0; i < y ; ++i) {
                            if (a.nom[i] != b.nom[i])
                                return a.nom[i] < b.nom[i];
                        }
                        return 1;
                    }
                    return a.nom.size() < b.nom.size();
            }
            return a.pastanaga > b.pastanaga;
    }
    else
        return a.caramel > b.caramel;
}


int main() {
    int n;
    cin >> n;
    
    vector < vector <Professor> > v(n, vector <Professor> (0));
    
    for (int i = 0 ; i < n ; ++i) {
        int p;
        cin >> p;
        v[i].resize(p);
        
        for (int j = 0; j < p ; ++j) {
            cin >> v[i][j].nom;
            cin >> v[i][j].caramel;
            cin >> v[i][j].pastanaga;
        }
        
        sort(v[i].begin() , v[i].end(), &custom_sort);
    }
    
    for (int i = 0; i < n ; ++i) {
        int p = v[i].size();
        for (int j = 0; j < p; ++j) {
            cout << v[i][j].nom << endl;
        }
        cout << endl;
    }
}

        
        
        
        
