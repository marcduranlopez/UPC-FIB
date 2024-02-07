#include <iostream>
#include <vector>
#include <cmath>
using namespace std;


int main() {
    int n;
    while (cin >> n) {
        vector<int> v(n);
        
        for (int i = 0; i < n; ++i) {
            cin >> v[i];
        }
        int count = 1;
        
        for (int i = 1; i < n; ++i) {
            int x = 0;
            for (int j = i-1; v[i] > x and j >= 0; --j) {
                x += v[j];
                if (v[i] == x) {
                    ++count;
                }
            }
        }
        cout << count << endl;
    }
}
    
    
    
    
