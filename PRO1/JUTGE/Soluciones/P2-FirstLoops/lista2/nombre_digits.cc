#include <iostream>
using namespace std;

int main (){
int n,digits;
cin >> n;
digits = 1;
while (n > 9){
    digits = digits + 1;
    n /= 10;
}
    cout << "El nombre de digits de " << n << " es " << digits << "." << endl;

}
