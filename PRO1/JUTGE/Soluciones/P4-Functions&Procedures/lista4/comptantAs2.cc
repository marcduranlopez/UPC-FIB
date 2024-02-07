#include <iostream>
using namespace std;
int main() {
    
    char a;
    int count = 0;
    bool found = false;
    
    
    while (not found and cin >> a) {
        if (a == '.') {found = true;}
        if (a == 'a') ++count;
        
}
cout << count << endl;
}
