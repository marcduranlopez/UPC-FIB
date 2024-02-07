#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
 
const int N = 1000000000;

int main() {
    int n;
    cin >> n;
    vector <int> v(1001, 0);
    
    for (int i = 0; i < n; ++i) {
        int x;
        cin >> x;
        ++v[x-N];
    }
    
    for (int i = 0; i < 1001; ++i) {
        if (v[i] != 0) cout << N+i << " : " << v[i] << endl;
    }
}
