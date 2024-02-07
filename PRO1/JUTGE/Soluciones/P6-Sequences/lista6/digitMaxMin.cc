#include <iostream>
#include <cmath>
using namespace std;

void digit_maxim_i_minim(int n, int& maxim, int& minim) {
    minim = maxim = n%10;
    n /= 10;
    while (n != 0) {
        int num;
        num = n%10;
        if (num > maxim) maxim = num;
        else if (num < minim) minim = num;
        n /= 10;
    }
    cout << maxim << ' ' << minim << endl;
}


int main () {
    int n, maxim = 0, minim = 0;
    cin >> n;
    digit_maxim_i_minim(n,maxim,minim);
    
}
