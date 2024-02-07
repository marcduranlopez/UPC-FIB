#include <iostream>
#include <cmath>
using namespace std;
int main() {

int n1, n2, n3;
int s = 0;

while (cin >> n1 >> n2 >> n3) {

      if (n1 == n2 and n2 == n3) {
          if ((n1%2 != 0) and (n1%3 == 0)) {
          s+= 15;
        }
          
          else if (n1%2 == 0) {
          s+= 10;
        }
    
          else if ((n1%2 != 0) and (n1%3 != 0)) { 
          s+= 5;
        }
    
    }
}

cout << s << endl;
}
    
