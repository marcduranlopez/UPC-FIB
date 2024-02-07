#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main() {
    int n; 
    while (cin >> n) {
        vector <int> v(n);
        
        for (int i = 0; i < n; ++i) {
            cin >> v[i];
        }
        
        int i = 0;
        int j = n-1;
        int dre = v[0];
        int esq = v[n-1];
    
        while (i <= j and dre != esq) {
            if (dre < esq) {
                ++i;
                dre += v[i];
            }
            else {
                --j;
                esq += v[j];
            }
        }
        if (i <= j) cout << i << ' ' << j << endl;
        else 
            cout << "no" << endl;
    }
}
                
            
            
    
