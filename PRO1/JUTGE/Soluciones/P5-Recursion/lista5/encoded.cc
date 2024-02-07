#include <iostream>
#include <cmath>
using namespace std;

char codificat(char c, int k) {
    if (c >= 'a' and c <= 'z') {
    return (((c - 'a'+ k) % 26) + 'A');
    }
    else if (c == '_') return ' ';
    else return c;
}

int main () {
    int k;
    while (cin >> k) {
        char c;
        cin >> c;
    
        while (c != '.') {
            cout << codificat(c, k);
            cin >> c;
        }
        cout << endl;
    }
}
