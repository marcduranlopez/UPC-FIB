#include <iostream>
using namespace std;
int main() {
    
    int n;
    char m;
    
    cin >> n;
    
    int s = 0;
        
    for ( int i = 0 ; i < n ; ++i) {
        
        for (int j = 0 ; j < n ; ++j) {
            cin >> m;
            m = int (m) - '0'; 
            
            if (i == j or (i+j) == n - 1) {
            s = s + m;
            }
        }
}

cout << s << endl;
}
