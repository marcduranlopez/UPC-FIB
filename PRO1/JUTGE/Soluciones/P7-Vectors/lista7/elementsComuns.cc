#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int elements_comuns (const vector<int>& X, const vector<int>& Y) {
    int x = X.size();
    int y = Y.size();
    int count = 0;
    int i = 0;
    int j = 0;
    while (i <= x-1 and j <= y-1) {
        if (X[i] == Y[j]) {
            ++count;
            ++i;
            ++j;
        }
        else if (X[i] < Y[j]) {
            ++i;
        }
        else if (X[i] > Y[j]) {
            ++j;
        }
    }
    return count;
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
    cout << elements_comuns(u, v) << endl;
}

