#include <iostream>
#include <cmath>
using namespace std;
int main() {
    
  int a, b, c;
  int max, middle, min;

  char l1, l2, l3;

  cin >> a >> b >> c;
  cin >> l1 >> l2 >> l3;

  // MÁXIMO DE 3
  if (a > b) max = a;
  else max = b;
  if (c > max) max = c;

  // MÍNIMO DE 3
  if (a < b) min = a;
  else min = b;
  if (c < min) min = c;

  // MEDIO
  middle = a + b + c - max - min;

  // SUBSTITUIR A,B,C POR MAX,MIN Y MIDDLE
  a = min;
  b = middle;
  c = max;

  // SACAR ORDEN CORRECTO
  if (l1 == 'A'){
    if (l2 == 'B'){
      cout << a << ' ' << b << ' ' << c << endl;
    } else {
      cout << a << ' ' << c << ' ' << b << endl;
    }
  } else if (l1 == 'B'){
    if (l2 == 'A'){
      cout << b << ' ' << a << ' ' << c << endl;
    } else {
      cout << b << ' ' << c << ' ' << a << endl;
    }
  } else {
    if (l2 == 'A'){
      cout << c << ' ' << a << ' ' << b << endl;
    } else {
      cout << c << ' ' << b << ' ' << a << endl;
    }
  }
}
    
               
            
