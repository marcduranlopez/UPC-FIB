#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

struct Rellotge {
         int h;      // hores (0<=h<24)
         int m;      // minuts (0<=m<60)
         int s;      // segons (0<=s<60)
};

Rellotge mitja_nit() {
    Rellotge init;
    init.h = init.m = init.s = 0;
    return init;
}


void escriu (const Rellotge& r) {
    if (r.h < 10) cout << 0;
    cout << r.h << ":";
    
    if (r.m < 10) cout << 0;
    cout << r.m << ":";
    
    if (r.s < 10) cout << 0;
    cout << r.s;
    cout << endl;
}
    

void incrementa (Rellotge& r) {
    r.s = r.s+1;
    if (r.s == 60) {
        r.s = 0;
        r.m = r.m+1;
        if (r.m == 60) {
            r.m = 0;
            r.h = r.h+1;
            if (r.h == 24) {
                r.h = 0;
            }
        }
    }
}
    
    
int main() {
    Rellotge r = mitja_nit();
    incrementa(r);
    escriu(r);
}

