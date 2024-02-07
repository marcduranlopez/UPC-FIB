#include <iostream>
using namespace std;
int main() {
char a;
cin >> a;

if (a < char(97)) 
    cout << char(a+32) << endl;
 else 
    cout << char(a-32) << endl;
    
}

