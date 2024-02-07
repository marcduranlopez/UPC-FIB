#include <iostream>
#include <cmath>
using namespace std;
 
void invers(int& n) {
    string s;
    if (cin >> s) {
        ++n;
        invers(n);
        if (n <= 0) cout << s << endl;
            n -= 2;
    }
}
    
    
int main() {
    int n = 0;
    invers(n); 
}
