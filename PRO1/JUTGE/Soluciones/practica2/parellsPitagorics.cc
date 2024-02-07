#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

bool is_ptg(int a, int b) {
    for (int i = 2; i*i <= a*a+b*b; ++i) {
        if (a*a+b*b == i*i) return true;
    }
    return false;
}

int main() {
    int n, a, b = 1;
    bool found = false;
    int count = 1;
    
    while (not found and cin >> a) {
        if (count >= 2) {
            
            if (is_ptg(b, a)) {
                cout << "First pythagorean pair " << b << ' ' << a << " at position " << count-1 << endl;
                found = true;
            }
        }
        
        ++count;
         b = a;
        }
        if (not found) cout << "No pythagorean pairs" << endl;
}
