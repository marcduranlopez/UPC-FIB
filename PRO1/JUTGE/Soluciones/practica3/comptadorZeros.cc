#include <iostream>
#include <vector>
using namespace std;

vector<int> zeros_counter(const vector<int>& u) {
    int n = u.size();
    vector<int> v(n);
    int count = 0;
        
    for (int j = v.size()-1; j >= 0 ; --j) {
        if (u[j] == 0) {
            ++count;
            v[j] = count;
        }
            else {
                v[j] = count;
            }
    }
    return v;
}


int main () {
    int n;
    cin >> n;
    
    vector<int> u(n);
    for (int i = 0; i < n; ++i) {
        cin >> u[i];
    }
    
    vector<int> zeros = zeros_counter(u);
    
    for (int i = 0; i < zeros.size(); ++i) {
        cout << zeros[i] << endl;
    }
}
    
    
    
