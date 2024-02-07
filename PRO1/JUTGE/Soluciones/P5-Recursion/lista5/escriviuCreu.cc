#include <iostream>
using namespace std;

void cross(int n, char c) {
    int x = n/2;
    
    for (int i = 0 ; i < x ; ++i) {
        for (int j = 0 ; j < n ; ++j) {
            if (j == n/2) cout << c;
            else cout << ' ';
        }
        cout << endl;
    }
    for (int i = 0 ; i < n ; ++i) {
        cout << c;
    }
    cout << endl;
    
    for (int i = 0 ; i < x ; ++i) {
        for (int j = 0 ; j < n ; ++j) {
            if (j == n/2) cout << c;
            else cout << ' ';
        }              
        cout << endl;
    }
}

int main () {    
    int n;
    char c;
    cin >> n >> c;
    
    cross(n, c);

}
