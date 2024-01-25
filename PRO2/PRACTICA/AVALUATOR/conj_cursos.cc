#include "conj_cursos.hh"
using namespace std;

conj_cursos::conj_cursos() {
    vector<Curso> cursos;
    
}


void conj_cursos::leer() {
    int N;
    cin >> N;
    for (int i = 0; i < N; ++i) {
        Curso curs;
        curs.identificar_curso(i+1);
        curs.leer_sesiones();
        cursos.push_back(curs);
    }
}


int conj_cursos::incrementar_usuario(int& c) {
    int mida = cursos.size();
    int ninscritos;
    for (int i=0; i < mida; ++i) {
        if (i+1 == c) {
        ninscritos = cursos[i].incrementar_usuario();
        return ninscritos;
        }
    }
    return 0;
}


void conj_cursos::decrementar_usuario(int& c) {
    cursos[c-1].decrementar_usuario();
}


void conj_cursos::nuevo_curso(conj_sesiones& cs) {
    int size = cursos.size();
    Curso curs;
    curs.identificar_curso(size + 1);
    if (not curs.rep_problema_curso(cs)) {
        cursos.push_back(curs);
        cout << cursos.size() << endl;
    }
    else cout << "error: curso mal formado" << endl;
}


void conj_cursos::suma_cursos_resueltos(int& c) {
    cursos[c-1].suma_cursos_resueltos();
}


void conj_cursos::actualiza_problem_enviables(int& c, conj_sesiones& cs, string& p, map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos) {
    string s;
    s = sesion_problema(c,p,cs);
    cs.actualiza_problem_enviables(p, s, problem_enviables, problem_resueltos);
}

bool conj_cursos::existe(int& c)const {
    int mida = cursos.size();
    for (int i=0; i < mida; ++i) {
        if (i+1 == c) return true;
    }
    return false;
}


string conj_cursos::sesion_problema(int& c, string& prob, conj_sesiones& s) {
    return cursos[c-1].identificar_sesiones_string(prob,s);
}


bool conj_cursos::pertenece(int& c, string& prob, conj_sesiones& s) {
    bool pertenece;
    pertenece = cursos[c-1].identificar_sesiones_bool(prob,s);
    if (pertenece) return true;
    else 
        return false;
}


Curso conj_cursos::buscar_curso(int& c)const {
    return cursos[c-1];
}


void conj_cursos::listar_cursos() {
    int mida = cursos.size();
    for (int i=0; i < mida; ++i) {
        cursos[i].escribir();
    }
}


void conj_cursos:: escribir_curso(int& c) {
    int mida = cursos.size();
    bool found = false;
    int i = 0;
    while (not found and i < mida) {
        if (i+1 == c) {
        cursos[i].escribir();
        found = true;
        }
        ++i;
    }
}
