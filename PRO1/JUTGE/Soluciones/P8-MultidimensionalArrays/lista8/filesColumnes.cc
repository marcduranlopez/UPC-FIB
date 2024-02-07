#include <iostream>
#include <vector>
using namespace std;

int main() {
    int x, y;
    cin >> x >> y;

    typedef vector <vector <int> >Matriu;
    Matriu Mat(x, vector <int>(y));

    for (int i = 0; i < x; i++) {
        for (int j = 0; j < y; j++) {
            cin >> Mat[i][j];
        }
    }

    string request;
    while (cin >> request) {
        int num1;
        if (request == "fila") {
            cin >> num1;
            cout << "fila " << num1 << ":";
            for (int i = 0; i < y; i++) {
                cout << ' ' << Mat[num1-1][i];
            }
            
        } else if (request == "columna") {
            cin >> num1;
            cout << "columna " << num1 << ":";
            for (int i = 0; i < x; i++) {
                cout << ' ' << Mat[i][num1-1];
            }
            
            
        } else if (request == "element") {
            int num2;
            cin >> num1 >> num2;
            cout << "element " << num1 << ' ' << num2 << ":";
            cout << ' ' << Mat[num1-1][num2-1];
        }
        cout << endl;
}
}
            
