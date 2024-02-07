#include <iostream>
using namespace std;

int main () {
  int h,m,s;
  cin >> h >> m  >> s;
  
  if (s < 59) 
      s = (s + 1);
  else { s = 0; 
    
      
  if (m < 59) 
      m = (m + 1);
  else {
      m = 0;
  }
    
  if (h < 23) 
      h = (h + 1);
  else {
      h = 0;
  }
  }
      
      
  if (h < 10) cout << 0;
      cout << h << ':';
  if (m < 10) cout << 0;
     cout << m << ':';
  if (h < 10) cout << 0;
     cout << s << ':';
}
 
