#include <iostream>
#include <vector>
using namespace std;

void  insertion_sort(vector<int>& v) {
    for (int i = 1; i < v.size(); ++i) {
        int x = v[i];
        int j = i;
        while (j > 0 and x < v[j-1]) {
            v[j] = v[j-1];
            --j;
        }
        v[j] = x;
    }
}
