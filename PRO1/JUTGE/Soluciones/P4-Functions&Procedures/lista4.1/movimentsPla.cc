#include <iostream>
using namespace std;
int main() {
    char n;
    int sum1 = 0, sum2 = 0;
     
    while (cin >> n) {
    
    if (n == 'n')
        --sum2;
    
    if (n == 's')
        ++sum2;
    
    if (n == 'o')
        --sum1;
    
    if (n == 'e')
        ++sum1;
   
}
    cout << "(" << sum1 << ", " << sum2 << ")" << endl;
}
