#include <iostream>
#include <cmath>
#include <vector>
using namespace std;


int main() {
    int n,x;
    while (cin >> n) {
    int aux = n;
    vector<int> v(n);
    bool primer = true;
    
    int i = 0;
    while (n != 0) {
        cin >> x; --n;
        v[i] = x; ++i;
    }
    
    for (int j = aux-1; j >= 0; --j) {
        if (not primer) cout << " ";
        primer = false;
        cout << v[j];
    }
    cout << endl;
    }
}
    

