#include "Mensaje.hh"
using namespace std;


Mensaje::Mensaje() {
    idm = "";
}


void Mensaje::rellenar_parametros(string id_msj, string words) {
    idm = id_msj;
    mensaje = words;
}


string Mensaje::obtener_mensaje() {
    return mensaje;
}

void Mensaje::escribir()const {
    
    cout << idm << endl;
    
    int n = mensaje.length();
    
    cout << '"';
    for (int i=0; i < n; ++i) {
        cout << mensaje[i];
    }
        cout << '"' << endl;
        
}
