#include <iostream>
using namespace std;
int main() {

int a, d, h, m, s, anys, dies, hores, minuts;

cin >> a >> d >> h >> m >> s;
anys = (a * 365*24*60*60);
dies = (d * 24*60*60);
hores = (h * 60*60);
minuts = ( m * 60);

cout << anys + dies + hores + minuts + s << endl;

}

