#include <iostream>
#include <cmath>
using namespace std;


int main (){
char a;
bool found = false;
cin >> a;


while ((not found) and (a != '.')){
    if (a == 'a') found = true;
    cin >> a;
}
    if (found == true)
        cout << "si" << endl;
    if (found == false)
        cout << "no" << endl;
    
}

