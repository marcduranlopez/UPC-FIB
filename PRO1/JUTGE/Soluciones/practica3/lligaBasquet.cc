#include <iostream>
#include <vector>
using namespace std;

struct Game {
    string home;           // home team
    int shome;             // home team's score
    string visitor;        // visitor team
    int svisitor;        // visitor team's score
}; 

int scoring_ability(const vector<Game>& v, const string& team) {
     int totalh = 0;
     int totalv = 0;
     int n = v.size();
     
     for (int i = 0; i < n; ++i) {
         if (v[i].home == team) totalh += v[i].shome;
         else if (v[i].visitor == team) totalv += v[i].svisitor;
     }
     return (totalh-totalv);
}


vector<Game> read_games(int n) {
    vector <Game> v(n);
    
    for (int i = 0; i < n; ++i) {
        cin >> v[i].home >> v[i].shome >> v[i].visitor >> v[i].svisitor;
    }
    return v;
}

int main() {
    int n;
    cin >> n;
    
    vector <Game> v = read_games(n);
    
    string s;
    while (cin >> s) {
        cout << s << ' ' << scoring_ability(v, s) << endl;
    }
}
