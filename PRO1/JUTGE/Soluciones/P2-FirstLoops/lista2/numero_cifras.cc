#include <iostream>
using namespace std;

int main () {
int i,n,c,initial;
cin >> n;
initial = n;
for(i = 2; i <= 16; ++i){
    for (c = 1; n >= i; ++c){
     n = n / i;
    }
    cout << "Base " << i << ": " << c << " cifras." << endl;
    n = initial;
}
     
}
 
