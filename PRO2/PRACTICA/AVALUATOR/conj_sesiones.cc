#include "conj_sesiones.hh"
using namespace std;

conj_sesiones::conj_sesiones() {

}

void conj_sesiones::leer() {
    int Q;
    cin >> Q;
    string s;
    Sesion ses;
    
    for (int i=0; i<Q; ++i) {
        cin >> s;
        sesiones.insert(make_pair(s,Sesion(s)));
        map<string,Sesion>::iterator it = sesiones.find(s);
        it->second.leer_string_BinTree();
    }
    
}


void conj_sesiones::nueva_sesion(string& s) {
    sesiones.insert(make_pair(s,Sesion(s)));
    map<string,Sesion>::iterator it = sesiones.find(s);
    it->second.leer_string_BinTree();
    cout << sesiones.size() << endl;
}

void conj_sesiones::actualiza_problem_enviables(string& p, string& s, map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos) {
    map<string,Sesion>::iterator it = sesiones.find(s);
    it ->second.actualiza_problem_enviables(p, problem_enviables, problem_resueltos);
}


void conj_sesiones::devolver_problema(string& s, map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos) {
    map<string,Sesion>::iterator it = sesiones.find(s);
    it->second.devolver_problema(problem_enviables, problem_resueltos);
}


bool conj_sesiones::buscar_problema(string& s, string& p) {
    bool found;
    found = sesiones[s].buscar_problema(p);
    if (found) return true;
    else return false;
}
    
    
bool conj_sesiones::existe(string& s)const {
    map<string,Sesion>::const_iterator it = sesiones.find(s);
    if (it == sesiones.end()) return false;
    else return true;
}


vector<string> conj_sesiones::problemas_sesion(string s) {
    map<string,Sesion>::iterator it = sesiones.find(s);
    return it->second.problemas_sesion();
}

void conj_sesiones::listar_sesiones()const {
    Sesion ses;
    map<string,Sesion>::const_iterator it = sesiones.begin();
    int mida = sesiones.size();
    for (int i=0; i < mida; ++i) {
        ses = it->second;
        ses.escribir();
        ++it;
    }
}

void conj_sesiones:: escribir_sesion(string& s)const {
    Sesion ses;
    map<string,Sesion>::const_iterator it = sesiones.find(s);
    ses = it->second;
    ses.escribir();
}
