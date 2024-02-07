#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

bool is_prime(int sumaVec) {
    int n = sumaVec;
    if (n <= 1) return false;
    int max = sqrt(n);
    for (int i = 2 ; i <= max ; ++i) {
        if (n%i == 0) return false;
    }
    return true;
}

bool found(const vector <int>& A, int suma, int n) {
    bool found = false;
    for (int i = 0 ; i < n ; ++i) {
    for (int j = 0 ; j < i ; ++j) {   //i en vez de n para optimizarlo.
        int sumaVec = A[i] + A[j];
        if (is_prime(sumaVec)) return true;
    }
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

       }
    
    if (found(A, suma, n)) cout << "si" << endl;
    else cout << "no"<< endl;
    }
}
