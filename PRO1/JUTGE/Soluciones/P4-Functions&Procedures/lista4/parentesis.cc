#include <iostream>
using namespace std;
int main() {
    
char a;

int openclose = 0;

while (cin >> a and openclose >= 0) {
    if (a == '(') ++openclose;
    else if (a == ')') --openclose;
}

if (openclose == 0) cout << "si" << endl;
else cout << "no" << endl;
}
