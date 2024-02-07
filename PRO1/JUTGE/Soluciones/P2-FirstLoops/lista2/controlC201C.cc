#include <iostream>
using namespace std;
int main() {
    cout.setf(ios::fixed);
     cout.precision(2);
     
    int x, n, count;
    cin >> x;
    count = 0;
    
    while (cin >> n) {
        if (n%x == 0) ++count;
        
}
cout << count << endl;
}
        
        
    
    

