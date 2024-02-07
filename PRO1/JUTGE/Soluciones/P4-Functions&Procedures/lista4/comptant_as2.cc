#include <iostream>
#include <cmath>
using namespace std;


int main (){
char a;
cin >> a;
int count = 0;

while (a != '.'){
    if (a == 'a') ++count;
    cin >> a;
}
    cout << count << endl;
}

