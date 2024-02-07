#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

vector<int> calcula_cims(const vector<int>& v) {
    int x0 = v[0];
    int x1 = v[1];
    
    vector<int> cims;
    for (int i = 2; i <v.size(); ++i) {
        if ((x0 < x1) and (x1 > v[i])) cims.push_back(x1);
        x0 = x1;
        x1 = v[i];
    }
    return cims;
}

int main() {
    int n;
    cin >> n;
    bool vacio = true;
    vector <int> v(n);
    
    for (int i = 0; i <n; ++i) {
        cin >> v[i];
    }
    vector<int> cims(calcula_cims(v));
    
    int sz = cims.size();
    cout << sz << ":";
    for (int i = 0; i < sz; ++i) {
        cout << ' ' << cims[i];
    }
    cout << endl;
    
    for (int i = 0; i < sz-1; ++i) {
        if (cims[i] > cims.back()) {
            if (not vacio) cout << ' ';
            
                cout << cims[i];
                vacio = false;
        }
    }
    if (vacio) { 
        cout << '-';
    }
    cout << endl;
}
        
    
