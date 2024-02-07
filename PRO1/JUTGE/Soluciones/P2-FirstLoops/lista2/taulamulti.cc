#include <iostream>
using namespace std;
int main() {
    int N; 
    cin >> N;
    int i = 1;
    
    while (i <= 10) {
        cout << N << "*" << i << " = " << (N * i) << endl;
    i= i + 1;
    }
}
