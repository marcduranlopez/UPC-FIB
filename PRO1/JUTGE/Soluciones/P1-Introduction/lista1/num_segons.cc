#include <iostream>
using namespace std;

int main () {
  int a,d,h,m,s,anys,dies,hores,minuts,t;
  cin >> a >> d >> h >> m >> s;
  
  anys = (a * 365*24*3600);
  dies = (d * 24*3600);
  hores = (h * 3600);
  minuts = (m * 60);
  t = (anys + dies + hores + minuts + s);
  
  cout << t << endl;
}
 
