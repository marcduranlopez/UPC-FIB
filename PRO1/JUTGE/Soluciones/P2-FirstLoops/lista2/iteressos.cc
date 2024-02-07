#include <iostream>
#include <cmath>
using namespace std;


int main (){
cout.setf(ios::fixed);
cout.precision(4);
double c,i;
int t;
string forma; 
for (int k; k > t; ++k){
    cin >> forma;
    if ( forma == "simple"){
    int s;
    s = ((i/100) * c) + s;
    cout << s << endl;
    }
    else if (forma == "compost"){
    double s;
    s = ((i/100.0000) * c) + s;
    cout << s << endl;
    }
}
