#include <iostream>
#include <cmath>
using namespace std;
int main() {

int n1, n2, n3;

cin >> n1 >> n2 >> n3;

if (n1 == n2 and n2 == n3) {
    if ((n1%2 != 0) and (n1%3 == 0)) {
        cout << "Bananas" << endl;
    }
    else if (n1%2 == 0) {
        cout << "Apples" << endl;
    }
    
    else if ((n1%2 != 0) and (n1%3 != 0)) { 
        cout << "Joker" << endl;
        
    }
}
else cout << "Loss" << endl;
}
    
