#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

int main() {
    int n;
    int h, m, s;
    char c;

    int rh = 0;
    int rm = 0;
    int rs = 0;
    
    cin >> n;
    while (n != 0) {
        cin >> h >> c >> m >> c >> s;
        
        rh += h;    
        rm += m;
        rs += s;
        --n;
    }
        
        if (rs > 59) {
            rm += rs /60;
            rs = rs%60;
        }
        
        if (rm > 59) { 
            rh += rm/60;
            rm = rm%60;
        }
        
    cout << rh << "H " << rm << "M " << rs << "S" << endl;
}
    
    
