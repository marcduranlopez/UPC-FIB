#include <iostream>
#include <vector>
using namespace std;

struct Book {
    string title;       // títol del llibre
    int nb_pag;         // número de pàginas del llibre
};

struct Author {
    string name;        // nom de l'autor
    Book bestseller;    // llibre supervendes
};

typedef vector<Author> Library;

Library read_data(int n) {
    Library v(n);
    for (int i = 0; i < v.size(); ++i) {
        cin >> v[i].name >> v[i].bestseller.title >> v[i].bestseller.nb_pag;
    }
    return v;
}

int main() {
    int n;
    cin >> n;
    
    Library data(n);
    
    data = read_data(n);
    
    char c;
    int p;
    while (cin >> c >> p) {
        cout << "-- begin query" << endl;
        for (int i = 0; i < n; ++i) {
            if (data[i].bestseller.title[0] == c and data[i].bestseller.nb_pag > p) {
                cout << data[i].name << endl;
            }
        }
        cout << "-- end query" << endl;
    }
}
    
    
