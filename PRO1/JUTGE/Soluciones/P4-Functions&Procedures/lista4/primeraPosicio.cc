#include <iostream>
using namespace std;
int main() {
    
    int n, count= 0;
    bool found = false;
    
    
    while (not found and cin >> n) {
        ++count;
        if (n%2 == 0) found = true;
        
    }
        cout << count << endl;
    }

