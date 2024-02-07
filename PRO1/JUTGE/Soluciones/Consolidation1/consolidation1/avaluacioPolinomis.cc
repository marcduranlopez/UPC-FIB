#include <iostream>
#include <cmath>
using namespace std;
int main() {
cout.setf(ios::fixed);
cout.precision(4);   

double x; 
double c, result = 0;

cin >> x;

for (int i = 0 ; cin >> c ; ++i) {
    
result = result + c*pow (x,i);

}

cout << result << endl;
}
