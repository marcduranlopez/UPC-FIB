#include <iostream>
#include <cmath>
using namespace std;

double dist_or(double x, double y){
    x = x*x + y*y;
    x = sqrt(x);
    return x;
}

int main() {
    int x, y;
    cin >> x >> y;
    cout << dist_or(x,y) << endl;
}
