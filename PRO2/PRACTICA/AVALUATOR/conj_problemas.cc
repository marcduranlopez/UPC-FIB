#include "conj_problemas.hh"
using namespace std;

conj_problemas::conj_problemas() {

}

void conj_problemas::leer() {
    int P;
    cin >> P;
    string prob;
    
    for (int i = 0; i<P; ++i) {
        cin >> prob;
        problemas.insert(make_pair(prob,Problema(prob)));
    }
}


void conj_problemas::nuevo_problema(string& p) {
    problemas.insert(make_pair(p,Problema(p)));
    cout << problemas.size() << endl;
}


void conj_problemas::suma_envio(string prob) {
    map<string,Problema>::iterator it = problemas.find(prob);
    it->second.suma_envio();
}

void conj_problemas::suma_envio_exito(string prob) {
    map<string,Problema>::iterator it = problemas.find(prob);
    it->second.suma_envio_exito();
}


void conj_problemas::llenar_conjunto() {
     map<string, Problema>::const_iterator it1 = problemas.begin();
    int mida = problemas.size();
    
    for (int i = 0; i < mida; ++i) {
        aux.insert(it1->second);
        ++it1;
    }
}


bool conj_problemas::existe(string& prob)const {
    map<string,Problema>::const_iterator it = problemas.find(prob);
    if (it == problemas.end()) return false;
    else return true;
}


void conj_problemas::listar_problemas() {
    llenar_conjunto();
    set<Problema>::const_iterator it1 = aux.begin();
    int n = aux.size();
    
    for (int i = 0; i < n; ++i) {
        it1->escribir();
        ++it1;
    }
}


void conj_problemas::escribir_problema(string& prob) {
    map<string, Problema>::iterator it = problemas.find(prob);
    it->second.escribir();
}
