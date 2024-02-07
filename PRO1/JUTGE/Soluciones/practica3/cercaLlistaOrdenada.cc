#include <iostream>
#include <vector>
using namespace std;

int effi_search(const vector<string>& v, const string& s) {
    int first = 0;
    int last = v.size()-1;
    int m;
    
    while (first <= last) {
        m = (first+last)/2;
        if (s.length() > v[m].length()) first = m+1;
        else if (s.length() < v[m].length()) last = m-1;
        else {
            if (s > v[m]) first = m+1;
            else if (s < v[m]) last = m-1;
            else
                return m;
        }
    }
    return -1;
}


int main() {
    int n;
    cin >> n;
    
    vector<string> v(n);
    for (int i = 0; i < n; ++i) { 
        cin >> v[i];
    }
    
    string s;
    while (cin >> s) 
        cout << effi_search(v, s) << endl;
}

    
