#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

bool is_power_2(int n) {
    if (n == 1) return true;
    else {
        for (int i = 2; i <= n; i*=2)
            if (i == n) return true;
    }
    return false;
}


int main() {
    int n;
    bool found = false;
    int count = 0;
    
    while (not found and cin >> n and n != -1) {
        if (is_power_2(n)) found = true;
        ++count;
    }
    if (found) cout << count << endl;
    else cout << 0 << endl;
}
    
