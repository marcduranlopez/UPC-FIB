#include <iostream>
#include <vector>
using namespace std;

typedef vector<int> Row;
typedef vector<Row> Matrix;

Matrix read_matrix(int n) {
    Matrix m(n, Row(n));
    
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> m[i][j];
        }
    }
    return m;
}

bool isParchessi(const Matrix& m, int& up, int& down, int& left, int& right) {
    int n = m.size();
    
    for (int i = 0; i < n/2; ++i) {
        for (int j = 1+i; j < n-1 -i; ++j) {
            up += m[i][j];
        }
    }
    
    for (int i = n-1; i > n/2; --i) {
        for (int j = i-1; j > n-1 -i; --j) {
            down += m[i][j];
        }
    }
    
    for (int j = 0; j < n/2; ++j) {
        for (int i = 1+j; j < n-1 -j; ++i) {
            left += m[i][j];
        }
    }
    
    for (int i = n-1; i > n/2; --i) {
        for (int j = i-1; j > n-1 -i; --j) {
            right += m[j][i];
        }
    }
    if (down != up) return false;
    if (left != right) return false;
    return true;
}
    

int main() {
    int n;
    while (cin >> n) {
        
        Matrix m = read_matrix(n);
        
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        
        if (isParchessi(m, up, down, left, right)) { 
            cout << "true: ";
        }
        else {
            cout << "false: ";
        }
        cout << up << ' ' << down << ", " << left << ' ' << right << endl;
    }
}
