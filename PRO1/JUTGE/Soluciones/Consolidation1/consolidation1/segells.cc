#include <iostream>
#include <cmath>
using namespace std;
int main() {
    
int n;

while (cin >> n) {
    int p = 0, q = 0;
    
    while (n!= 0) {
    if (n%7 == 0) { 
    n = n -7;
    ++p;
    } else { 
    n = n -4;
    ++q;
    }
}
cout << p << ' ' << q << endl;
}
}
    

