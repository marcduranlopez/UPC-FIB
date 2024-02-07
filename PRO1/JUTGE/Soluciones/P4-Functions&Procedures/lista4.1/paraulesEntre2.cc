#include <iostream>
using namespace std;
int main() {
    
string a;
bool principi = false;
int pc = 0;
    
while (cin >> a and a != "final") {
    if (principi) ++pc;
    else if (a == "principi") principi = true;

}

if (principi and a == "final") cout << pc << endl;
else cout << "sequencia incorrecta" << endl;

}

