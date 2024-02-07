#include <iostream>
using namespace std;
int main() {
    
   string max, max2, string, trans;
   
   cin >> max >> max2;
   
   if (max2 > max) {
       trans = max2;
       max2 = max;
       max = trans;
   }
   
   while (cin >> string) {
   
       if(string != max and string != max2) {
           if (string > max2) {
               if (string > max) {
                   max2 = max;
                   max = string; 
               }
           else max2 = string;
           }
       else if (max == max2) max2 = string;
   }
}
                   

cout << max2 << endl;
}
