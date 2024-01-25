#include "conj_usuarios.hh"

using namespace std;


conj_usuarios::conj_usuarios() {
    
}

void conj_usuarios::leer() {
    int M;
    cin >> M;
    string u;
    
    for (int i=0; i < M; ++i) {
        cin >> u;
        usuarios.insert(make_pair(u,Usuario(u)));
    }
    
}

void conj_usuarios::alta_usuario(string& u) {
    usuarios.insert(make_pair(u,Usuario(u)));
    cout << usuarios.size() << endl;
}

void conj_usuarios::baja_usuario(string& u, conj_cursos& cc) {
    map<string,Usuario>::iterator it = usuarios.find(u);
    it->second.decrementar_inscritos(cc);
    
    usuarios.erase(u);
    cout << usuarios.size() << endl;
}

void conj_usuarios::inscribir_curso(string& u, int& c, conj_cursos& cc, conj_sesiones& cs) {
    int ninscritos;
    map<string,Usuario>::iterator it = usuarios.find(u);
    it->second.inscribir(c, cc, cs);
    ninscritos = cc.incrementar_usuario(c);
    cout << ninscritos << endl;
}


void conj_usuarios::envio(string& u, string& p, int& r, conj_problemas& cp, conj_sesiones& cs, conj_cursos& cc) {
    map<string,Usuario>::iterator it = usuarios.find(u);
    it->second.envio_usuario(p,r,cp,cs,cc);
}


bool conj_usuarios::existe(string& u)const {
    map<string,Usuario>::const_iterator it = usuarios.find(u);
    if (it == usuarios.end()) return false;
    else return true;
}


int conj_usuarios::curso_usuario(const string& u) {
    map<string,Usuario>::iterator it = usuarios.find(u);
    return it->second.curso_usuario();
}


void conj_usuarios::problemas_resueltos(string& u) {
    map<string,Usuario>::iterator it = usuarios.find(u);
    it->second.p_resueltos();
}


void conj_usuarios::problemas_enviables(string& u) {
    map<string,Usuario>::iterator it = usuarios.find(u);
    it->second.p_enviables();
}
    

void conj_usuarios::listar_usuarios() {
    map<string,Usuario>::iterator it = usuarios.begin();
    int mida = usuarios.size();
    for (int i=0; i < mida; ++i) {
        it->second.escribir();
        ++it;
    }
}

void conj_usuarios::escribir_usuario(string& u) {
    map<string,Usuario>::iterator it = usuarios.find(u);
    it->second.escribir();
}
