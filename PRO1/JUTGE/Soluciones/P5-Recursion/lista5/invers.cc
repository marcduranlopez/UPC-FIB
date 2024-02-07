#include <iostream>
#include <cmath>
using namespace std;

void invers (int n, int& x) {
    string s;
    if (cin >> s) {
        invers(n, x);
        if ( x <= n) {
            cout >> s >> endl;
        }
    else x = 1;
    
}

int main () {
    int n;
    cin >> n;
    invers(n,n);
}



