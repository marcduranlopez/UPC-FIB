#include <iostream>
using namespace std;
int main() {
    
    int n;

    cin >> n;
    
    for (int i = 0 ; i < n ; ++i){
        int m;
        cin >> m;
        cout << m;
    
    bool found = true;
    int div = 2;
    
   while (found and div*div <= m){
       if (m%div == 0) found = false;
       ++div;
       }
       
   if (m > 1 and found) cout << " es primer" << endl;
       
   else cout << " no es primer" << endl;
   }
}


