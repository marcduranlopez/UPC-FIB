#include <iostream>
using namespace std;

int main () {
int x,y,max,min;
cin >> x >> y;
if (x > y){ max = x; min = y; }
else {min = x; max = y;}

for(int i = max; i >= min; i = i - 1){
    cout << i << endl;
}
}
