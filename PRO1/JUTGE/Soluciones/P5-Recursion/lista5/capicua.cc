#include <iostream>
#include <cmath>
using namespace std;

bool es_capicua(int n) { 
    int m = 0;
    int x = n;
    while (x != 0) {
        m = m*10 + x%10;
        x = x/10;
    }
    return m == n;
}


int main () {
    int n;
    cin >> n;
    cout << es_capicua(n) << endl;
}
