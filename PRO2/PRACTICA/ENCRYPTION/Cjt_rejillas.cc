#include "Cjt_rejillas.hh"
using namespace std;

Cjt_rejillas::Cjt_rejillas() {

}


void Cjt_rejillas::leer() {
    int num_rej;
    int dim, tam;
    int pos1, pos2;
    cin >> num_rej;
        
    for (int i = 1; i <= num_rej; ++i) {
        Rejilla rej;
        vector< pair<int,int> > vec_rejilla; //Vector que contiene los pares correspondientes a las posiciones.

        cin >> dim >> tam;

        for (int j=0; j < tam; ++j) { 
            cin >> pos1 >> pos2;
            vec_rejilla.push_back(make_pair(pos1,pos2));
        }
        rej.rellenar_parametros(i,dim, vec_rejilla);
        rej.crear_plantilla();
        VEC_rejillas.push_back(rej);
    }
}


void Cjt_rejillas::nueva_rejilla(int& dim, int& tam) {
    Rejilla rej;
    int pos1, pos2;
    vector<pair<int, int>> vec_rejilla;
    int i = VEC_rejillas.size()+1;

    for (int j=0; j < tam; ++j) { 
        cin >> pos1 >> pos2;
        vec_rejilla.push_back(make_pair(pos1,pos2));
        }
    rej.rellenar_parametros(i,dim, vec_rejilla);
    rej.crear_plantilla();
    
   if (rej.validacion()) {
        VEC_rejillas.push_back(rej);
        cout << VEC_rejillas.size() << endl;
    }
    else cout << "error: la rejilla con sus giros no cubre todas las posiciones N x N" << endl;
}


void Cjt_rejillas::codificar_rejilla(int idr) {
    string mensaje;
    string s;
    
    getline(cin,s);
    getline(cin,mensaje);
    
    VEC_rejillas[idr-1].codificar(mensaje);
}


void Cjt_rejillas::codificar_guardado_rejilla(string idm, int idr, Cjt_mensajes& cm) {
    string mensaje;
    mensaje = cm.obtener_mensaje(idm); 
    
    VEC_rejillas[idr-1].codificar(mensaje);
}

    
void Cjt_rejillas::decodificar_rejilla(int idr) {
    string mensaje_codificado;
    string s;
    
    getline(cin,s);
    getline(cin,mensaje_codificado);
    
    bool mensaje_valido = VEC_rejillas[idr-1].mensaje_valido(mensaje_codificado);
    
    if (mensaje_valido) {
    VEC_rejillas[idr-1].decodificar(mensaje_codificado);
    }
    else
        cout << "error: la dimension del mensaje es inadecuada para la rejilla" << endl;
}
    

bool Cjt_rejillas::existe(int& idr)const {
    int size = VEC_rejillas.size();
    for (int i=1; i <= size; ++i) {
        if (i == idr) return true;
    }
    return false;
}


void Cjt_rejillas::listar_rejillas() {
    int n = VEC_rejillas.size();
    
    for (int i = 0; i < n; ++i) {
        VEC_rejillas[i].escribir();
    }
}
