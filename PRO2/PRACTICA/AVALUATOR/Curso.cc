#include "Curso.hh"

using namespace std;


Curso::Curso() {
    
    curso = 0;
    num_completados = 0;
    num_inscritos = 0;
    num_sesiones = 0;
    
}


int Curso::incrementar_usuario() {
    ++num_inscritos;
    return num_inscritos;
}


void Curso::decrementar_usuario() {
    --num_inscritos;
}


void Curso::identificar_curso(int c) {
    
    curso = c;
}


void Curso::leer_sesiones() {
    num_sesiones = 0;
    int nsesiones;
    cin >> nsesiones;
    string ses;
    
    for (int i=0; i < nsesiones; ++i) {
        cin >> ses;
        identif_sesiones.push_back(ses);
        ++num_sesiones;
    }
}


void Curso::suma_cursos_resueltos() {
    ++num_completados;
}

bool Curso::identificar_sesiones_bool(string& prob, conj_sesiones& ses)const {
    bool found;
    string s;

    int mida = identif_sesiones.size();
    for (int i = 0; i < mida; ++i) {
        s = identif_sesiones[i];
        found = ses.buscar_problema(s, prob);
        if (found) return true;
    }
    return false;

}

string Curso::identificar_sesiones_string(string& prob, conj_sesiones& s)const {
    bool found;
    string ses;
    
    int mida = identif_sesiones.size();
    for (int i = 0; i < mida; ++i) {
        ses = identif_sesiones[i];
        found = s.buscar_problema(ses, prob);
        if (found) return ses;
    }
    return 0;
}

vector<string> Curso::identificar_sesiones_vec()const {
    return identif_sesiones;
}  
        

bool Curso::rep_problema_curso(conj_sesiones& cs) {
    string s;
    num_sesiones = 0;
    int nsesiones;
    pair<map<string,string>::iterator, bool> c;
    vector<string> p_sesion;
    cin >> nsesiones;
    for (int i=0; i < nsesiones; ++i) {
        cin >> s;
        p_sesion = cs.problemas_sesion(s);
        int size = p_sesion.size();
        for (int j=0; j < size; ++j) {
            string prob = p_sesion[j];
            c = map_ses_prob.insert(make_pair(prob,s));
            if (not c.second) return true;
        }
        identif_sesiones.push_back(s);
        ++num_sesiones;
    }
    return false;
}


void Curso::escribir_sesiones() {
    int mida = identif_sesiones.size();
    
    for (int i=0; i < mida; ++i) {
        if (i + 1 != mida) {
            cout << identif_sesiones[i] << " ";
        }
        else cout << identif_sesiones[i];
    }
}
        
        
void Curso::escribir() {
    cout << curso << " " << num_completados<< " " << num_inscritos << " " << num_sesiones << " " << "(";
    
    escribir_sesiones(); 
    cout << ")" << endl;
}

