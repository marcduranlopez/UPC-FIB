#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    
    while (cin >> n) {
        vector <int> v(n);
        
        for (int i = 0; i < n; ++i) {
            cin >> v[i];
        }
       int pos;
       bool trobat = false;
       int i = 0;
       while (i < n and trobat) {
           for (int j = 0; j < n; ++j) {
               if (v[i] == v[j] and i != j) {
                   pos = j;
                   trobat = true;
               }
           }
           ++i;
       }
       if (trobat) cout << v[pos] << ' ' << pos << endl;
       else cout << "NO" << endl;
    }
}

    
    
