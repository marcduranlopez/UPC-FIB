#include <iostream>
using namespace std;

int main () {
int n;
cin >> n;
int c;
if (n == 0) cout << n;
while (n != 0){
    c = n % 16;
    if (c <= 9)  cout << c;
   else if (c == 10) cout << "A";
   else if (c == 11) cout << "B";
   else if (c == 12) cout << "C";
   else if (c == 13) cout << "D";
   else if (c == 14) cout << "E";
   else if (c == 15) cout << "F";

    n = n / 16;
}
cout << endl;
}
 
