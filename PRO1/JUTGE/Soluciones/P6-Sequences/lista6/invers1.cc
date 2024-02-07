#include <iostream>
#include <cmath>
using namespace std;

void invers() {
    string s;
    if (cin >> s) {
        invers();
        cout << s << endl;
    }
}
    

int main() {
    invers();
}
