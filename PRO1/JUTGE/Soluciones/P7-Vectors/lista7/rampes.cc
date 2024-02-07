#include <iostream>
#include<vector>
#include <cmath>
using namespace std;


vector<bool> pos_rampes(const vector<int>& V) {
    int x0, x1;
    x0 = V[0];
    x1 = V[1];
    
    vector <bool>positions(V.size());
    for (int i = 2; i < V.size(); ++i) {
        if ((x0 < x1 and x1 < V[i]) or (x0 > x1 and x1 > V[i])) {
            positions[i-2] = true;
        }
        else positions[i-2] = false;
        x0 = x1;
        x1 = V[i];
    }
    return positions;
}

int pot_conflictives(const vector <bool>& B) {
    int c = 0;
    
    for (int j = 0 ; j < B.size()-2 ; ++j) {
        if (B[j] and B[j+1]) ++c;
        if (B[j] and B[j+2]) ++c;
    }
    return c;
}


int main() {
    int n;
    while (cin >> n) {
        
    vector<int> v(n);
    for (int i = 0 ; i < n ; ++i) {
        cin >> v[i];
    }
    vector <bool> posicions = pos_rampes(v);
    cout << "posicions amb rampa:";
    
    for (int i = 0; i < posicions.size() ; ++i) {
        if (posicions[i] == 1) cout << ' ' << i;
    }
    cout << endl;
    
    cout << "potencialment conflictives:" << ' ' << pot_conflictives(posicions) << endl;
    cout << "---" << endl;
    }
}
