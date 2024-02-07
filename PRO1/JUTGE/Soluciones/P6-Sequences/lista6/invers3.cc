#include <iostream>
#include <cmath>
using namespace std;

void invers(int& n) {
    string s;
    if (cin >> s) {
        invers(n);
        if (n != 0) {
        cout << s << endl;
        --n;
        }
    }
}
    

int main() {
    int n;
    cin >> n;
    invers(n);
}
