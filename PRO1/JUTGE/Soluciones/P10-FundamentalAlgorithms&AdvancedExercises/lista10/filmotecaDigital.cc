#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Track {
  string artist, title, genre;
  int year;
};

bool comp(const Track &a, const Track &b) {
    if (a.genre == b.genre and a.artist == b.artist and a.year == b.year) return a.title < b.title;
    if (a.genre == b.genre and a.artist == b.artist) return a.year < b.year;
    if (a.genre == b.genre) return a.artist < b.artist;
    return a.genre < b.genre;
}

vector<Track> read_tracks(int n) {
    
    vector<Track> v(n);
    int k = v.size();
    for (int i = 0;i < k;++i) cin >> v[i].artist >> v[i].title >> v[i].genre >> v[i].year;
    return v;
    
}

void print_track(const Track &t) {
  cout << t.artist;
  cout << " (" << t.year;
  cout << ") " << t.title << " (" << t.genre << ")" << endl;
}

int main() {
  
    int n;
    cin >> n;
    vector<Track> v;
    v = read_tracks(n);
    string p,p1,p2;
    cin >> p >> p1 >> p2;
    
    sort(v.begin(),v.end(),comp);
    for (int i = 0;i < n;++i) {
        if (p == v[i].genre or p1 == v[i].genre or p2 == v[i].genre) print_track(v[i]);
    }
}
