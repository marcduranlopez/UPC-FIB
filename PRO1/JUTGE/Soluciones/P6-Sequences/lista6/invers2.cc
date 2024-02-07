#include <iostream>
#include <cmath>
using namespace std;

void invers() {
    string s;
    if (cin >> s and s != "fi") {
        invers();
        cout << s << endl;
    }
}
    

int main() {
    invers();
}
