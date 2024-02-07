#include <iostream>
using namespace std;
int main() {
    
    int f, c;
    char m;
    
    cin >> f >> c;
    
    int s = 0;
        
    for ( int i = 0 ; i < f ; ++i) {
        
        for (int j = 0 ; j < c ; ++j) {
            cin >> m;
            m = int (m) - '0'; 
            
            s = s + m;
        }
}

cout << s << endl;
}
