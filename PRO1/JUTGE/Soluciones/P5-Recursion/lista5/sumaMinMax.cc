#include <iostream>
#include <cmath>
using namespace std;

int sum_min_max(int x, int y, int z){
    int max, min;
    if (x > y) max = x, min = y;
    else max = y, min = x;
    if(z > max) max = z; 
    if (z < min ) min = z;
    
    return (max+min);
}

int main() {
    int x, y, z;
    cin >> x >> y >> z;
    cout << sum_min_max(x,y,z) << endl;
}
