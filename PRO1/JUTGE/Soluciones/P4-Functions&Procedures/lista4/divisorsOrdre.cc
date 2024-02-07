#include <iostream>
#include <cmath>
using namespace std;
int main() {
    
   int n;

   while (cin >> n) {
       cout << "divisors de " << n << ":";
   
       for (int i = 1; i <= sqrt(n) ; ++i) {
           if (n%i == 0) cout << ' ' << i;
       }
       
       for (int j = sqrt(n); j > 0 ; --j) {
           if (n%j == 0 and j != n/j) cout << ' ' << n/j;
   }
cout << endl;
}
}
