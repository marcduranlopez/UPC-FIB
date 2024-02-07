#include <iostream>
#include <cmath>
using namespace std;

int suma_digits(int n) {
    if (n < 10) return n;
    else return (n%10 + suma_digits(n/10));
}
    
bool is_prime(int n) {
    if (n <= 1) return false;
    int max = sqrt(n);
    for (int i = 2 ; i <= max ; ++i) {
        if (n%i == 0) return false;
    }
    return true;
}

bool es_primer_perfecte(int n) {
    if (n < 10) return is_prime(n);
    else
        return is_prime(n) and es_primer_perfecte(suma_digits(n));

}

int main() {
    int n;
    cin >> n;
    cout << es_primer_perfecte(n) << endl;
}
