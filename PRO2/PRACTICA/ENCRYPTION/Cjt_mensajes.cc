#include "Cjt_mensajes.hh"
using namespace std;

Cjt_mensajes::Cjt_mensajes() {

}


void Cjt_mensajes::leer() {
    int num_msj;
    cin >> num_msj;
    string idm;
    string s;
    string words;
    
    for (int i = 0; i < num_msj; ++i) {
        Mensaje msj;
        cin >> idm;
//         
        getline(cin,s);
        getline(cin,words); 
        
        msj.rellenar_parametros(idm,words);
        
        MAP_mensajes.insert(make_pair(idm, msj));
    }
}


void Cjt_mensajes::nuevo_mensaje(string& idm) {
    Mensaje msj;
    string words;
    string s;
    
    getline(cin,s);
    getline(cin,words);
    
    msj.rellenar_parametros(idm,words);

    MAP_mensajes.insert(make_pair(idm,msj));
    cout << MAP_mensajes.size() << endl;
}


void Cjt_mensajes::borra_mensaje(string& idm) {
    MAP_mensajes.erase(idm);
    cout << MAP_mensajes.size() << endl;
}


bool Cjt_mensajes::existe(string& idm)const {
    map<string,Mensaje>::const_iterator it = MAP_mensajes.find(idm);
    if (it == MAP_mensajes.end()) return false;
    else return true;
}

string Cjt_mensajes::obtener_mensaje(string& idm) {
     map<string,Mensaje>::iterator it = MAP_mensajes.find(idm);
     return it->second.obtener_mensaje();
}


void Cjt_mensajes::listar_mensajes() {
    map<string, Mensaje>::iterator it = MAP_mensajes.begin();
    int n = MAP_mensajes.size();
    
    for (int i = 0; i < n; ++i) {
        it->second.escribir();
        ++it;
    }
}
