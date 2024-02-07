#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int posicio_maxim(const vector<double>& v, int m) {
   double max_value = v[0];
   int pos = 0;
   for (int i = 1; i <= m ; ++i) {
       if (v[i] > max_value) {
           max_value = v[i];
           pos = i;
       }
   }
   return pos;
}
