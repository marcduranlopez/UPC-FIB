#include <iostream>
using namespace std;
int main () {
    int paraules;
    int found = 0;
    int j = 1;
    
    while (cin >> paraules and not found) {
        bool ordre = true;
        string s1 = "";
        string s2 = "";
        
        for (int i = 0 ; i < paraules ; ++i) {
            s1 = s2;
            cin >> s2;
            
            if (s2 < s1) ordre = false;
        }
        
        if (ordre) found = j;
        ++j;
    }
    
    if (found) cout << "La primera linia ordenada creixentment es la " << found << "." << endl;
        else cout << "No hi ha cap linia ordenada creixentment." << endl;
}
