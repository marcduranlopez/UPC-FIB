#include <iostream>
#include <cmath>
using namespace std;


int main (){
int f,c;
cin >> f >> c;

for (int i = 0; i < f; ++i){
    int distancia = -i;
    for (int j = 0; j < c; ++j){
        if (distancia < 0) cout << (-distancia)%10;
        else cout << distancia%10;
        ++distancia;
         
    }
      cout << endl;
  }

}

    

