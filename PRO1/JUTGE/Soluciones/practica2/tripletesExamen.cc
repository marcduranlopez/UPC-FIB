#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main() {
    int n;
    int total = 0;
    
    while (cin >> n) {
        vector<int> v(n);
        
        for(int i = 0; i < n; ++i) {
            cin >> v[i];
        }
        
        int count = 0;
        int x0 = v[0];
        int x1 = v[1];
        
        for (int i = 2; i < n; ++i) {
            if (x0%x1 == v[i]) ++count;
            x0 = x1;
            x1 = v[i];
        }
        total += count;
        cout << count << endl;
    }
    cout << "Total: " << total << endl;
}
    
    
