#include <iostream>
using namespace std;
#include <cmath>
int main() {
    
    char a;
    cin >> a;
    int count = 0;
    
    while (a != '.') {
        if (a == 'a') ++count;
        
        cin >> a;
    }
    cout << count << endl;
   
}
