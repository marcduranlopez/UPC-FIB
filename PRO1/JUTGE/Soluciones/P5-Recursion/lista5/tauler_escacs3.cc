#include <iostream>
#include <cmath>
using namespace std;

int main (){
int mida,suma = 0;
char m;
cin >> mida;
for (int i = 0; i < mida; ++i){
    for ( int j = 0; j < mida; ++j){
        cin >> m;
      if (i == j or (i + j) == mida - 1) suma += m - '0';
    }
}
cout << suma << endl;
}

    

