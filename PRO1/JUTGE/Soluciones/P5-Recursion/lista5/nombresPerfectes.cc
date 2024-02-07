#include <iostream>
#include <cmath>
using namespace std;

bool es_perfecte(int n) {
    int suma = 1;
    for (int i = 2 ; i*i <= n ; ++i) {
        if (n%i == 0) suma+= i + n/i;
    }
    return (n == suma and n != 0 and n != 1);
}

int main() {
    int n;
    cin >> n;
    cout << es_perfecte(n) << endl;

}
