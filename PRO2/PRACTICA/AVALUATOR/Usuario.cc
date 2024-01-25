#include "Usuario.hh"
using namespace std;


Usuario::Usuario() {
    
    usuario = "";
    env_totales_usuario = 0;
    curso_inscrito = 0;
}


Usuario::Usuario(string u) {
    
    usuario = u;
    env_totales_usuario = 0;
    curso_inscrito = 0;
}


void Usuario::inscribir(int& c, conj_cursos& cursos, conj_sesiones& ses) {
    curso_inscrito = c;
    Curso curso_sesion;
    curso_sesion = cursos.buscar_curso(c);
    vector<string> sesiones_c;
    sesiones_c = curso_sesion.identificar_sesiones_vec();
    
    string s;
    string p;
    int mida = sesiones_c.size();
    for (int i = 0; i < mida; ++i) {
        s = sesiones_c[i];
        ses.devolver_problema(s, problem_enviables, problem_resueltos);
    }
}


void Usuario::decrementar_inscritos(conj_cursos& cc) {
    if (curso_inscrito != 0) {
        cc.decrementar_usuario(curso_inscrito);
    }
}


void Usuario::intentos_problema(string& p) {
    map<string,int>::iterator it = intentos_problema_p.find(p);
    
    if (it == intentos_problema_p.end()) {
        intentos_problema_p.insert(make_pair(p,1));
    }
    else
        ++it->second;
}

void Usuario::agregar_problema_resuelto(string& p) {
    problem_resueltos.insert(make_pair(p, Problema(p)));
}


void Usuario::envio_usuario(string& p, int& r, conj_problemas& cp, conj_sesiones& cs, conj_cursos& cc) {
    if (r == 0) {
        ++env_totales_usuario;
        intentos_problema(p);

        cp.suma_envio(p);
    }
        
    else {
        ++env_totales_usuario;
        intentos_problema(p);
        
        agregar_problema_resuelto(p);
        problem_enviables.erase(p);
        cc.actualiza_problem_enviables(curso_inscrito, cs, p, problem_enviables, problem_resueltos);
        
        cp.suma_envio(p);
        cp.suma_envio_exito(p);
        
        if (problem_enviables.size() == 0) {
            cc.suma_cursos_resueltos(curso_inscrito);
            cc.decrementar_usuario(curso_inscrito);
            map<string,Problema> problem_enviables;
            curso_inscrito = 0;
            
        }
    }
}


int Usuario::curso_usuario()const {
    return curso_inscrito;
}


void Usuario::p_resueltos()const {
    string p;
    map<string,Problema>::const_iterator it1 = problem_resueltos.begin();
   
    while (it1 != problem_resueltos.end()) {
        p = it1->first;
        cout << p << "(";
        
        map<string,int>::const_iterator it2 = intentos_problema_p.find(p);
        if (it2 == intentos_problema_p.end()) cout << 0 << ")" << endl;
        else {
        int num_intentos = it2->second;
        cout << num_intentos << ")" << endl;
        }
        
        ++it1;
    }
}

void Usuario::p_enviables()const {
    string p;
    map<string,Problema>::const_iterator it1 = problem_enviables.begin();
   
    while (it1 != problem_enviables.end()) {
        p = it1->first;
        cout << p << "(";
        
        map<string,int>::const_iterator it2 = intentos_problema_p.find(p);
        if (it2 == intentos_problema_p.end()) cout << 0 << ")" << endl;
        else {
            int num_intentos = it2->second;
            cout << num_intentos << ")" << endl;
        }
        
        ++it1;
    }
}


void Usuario::escribir()const {
    cout << usuario << "(" << env_totales_usuario << "," << problem_resueltos.size() << "," << intentos_problema_p.size() << "," << curso_inscrito << ")" << endl;
}
