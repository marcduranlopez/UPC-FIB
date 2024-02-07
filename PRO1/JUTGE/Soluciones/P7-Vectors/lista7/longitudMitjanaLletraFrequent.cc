#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

const int LONG_ALFABET = 'z' - 'a' + 1;

char lletra_mes_frequent(const string& s) {
    vector <int> lmf(LONG_ALFABET,0);
    int tams = s.size();
    for (int i = 0; i < tams ; ++i) {
        ++lmf[s[i] - 'a'];
    }
    int pos, max = 0;
        for (int i = 0; i < LONG_ALFABET; ++i) {
            if (lmf[i] > max) {
                pos = i;
                max = lmf[i];
            }
        }
        char c = 'a' + pos;
        return c;
}


int main() {
    cout.setf(ios::fixed);
    cout.precision(2);
    
    int n;
    double longitud = 0;
    cin >> n;
    vector<string> v(n);
    for (int i = 0; i < n ; ++i) {
        cin >> v[i];
        longitud += v[i].length();
    }
    longitud = longitud/n;
    cout << longitud << endl;
    for (int i = 0 ; i < n ; ++i) {
        if (v[i].length() >= longitud) {
            cout << v[i] << ":" << ' ' << lletra_mes_frequent(v[i]) << endl;
        }
    }
}

