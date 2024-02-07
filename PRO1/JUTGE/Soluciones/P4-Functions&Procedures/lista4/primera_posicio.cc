#include <iostream>
#include <cmath>
using namespace std;


int main (){
int n;
bool found = false;
int count = 0;
while (not found and cin >> n){
    ++count;
if (n % 2 == 0) found = true;   

    }
 
cout << count << endl; 
    
}

