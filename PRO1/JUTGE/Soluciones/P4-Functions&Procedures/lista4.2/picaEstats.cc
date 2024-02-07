#include <iostream>
using namespace std;
int main () {
    
    int x, y, z;
    bool found = false;
    
    cin >> x >> y >> z;
    while (not found and z!= 0) {
        
        if (y > x and y > z and y > 3143)
            found = true;
        
        x = y;
        y = z;
        
        cin >> z;
    }
    
    if (found) cout << "SI" << endl;
    else cout << "NO" << endl;
   
}
