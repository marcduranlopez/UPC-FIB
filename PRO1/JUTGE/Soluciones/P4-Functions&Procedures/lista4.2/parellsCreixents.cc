#include <iostream>
using namespace std;
int main () {
   
    int n;
    cin >> n;
    
    for (int j = 0 ; j < n ; ++j) {
        int x, y, count = 0;
        cin >> x;
        
              while (x != 0) {
                  
                  cin >> y;
                  if (x < y) ++count;
                  
                  x = y;
              }
              
              cout << count << endl;
    }
}
