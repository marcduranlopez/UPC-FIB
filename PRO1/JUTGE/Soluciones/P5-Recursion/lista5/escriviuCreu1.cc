#include <iostream>
using namespace std;

void cross(int n, char c) {
    for (int i = 0 ; i < n ; ++i) {
        if (i == n/2) for (int j = 0 ; j < n ; ++j) cout << c;
            else {
                for (int j = 0 ; j < n/2 ; ++j) cout << ' '; 
                    cout << c;
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
