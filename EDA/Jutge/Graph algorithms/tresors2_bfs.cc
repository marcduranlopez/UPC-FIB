#include <iostream>
#include <queue>
#include <vector>
using namespace std;


using VC = vector<char>;
using VVC = vector<VC>;
using VI = vector<int>;
using VVI = vector<VI>;


struct Pos {
  int x, y;
};


const VI inc_x = { 1, -1, 0,  0};
const VI inc_y = { 0,  0, 1, -1};


int n, m;
VVC M;


void bfs(int xini, int yini) {
  VVI dist(n, VI(m, -1));
  queue<Pos> Q;
  dist[xini][yini] = 0;
  Q.push({xini, yini});
  while (not Q.empty()) {
    auto [x, y] = Q.front(); Q.pop();
    for (int i = 0; i < 4; ++i) {
      int x2 = x + inc_x[i];
      int y2 = y + inc_y[i];
      if (x2 >= 0 and x2 < n and y2 >= 0 and y2 < m and dist[x2][y2] == -1) {
        dist[x2][y2] = dist[x][y] + 1;
        if (M[x2][y2] == 't') {
          cout << "distancia minima: " << dist[x2][y2] << endl;
          return;
        }
        if (M[x2][y2] == '.') Q.push({x2, y2});
      }
    }
  }
  cout << "no es pot arribar a cap tresor" << endl;
}


int main() {
  cin >> n >> m;
  M = VVC(n, VC(m));
  for (int i = 0; i < n; ++i)
    for (char& c : M[i]) cin >> c;
  int x, y;
  cin >> x >> y;
  bfs(x - 1, y - 1);
}
