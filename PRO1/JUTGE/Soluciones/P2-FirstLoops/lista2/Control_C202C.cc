#include <iostream>
using namespace std;

int main (){
int n,x;
int count = 0;
cin >> n;
while (cin >> x){
    if ((x % n) == 0)
      ++count;  
   }
   cout << count << endl;
}
