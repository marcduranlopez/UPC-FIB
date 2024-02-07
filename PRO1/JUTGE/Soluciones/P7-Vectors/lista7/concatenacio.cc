#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

vector <int>concatenacio(const vector<int>& v1, const vector<int>& v2) {
    vector <int> c(v1.size() + v2.size());
    for (int i = 0 ; i < v1.size() ; ++i) c[i] = v1[i];
    for (int i = 0 ; i < v2.size() ; ++i) c[i + v1.size()] = v2[i];
    return c;
}

int main() {
    int n1, n2;
    
    cin >> n1;
    vector <int> u(n1);
    for (int i = 0 ; i < n1 ; ++i) {
        cin >> u[i];
    }
    
    cin >> n2;
    vector <int> v(n2);
    for (int i = 0 ; i < n2 ; ++i) {
        cin >> v[i];
    }
    vector <int> res = concatenacio(u, v);
    for (int i = 0 ; i < res.size() ; ++i)
        cout << res[i] << endl;
}

