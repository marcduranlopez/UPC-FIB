#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int n;
    int count = 0;
    int ul = 0;
    
    while (cin >> n) {
        bool found = true;
        string s1 = " ";
        string s2 = " ";
        for (int i = 0; i < n; ++i) {
            s1 = s2;
            cin >> s2;
            if (s1 > s2) found = false;
        }
        ++count;
        if (found) ul = count; 
    }
    if (ul != 0) cout << "L'ultima linia ordenada creixentment es la " << ul << "." << endl;
    else
        cout << "No hi ha cap linia ordenada creixentment." << endl;
}
            
            
