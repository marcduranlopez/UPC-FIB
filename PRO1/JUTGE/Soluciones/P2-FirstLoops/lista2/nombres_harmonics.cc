#include <iostream>
using namespace std;

int main (){
cout.setf(ios::fixed);
cout.precision(4);
double hn = 0.0;
int n;
cin >> n;
    
for (int i = 1.0; i <= n; i = i + 1.0) {
 hn += 1.0/i;
}
cout << hn << endl;
}
