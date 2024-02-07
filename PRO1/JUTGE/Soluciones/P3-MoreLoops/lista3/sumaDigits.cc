#include <iostream>
using namespace std;
int main() {
    int a;
    
    while (cin >> a) {
        cout << "La suma dels digits de " << a << " es ";
        
    int s = 0;
    
    for (int i = a ; i > 0 ; i/=10) {
        s += (i%10);

    
    }
cout << s << "." << endl;
}
}       
    
    

