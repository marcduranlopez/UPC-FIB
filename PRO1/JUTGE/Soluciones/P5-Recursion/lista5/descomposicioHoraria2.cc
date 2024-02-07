#include <iostream>
#include <cmath>
using namespace std;

void descompon(int n, int& h, int& m, int& s){
     h = n/3600;
    m = (n/60)%60;
    s = n%60;

}

int main() {
    int n, h, m, s;
    cin >> n;
    descompon(n, h, m, s);
}
