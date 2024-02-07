#include <iostream>
#include <vector>
#include <cmath>
using namespace std;


bool es_palindrom(const string& s) {
    int is = 0;
    int fs = s.size()-1;
    while (is < fs) {
        if (s[is] != s[fs]) return false;
        else {
        ++is;
        --fs;
        }
    }
    return true;
}

int main() {
    string s;
    cin >> s;
    cout << es_palindrom(s) << endl;
}
    
