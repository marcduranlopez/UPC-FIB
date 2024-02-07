#include <iostream>
using namespace std;

int main (){
int a;
while (cin >> a){
    int s = 0;
    cout << "La suma dels digits de " << a << " es "; 
    int i = a;
    while (i != 0){
       s += (i % 10);
       i /= 10;
      }
    cout << s << "." << endl;
     }
}
