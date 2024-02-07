#include <iostream>
#include <cmath>
using namespace std;
 
int main() {
    int n;
    bool found = false;
    
    int x, y, z;
    cin >> x >> y >> z;
    while (not found and z != 0) {
        if (x < y and y > z and y > 3143) found = true;
        x = y;
        y = z;
        cin >> z;
    }
    if (found) cout << "SI" << endl;
    else
        cout << "NO" << endl;
}
        
