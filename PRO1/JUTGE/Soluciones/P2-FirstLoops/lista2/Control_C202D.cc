#include <iostream>
using namespace std;

int main (){
int a,b;

while (cin >> a >> b){
    cout << "suma dels cubs entre " << a << " i " << b << ": ";
    
    int s = 0;
    for (int i = a; i <= b; ++i) s += i*i*i;
        cout << s << endl;
    
     }
}
