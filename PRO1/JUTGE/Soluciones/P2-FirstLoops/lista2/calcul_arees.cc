#include <iostream>
#include <cmath>
using namespace std;


int main (){
cout.setf(ios::fixed);
cout.precision(6);

int n;
double a,b,r;
string forma;
cin >> n;
for (int i = 0; i < n; ++i){
    cin >> forma;
     if (forma == "rectangle"){
         cin >> a >> b;
         cout << a*b << endl;
     }
     if (forma == "cercle"){
         cin >> r;
         cout << M_PI*(r*r) << endl;
     }
}
}
