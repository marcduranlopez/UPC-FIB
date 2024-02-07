#include <iostream>
#include <cmath>
using namespace std;

void read_rational(int& num, int& den) {
    for (int i = den ; i > 0 ; --i) {
        if (num%i == 0 and den%i == 0)
            num/= i, den/= i;
    }
    cout << num << "/" << den << endl;
}


int main() {
    int num, den;
    cin >> num >> den;
    read_rational(num, den);
}
