#include <iostream>
#include <cmath>
using namespace std;

bool es_any_de_traspas(int any){
    return((any%4 == 0 and any%100 != 0) or (any%100 == 0 and (any/100)%4 == 0));
}

int main() {
    int any;
    cin >> any;
    if (es_any_de_traspas(any)) cout << "SI" << endl;
    else cout << "NO" << endl;
}
