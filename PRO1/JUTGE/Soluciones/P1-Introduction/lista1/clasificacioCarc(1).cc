#include <iostream>
using namespace std;
int main() {
char a;
cin >> a;

if (a >= 'A' and a <= 'Z') { 
    cout << "majuscula" << endl;
} else { 
     cout << "minuscula" << endl;
}
 
if (a =='A' or a == 'E' or a == 'I' or a == 'O' or a == 'U' or a == 'a' or a == 'e' or a == 'i' or a == 'o' or a == 'u') {
    cout << "vocal" << endl;
} else {
    cout << "consonant" << endl; 
}
}
