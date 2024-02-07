#include <iostream>
#include <vector>
using namespace std;

struct Tren {
    string id_tren;
    string destino;
    string hora;
};

struct InfDest {
    string destino;
    string primer_id;
    int freq;
};


vector <Tren> lee_info_trenes(int n) {
    vector <Tren> v(n);
    
    for (int i = 0; i < v.size(); ++i) {
        cin >> v[i].id_tren >> v[i].destino >> v[i].hora;
    }
    return v;
}

bool cmp_tren (const Tren& a, const Tren& b) {
    if (a.destino == b.destino) {
        if (a.hora == b.hora) {
            return a.id_tren < b.id_tren;
        }
        else return a.hora < b.hora;
    }
    else return a.destino < b.destino;
}

vector<InfDest> crea_v_inf_dest(const vector<Tren>& v, int m) {
    vector <InfDest> info(m);
    InfDest.freq = 1;
    int k = 1;
    info[0].destino = v[0].destino;
    for (int i = 1; i < v.size(); ++i) {
        if (v[i].destino != v[i-1].destino) {
            info[k].destino = v[i].destino;
            ++k;
        }
        else 
            ++info[k]
    }
    

int main() {
    int n;
    cin >> n;
    int m;
    cin >> m;
    
    vector<Tren> v_tren = lee_info_trenes(n);
    
    sort(v_tren.begin(), v_tren.end(), cmp_tren);
    
    vector<InfDest> v_inf_dest = crea_v_inf_dest(v_tren, m);
    
    sort(v_inf_dest.begin(), v_inf_dest.end(), cmp_inf_dest);
    escribir_resultados(v_inf_dest);
}
            
    
    
