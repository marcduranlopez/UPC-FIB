#include <iostream>
#include <cmath>
using namespace std;
int main() {

int n;
char c1, c2;

while (cin >> n >> c1 >> c2){
int x1 = 0;
int x2 = n;

    for (int i = 0 ; i < n ; ++i) {
        
        for (int k = x1 ; k > 0 ; --k) {cout << c1;}
        
        for (int j = x2 ; j > 0 ; --j) {cout << c2;}
        
        ++x1;
        --x2;
        cout << endl;
    }
   cout << endl; 
}
}
        
    
