#include <iostream>
#include <vector>
using namespace std;

struct Asignatura {
    int id;
    double creditos;
    double nota;
};

struct Alumno {
    int dni;
    vector <Asignatura> asigs;
};

typedef vector <Alumno> Alumnos;

int supera_alfa(const Alumnos& alus) {
    int count = 0;
    int n = alus.size();
    
    for (int i = 0; i < n; ++i) {
        int m = alus[i].asigs.size();
        double nota = 0;
        double total = 0;
        double cred = 0;
        for (int j = 0; j < m; ++j) {
            nota += alus[i].asigs[j].nota * alus[i].asigs[j].creditos;
            cred += alus[i].asigs[j].creditos;
        }
         total = nota/cred;   
        if (total >= 5) ++count;
    }
    return count;
}

vector <Asignatura> lee_asignaturas(int m) {
    vector <Asignatura> v(m);
    
    for (int i = 0; i < v.size(); ++i) {
        cin >> v[i].id >> v[i].creditos >> v[i].nota;
    }
    return v;
}
    

int main() {
    int n;
    cin >> n;
    Alumnos a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i].dni;
        int m;
        cin >> m;
        a[i].asigs = lee_asignaturas(m);
    }
    cout << supera_alfa(a) << endl;
}
    
    
    
    
    
