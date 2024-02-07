#include <iostream>
using namespace std;
int main() {
    
int n, m;
bool primer = true;

while (cin >> n >> m) {
    if (n == 0 or m == 0)
        cout << endl;
    
int k = 9;
if (!primer) cout << endl;

for (int i = 0 ; i < n ; ++i) {
    
    for (int j = 0 ; j < m ; ++j) {
    cout << k;
    --k;
    if (k == -1) k = 9;
    }
    
    cout << endl;
    }
    primer = false;
}

}
