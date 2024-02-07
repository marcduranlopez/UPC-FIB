#include <iostream>
#include <vector>
using namespace std;

void swap(int& a, int& b) {
    int c = a;
    a = b;
    b = c;
}

int pos_min(vector<int>& v, int left, int right) {
    pos = left;
    
    for (int i = left +1; i<= right; ++i) {
        if (v[i] < v[pos]) pos = i;
    }
    return pos;
}

void selection sort(vector<int>& v) {
    int last = v.size-1;
    
    for (int i = 0; i < last; ++i) {
        int k = pos_min(v, i, last);
        swap(v[k], v[i]);
    }
}
