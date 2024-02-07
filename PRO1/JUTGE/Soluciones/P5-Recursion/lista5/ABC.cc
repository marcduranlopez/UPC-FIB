#include <iostream>
#include <cmath>
using namespace std;


int main (){
char A,B,C;
int a,b,c,min,max,medio;
cin >> a >> b >> c;
cin >> A >> B >> C;

//MINIMO DE 3
if (a < b) min = a; 
else min = b;
if (c < min) min = c;

//MAXIMO DE 3
if (a > b) max = a; 
else max = b;
if (c > max) max = c;

//MEDIO
medio = a + b + c - min - max;

//SUBSTITUIR CADA VARIABLE POR LA QUE LE CORRESPONDE
a = min; 
b = medio;
c = max;

//ORDEN
 if (A == 'A'){
    if (B == 'B'){
      cout << a << ' ' << b << ' ' << c << endl;
    } else {
      cout << a << ' ' << c << ' ' << b << endl;
    }
  } else if (A == 'B'){
    if (B == 'A'){
      cout << b << ' ' << a << ' ' << c << endl;
    } else {
      cout << b << ' ' << c << ' ' << a << endl;
    }
  } else {
    if (B == 'A'){
      cout << c << ' ' << a << ' ' << b << endl;
    } else {
      cout << c << ' ' << b << ' ' << a << endl;
    }
  }

}

    

