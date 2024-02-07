#include <iostream>
using namespace std;

int main (){
int n;
int s = 0;
cin >> n;

for (int i = n; i > 0; i /= 100) {
    s += (i % 10);
}
   if (((s % 2) == 0) or (s == 0))
       cout << n << " ES TXATXI" << endl;
   else
       cout << n << " NO ES TXATXI" << endl;
}
