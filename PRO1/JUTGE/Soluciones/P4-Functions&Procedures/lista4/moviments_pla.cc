#include <iostream>
#include <cmath>
using namespace std;


int main (){
int suma1 = 0;
int suma2 = 0;

char n;
while (cin >> n){
if (n == 'e'){ 
    ++suma1;
   }
if (n == 'o'){
    --suma1;
   }
if (n == 'n'){
    --suma2;
   }
if (n == 's'){
    ++suma2;
   }
}

cout << "(" << suma1 << "," << " " << suma2 << ")" << endl;
}

