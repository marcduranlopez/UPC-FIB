#include <iostream>
#include <vector>
using namespace std;

struct Item {
    string name;
    int quantity;
};

typedef vector<vector<Item> > Room;


Room read_room(int n, int m) {
    Room v(n, vector<Item>(m));
    for (int i = 0 ; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> v[i][j].name >> v[i][j].quantity;
        }
    }
    return v;
}


int how_many_objects(const Room& room, int f, int c, string s) {
    int n = room.size();
    int m = room[0].size();
    int count = 0;
    
    for (int i = f; i < n; ++i) {
        for (int j = c; j < m; ++j) {
            if (room[i][j].name == s) count += room[i][j].quantity;
        }
    }
    return count;
}

int main() {
    int n, m;
    cin >> n >> m;
    Room room = read_room(n, m);
    int f, c;
    string s;
    while (cin >> f >> c >> s) {
        cout << s << ": " << how_many_objects(room, f, c, s) << endl;
    }
}

    
    
    
