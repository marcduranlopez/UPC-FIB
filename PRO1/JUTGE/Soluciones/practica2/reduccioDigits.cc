#include <iostream>
#include <cmath>
using namespace std;
 
int reduccio_digits(int x) {
    if (x < 10) return x;
    else 
        if (x%10 + reduccio_digits(x/10) < 10) {
            return (x%10 + reduccio_digits(x/10));
        }
            else {
                return reduccio_digits(x%10 + reduccio_digits(x/10));
            }
}
    
    
int main() {
    int x;
    cin >> x;
    cout << reduccio_digits(x) << endl;
}
