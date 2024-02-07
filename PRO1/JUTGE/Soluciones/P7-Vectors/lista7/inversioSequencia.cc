#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    
    
    while (cin >> n) {
    vector <int>A(n); 
    bool primer = true;
    
    for (int i= 0 ; i < n ; ++i) {
        cin >> A[i];
    }
    
    for (int j = n-1 ; j >= 0 ; --j) {
        if (not primer) cout << ' ';
        else primer = false;
        cout << A[j];
    }
    
    cout << endl;
    }
}
