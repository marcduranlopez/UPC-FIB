#include <iostream>
#include <cmath>
using namespace std;

int main (){
int n;

while (cin >> n){
    if (n < 10) cout << "El producte dels digits de " << n << " es " << n  << "." << endl;
    
    else{
    while (n > 9){
        cout << "El producte dels digits de " << n << " es ";
        int s = 1;
        while (n != 0){
        s *= (n%10);
        n /= 10;
    }
    cout << s << "." << endl;
    n = s;
    }
   }
   cout << "----------" << endl;
  }
}

    

