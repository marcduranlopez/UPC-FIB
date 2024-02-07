#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

bool es_palindrom(const string& s) {
    int sf = s.size()-1;                 //string final
    int si = 0;                         //string inici
    
    while (si < sf){
        if (s[si] != s[sf]) return false;
        else {
            ++si;
            --sf;
        }
    }
    return true;
}

int main() {
    string s;
    while (cin >> s) {
    cout << es_palindrom(s) << endl;
    }
}

