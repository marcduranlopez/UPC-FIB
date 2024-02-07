#include <iostream>
#include <cmath>
using namespace std;

int main (){
int n;
cin >> n;
int ce = n - 1;
int cx = 1;

for (int s = n - 1; s != 0; --s){
    for (int e = ce; e != 0; --e) cout << ' ';
    for (int x = cx; x != 0; --x) cout << '*';
    cout << endl;
    cx = cx + 2;
    --ce;
   }
for (int s = 1; s != 0; --s) {
    for (int e = cx; e != 0; --e) cout << '*';
    cout << endl;   
  }
cx = cx - 2;
ce = 1; 
for (int s = n - 1; s != 0; --s){
    for (int e = ce; e != 0; --e) cout << ' ';
    for (int x = cx; x != 0; --x) cout << '*';
    cout << endl;
    cx = cx - 2;
    ++ce;
  }
}

    

