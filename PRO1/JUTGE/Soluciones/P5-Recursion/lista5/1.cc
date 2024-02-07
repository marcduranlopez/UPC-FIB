#include <iostream>
#include <cmath>
using namespace std;

int mcd(int a, int b){
    while (b != 0) {
       int r = a%b;
       a = b;
       b = r;
     }
     return a;
}

void read_rational(int& num, int& den) {
    int a, b;
    char bar;
    cin >> a >> bar >> b;
    num = a/mcd(a,b);
    den = b/mcd(a,b);
}

int main() {
    int num, den;
    read_rational(num, den);
}