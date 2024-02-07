#include <iostream>
#include <vector>
using namespace std;



bool found(const vector <int>& A, int suma, int n) {
    for (int j = 0 ; j < n ; ++j) {
        if (A[j] == suma-A[j]) return true;
    }
    return false;
}

int main() {
    int n;
    while (cin >> n) {
    vector <int>A(n); 
    int suma = 0;
    
    for (int i= 0 ; i < n ; ++i) {
        cin >> A[i];
        suma += A[i];
       }
    
    if (found(A, suma, n)) cout << "YES" << endl;
    else cout << "NO"<< endl;
    }
}
