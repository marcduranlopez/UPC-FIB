#include <iostream>
using namespace std;
int main() {
    
    int n, m, count = 0;
    
    cin >> n;
    
    cout << "nombres que acaben igual que " << n << ":" << endl;
    
    bool found = false;
    
    while (cin >> m){
        found = false;
    
    if (m%1000 == n%1000) 
        found = true;


    if (found == true) {
        ++count;
        cout << m << endl;
} 
    }
cout << "total: " << count << endl;

}
