#include <iostream>
using namespace std;
int main() {
    int N; 
    cin >> N;
    int i = 1;
    
    while (i <= N) {
        cout << N << " x " << i << " = " << (N * i) << endl;
    i= i + 1;
    }
}
