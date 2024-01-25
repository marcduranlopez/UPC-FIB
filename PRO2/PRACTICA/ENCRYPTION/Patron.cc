#include "Patron.hh"
#include <queue>
using namespace std;


Patron::Patron() {
    idp = ' ';
    b = ' ';
}


void Patron::leer_patron(BinTree<int>& p) {
    int n;
    cin >> n;
    if (n != -1){
        BinTree<int> l;
        leer_patron(l);
        BinTree<int> r;
        leer_patron(r);
        p = BinTree<int>(n,l,r);
  }
}


void Patron::rellenar_parametros(int& i) {
    idp = i;
    b = ' ';

    leer_patron(BT_patron);
}


void Patron::llenar_BinTree_mensaje(string& msj, int i, BinTree<char>& BT_msj) {
    if (i <= msj.size()) {
        BinTree<char> l;
        BinTree<char> r;
        
        llenar_BinTree_mensaje(msj, 2*i, l);
        llenar_BinTree_mensaje(msj, 2*i+1, r);
        
        BT_msj = BinTree<char>(msj[i-1], l, r);
    }
    else {
        BT_msj = BinTree<char>();
    }
}


void Patron::crear_mosaico(const BinTree<char>& BT_msj, BinTree<int>& BT_mosaico, BinTree<int> BT_ptr_aux) {  //BT_ptr_aux es el BinTree patron que se va descomponiendo
    if (not BT_msj.empty()) {
        
        if (not BT_ptr_aux.empty()) {
            BinTree<int> mosaico_left;
            BinTree<int> mosaico_right;
            
            crear_mosaico(BT_msj.left(), mosaico_left, BT_ptr_aux.left());
            crear_mosaico(BT_msj.right(), mosaico_right, BT_ptr_aux.right());
            
            BT_mosaico = BinTree<int> (BT_ptr_aux.value(),mosaico_left, mosaico_right);
        }
        else {
            BT_ptr_aux = BT_patron;
            crear_mosaico(BT_msj,BT_mosaico,BT_ptr_aux);
        }
    }
    else BT_mosaico = BinTree<int>();
}


void Patron::sumar_mosaico(BinTree<char>& BT_msj, const BinTree<int>& BT_mosaico) {
    if (not BT_msj.empty() and not BT_mosaico.empty()) {
        BinTree<char> l = BT_msj.left();
        BinTree<char> r = BT_msj.right();
        
        sumar_mosaico(l, BT_mosaico.left());
        sumar_mosaico(r, BT_mosaico.right());
        
        int d = BT_mosaico.value();
        char c = BT_msj.value();
        char cod = 32 + (c + d - 32) % 95; 
        
        BT_msj = BinTree<char>(cod, l, r);
    }
}


void Patron::restar_mosaico(BinTree<char>& BT_msj, BinTree<int> BT_mosaico) {
    if (not BT_msj.empty()) { 
        char c = BT_msj.value();
        BinTree<char> l = BT_msj.left();
        BinTree<char> r = BT_msj.right();
        
        if (not BT_mosaico.empty()) {
            int d = BT_mosaico.value();
            char cod = 32 + (c + (95-d) - 32) % 95; 
            
            restar_mosaico(l, BT_mosaico.left());
            restar_mosaico(r, BT_mosaico.right());
        
            BT_msj = BinTree<char>(cod,l,r);
        }
    }
}
        

string Patron::llenar_string_bloque(BinTree<char>& BT_msj) {
    string msj_bloque;
    if (not BT_msj.empty()) {
        queue<BinTree<char>> c;
        c.push(BT_msj);
        while (not c.empty()) {
            BinTree<char> aux = c.front();
            c.pop();
            msj_bloque += aux.value();
            if (not aux.left().empty()) c.push(aux.left());
            if (not aux.right().empty()) c.push(aux.right());
        }
    }
    return msj_bloque;
}



void Patron::codificar(string& mensaje, int& b) {
    int n = mensaje.length();
    int cont = 0;
    int pos = 0;
    int i = 1;
    string mensaje_completo;
    
    
    cout << '"';                                                      //comillas iniciales de la salida del mensaje.        
    while ((cont*b) < n) {                                            //Primera iteracion para crear el mosaico.
        string mensaje_bloque;
        string aux = "";
        for (int k = 0; (k<b) and (pos<n); ++k) {                     //El mensaje se introduce a los BinTree por bloques de tamaño b.
            aux += mensaje[pos];
            ++pos;
        }
        llenar_BinTree_mensaje(aux, i, BT_msj);
        if (cont == 0) crear_mosaico(BT_msj, BT_mosaico, BT_patron);
        sumar_mosaico(BT_msj, BT_mosaico);
        
        mensaje_bloque = llenar_string_bloque(BT_msj);
        mensaje_completo += mensaje_bloque;
        ++cont;
    }
    cout << mensaje_completo << '"' << endl;                           //comillas finales de la salida del mensaje.
}


void Patron::decodificar(string& mensaje, int& b) {
    int n = mensaje.length();
    int cont = 0;
    int pos = 0;
    int i = 1;
    string mensaje_completo;
    
    cout << '"';                                                        //comillas iniciales de la salida del mensaje.    
    while ((cont*b) < n) {                                              //Primera iteracion para crear el mosaico.
        string mensaje_bloque;
        string aux = "";
        for (int k = 0; (k<b) and (pos<n); ++k) {                       //El mensaje se introduce a los BinTree por bloques de tamaño b.
            aux += mensaje[pos];
            ++pos;
        }
        llenar_BinTree_mensaje(aux, i, BT_msj);
        if (cont == 0) crear_mosaico(BT_msj, BT_mosaico, BT_patron);
        restar_mosaico(BT_msj, BT_mosaico);
        
        mensaje_bloque = llenar_string_bloque(BT_msj);
        mensaje_completo += mensaje_bloque;
        ++cont;
    }
    cout << mensaje_completo << '"' << endl;                            //comillas finales de la salida del mensaje.
}


void Patron::escribir_patron(const BinTree<int>& p) {
cout << "(";
    if (not p.empty()) {
        int n = p.value();
        cout << n;
        BinTree<int> l = p.left();
        escribir_patron(l);
        BinTree<int> r = p.right(); 
        escribir_patron(r);
    }
    cout << ")";
}


void Patron::escribir()const {
    
    cout << "Patron " << idp << ':'<< endl;
    escribir_patron(BT_patron);
    cout << endl;
   
}

