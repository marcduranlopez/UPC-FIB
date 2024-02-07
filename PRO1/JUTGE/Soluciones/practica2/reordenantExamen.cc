#include <iostream>
#include <cmath>
#include <vector>
using namespace std;


bool es_letra(char c) {
    return ('a' <= c and c <= 'z') or ('A' <= c and c <= 'Z');
}


void signos_letras() {
    char c;
    if (cin >> c) {
        if (es_letra(c)) {
            signos_letras();
            cout << c;
        }
        else {
            cout << c;
            signos_letras();
        }
    }
}

int main () {
    signos_letras();
    cout << endl;
}
    
