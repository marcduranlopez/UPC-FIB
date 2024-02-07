#include <iostream>
#include <vector>
using namespace std;

int time_lapse(int time_1, int time_2) {
    int dif;
    if (time_1 >= time_2) {
        dif = (time_2-time_1)+60;
    }
    else if (time_1 < time_2) {
        dif = (time_2-time_1);
    }
    return dif;
}

int main () {
    int n,t1, t2;
    cin >> n;
    cin >> t1;
    
    bool found = false;
    int count = 0;
    int i = 1;
    
    while (not found and cin >> t2 and t2 != -1) {
        int dif = time_lapse(t1, t2);
        count += dif;
        if (count > n) {
            found = true;
        }
        t1 = t2;
        ++i;
    }
    if (not found) cout << 0 << endl;
    else
        cout << i << endl;
}
    
    
    
    
    
