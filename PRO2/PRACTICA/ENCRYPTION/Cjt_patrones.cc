#include "Cjt_patrones.hh"
using namespace std;

Cjt_patrones::Cjt_patrones() {

}


void Cjt_patrones::leer() {
    int num_ptr;
    cin >> num_ptr;
        
    for (int i = 1; i <= num_ptr; ++i) {
        Patron ptr;
        ptr.rellenar_parametros(i);
        VEC_patrones.push_back(ptr);
    }
}


void Cjt_patrones::nuevo_patron() {
    Patron ptr;
    int i = VEC_patrones.size()+1;
    ptr.rellenar_parametros(i);
    VEC_patrones.push_back(ptr);
    
    cout << VEC_patrones.size() << endl; 
}



void Cjt_patrones::codificar_patron(int idp, int b) {
    string mensaje;
    string s;
    
    getline(cin,s);
    getline(cin,mensaje);
    
    VEC_patrones[idp-1].codificar(mensaje,b);
    
}


void Cjt_patrones::codificar_guardado_patron(string idm, int idp, int b, Cjt_mensajes& cm) {
    string mensaje;
    mensaje = cm.obtener_mensaje(idm); 
    
    VEC_patrones[idp-1].codificar(mensaje,b);
}


void Cjt_patrones::decodificar_patron(int idp, int b) {
    string mensaje_codificado;
    string s;
    
    getline(cin,s);
    getline(cin,mensaje_codificado);
    
    VEC_patrones[idp-1].decodificar(mensaje_codificado, b);
}


bool Cjt_patrones::existe(int& idp)const {
    int size = VEC_patrones.size();
    for (int i=1; i <= size; ++i) {
        if (i == idp) return true;
    }
    return false;
}


void Cjt_patrones::listar_patrones() {
    int n = VEC_patrones.size();
    
    for (int i = 0; i < n; ++i) {
        VEC_patrones[i].escribir();
    }
}
