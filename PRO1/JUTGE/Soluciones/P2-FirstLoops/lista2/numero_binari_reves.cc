#include <iostream>
using namespace std;

int main () {
int n;
cin >> n;
int c;
while (n >= 2){
    c = n % 2;
    cout << c;
    n = n / 2;
}
cout << n << endl;
}
 
