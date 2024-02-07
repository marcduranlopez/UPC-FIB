#include <iostream>
#include <cmath>
using namespace std;

int factorial(int n){
    for (int i = 0 ; i < n ; ++i) {
        n*= n;
    }
    return n;
}

int main() {
    int n;
    cin >> n;
    factorial(n);
    cout << n << endl;
}
