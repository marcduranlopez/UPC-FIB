#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
 
int main() {
    int n;
    cin >> n;
    vector<int> a(n);
    
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
    int count = 0;
    for (int i = 0 ; i < n-1; ++i) {
        if (a[i] == a[n-1]) ++count;
    }
    cout << count << endl;
}
