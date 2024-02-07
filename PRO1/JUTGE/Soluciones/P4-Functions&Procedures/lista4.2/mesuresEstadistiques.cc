#include <iostream>
using namespace std;
int main () {
    cout.setf(ios::fixed);
    cout.precision(4);
    
    int n;
    cin >> n;
    
    for (int j = 0 ; j < n ; ++j) {
        int m;
        cin >> m;
        double seq1, seq, mitj, max, min;
        cin >> seq1;
        max = seq1;
        min = seq1;
        mitj = seq1;
        
              for (int i = 1 ; i < m ; ++i) {
                  cin >> seq;
        
                  if (seq > max) max = seq;
                  else if (seq < min) min = seq;
                  mitj += seq;
              }
              
              cout << min << ' ' << max << ' ' << (mitj)/m << endl;
    }
}
