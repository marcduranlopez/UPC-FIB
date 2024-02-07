#include <iostream>
#include <vector>
using namespace std;


int time_lapse(int time_1, int time_2) {
    int dif;
    if (time_1 >= time_2) {
        dif = (time_2-time_1)+60;
    }
    else if (time_1 < time_2) { 
        dif = time_2-time_1;
    }
    return dif;
}


int main() {
    int t1, t2, n;
    bool found = false;
    
    cin >> t1 >> t2;
    int dif = time_lapse(t1, t2);  
    
    t1 = t2;
    
    while (not found and cin >> t2 and t2 != -1) {
        if (time_lapse(t1, t2) != dif) {
            found = true;
        }
        t1 = t2;
    }
    if (found) cout << 0 << endl;
    else cout << dif << endl;
}

        
    
    
