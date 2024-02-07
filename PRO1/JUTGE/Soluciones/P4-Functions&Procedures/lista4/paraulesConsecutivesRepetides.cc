#include <iostream>
using namespace std;
int main() {
    
string a, b;

cin >> a;

int pc = 1;
int pcm = 1;

while (cin >> b){
    if (b != a) pc = 0;
    else ++pc;
    
    if (pc > pcm) pcm = pc;
}

cout << pcm << endl;
}
