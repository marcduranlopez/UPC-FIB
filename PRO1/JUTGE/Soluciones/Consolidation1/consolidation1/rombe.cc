#include <iostream>
using namespace std;
int main() {
    
    int n;
    
    while (cin >> n) {
        int ce = n-1;  //Num. de espacios.
        int cx = 1;    //Num.de *.
        
        for (int i = n-1 ; i != 0; --i) {  //Lineas para llegar al centro.
            for (int j = ce ; j != 0 ; --j) cout << ' ';
            for (int k = cx ; k != 0 ; --k) cout << "*";
            
            cout << endl;
            cx = cx +2;
            ce = ce -1;
        }

        for (int i = cx ; i != 0 ; --i) {
            cout << "*";
        }
        cout << endl;
        
        
        ce = 1;
        cx = cx -2;
        
        for (int i = n-1 ; i != 0 ; --i) {
            for (int j = ce ; j != 0 ; --j) cout << ' ';
            for (int k = cx ; k != 0 ; --k) cout << "*";
            
            cout << endl;
            cx = cx -2;
            ce = ce +1;
        }
    }
}
    

    
