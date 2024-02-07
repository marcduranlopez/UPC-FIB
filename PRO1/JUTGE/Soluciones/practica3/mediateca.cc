#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Track {
  string artist, title, genre;
  int year;
};

bool comp(const Track &a, const Track &b) {
    if (a.artist == b.artist) {
        if (a.year == b.year) {
            return a.title < b.title;
        }
        else
            return a.year < b.year;
    }
    else
        return a.artist < b.artist;
}

vector<Track> read_tracks(int n) {
    vector<Track> v(n);
    
    for (int i = 0; i < v.size(); ++i) {
        cin >> v[i].artist >> v[i].title >> v[i].genre >> v[i].year;
    }
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
    
    vector<Track> v = read_tracks(n);
    
    sort(v.begin(),v.end(),comp);
    
    string s;
    while (cin >> s) {
        for (int i = 0; i < n; ++i) {
            if (v[i].genre == s) print_track(v[i]);
        }
    }
}
