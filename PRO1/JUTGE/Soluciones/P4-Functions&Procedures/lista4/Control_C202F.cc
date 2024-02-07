#include <iostream>
#include <cmath>
using namespace std;


int main (){
int a;
int n;
int suma1 = 0;
int suma2 = 0;
int count = 0;
cin >> a;
cout << "nombres que acaben igual que " << a << ":" << endl;

suma1 = (a % 1000);

while (cin >> n){
     
suma2 = (n % 1000);
    if (suma1 == suma2) {
    ++count;
    cout << n << endl;
   }
   }

cout << "total" << ": " << count << endl;
}
