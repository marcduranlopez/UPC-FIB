#include <iostream>
#include <vector>
using namespace std;


void mod (int z, const vector<int>& v, int esq, int dre) {
    if (dre >= esq) {
        int pos = (esq+dre)/2;
        if (v[pos] <= z) esq = pos+1;
        else dre = pos -1;
        mod (z, v, esq, dre);
    }
}

int effi_last_pos (const vector<int>& v, int z) {
    int esq = 0;
    int dre = v.size()-1;
    mod(z, v, esq, dre);
    
    return esq -1;
}

void read_vector(vector<int>& v) {
    int n = v.size();
    for (int i = 0; i < n; ++i) cin >> v[i];
}


int main() {
    int n;
    cin >> n;
    vector<int> v(n);
    read_vector(v);
    int z;
    while (cin >> z)
        cout << effi_last_pos(v, z) << endl;
}
            
    
    
