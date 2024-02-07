#include <iostream>
using namespace std;
int main() {
    int x, y, max, min, i; 
    cin >> x >> y;
    
    if (x > y) max = x , min = y;
        else max = y , min = x;

    
    for (i = max; i >= min; i = i -1) {
        cout << i << endl;
    }
}
