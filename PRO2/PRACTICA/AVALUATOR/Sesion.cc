#include "Patron.hh"
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


void Patron::crear_mosaico(const BinTree<char>& BT_msj, BinTree<int> BT_mosaico, BinTree<int> BT_ptr_aux) {  //BT_ptr_aux es el BinTree patron que se va descomponiendo
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
    else 
        BT_mosaico = BinTree<int>();
}


void Patron::sumar_mosaico(BinTree<char>& BT_msj, const BinTree<int>& BT_mosaico) {
    if (not BT_msj.empty()) {
        BinTree<char> msj_l = BT_msj.left();
        BinTree<char> msj_r = BT_msj.right();
        
        BinTree<int> mos_l = BT_mosaico.left();
        BinTree<int> mos_r = BT_mosaico.right();
        
        sumar_mosaico(msj_l, mos_l);
        sumar_mosaico(msj_r, mos_r);
        
        
        int d = BT_mosaico.value();
        char c = BT_msj.value();
        char cod = 32 + (c + d - 32) % 95; 
        
        BT_msj = BinTree<char>(cod, msj_l, msj_r);
        
    }
    
    else BT_msj = BinTree<char>();
}


void Patron::restar_mosaico(BinTree<char> BT_msj, BinTree<int> BT_mosaico) {
    if (not BT_msj.empty()) {
        BinTree<char> l = BT_msj.left();
        BinTree<char> r = BT_msj.right();
        
        restar_mosaico(l, BT_mosaico.left());
        restar_mosaico(r, BT_mosaico.right());
        
        int d = BT_mosaico.value();
        char c = BT_msj.value();
        char cod = 32 + (c + (95-d) - 32) % 95; 
        
        BT_msj = BinTree<char>(cod,l,r);
    }
}
        
/*
void Patron::llenar_string_bloque(string& s, int i, BinTree<char>& BT_msj) {
    if (i <= s.length()) {
        BinTree<char> l = BT_msj.left();
        BinTree<char> r = BT_msj.right();
        
        llenar_BinTree_mensaje(s, 2*i, l);
        llenar_BinTree_mensaje(s, 2*i+1, r);
        
        s[i-1] = BT_msj.value();
    }
}
  */      
 
string Patron::leer_patron_mensaje(BinTree<char>& BT_msj) {
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
    
    cout << '"';                                                        //comillas iniciales de la salida del mensaje.
    string aux = " ";                                                   //Primera iteracion para crear el mosaico.
        for (int k = 0; (k<b) and (pos<n); ++k) {                       //El mensaje se introduce a los BinTree por bloques de tamaño b.
            aux += mensaje[pos];
            ++pos;
        }
        llenar_BinTree_mensaje(aux, i, BT_msj);
        crear_mosaico(BT_msj, BT_mosaico, BT_patron);     //Se crea el mosaico solo en la primera iteración del bloque
      //  sumar_mosaico(BT_msj, BT_mosaico);
        
        if (n < b) { 
            string s(n,' ');
            llenar_string_bloque(s, i, BT_msj); 
            cout << s;
        }
        else { 
            string s(b, ' ');
            llenar_string_bloque(s, i, BT_msj);
            cout << s;
        }
        ++cont;
    
    while ((cont*b) < n) {
        string aux = " ";
        for (int k = 0; (k<b) and (pos<n); ++k) {                        //El mensaje se introduce a los BinTree por bloques de tamaño b.
            aux += mensaje[pos];
            ++pos;
        }
        llenar_BinTree_mensaje(aux, i, BT_msj);
       // sumar_mosaico(BT_msj, BT_mosaico);
        
        if (n-pos < b) { 
            string s(n-pos,' ');
            llenar_string_bloque(s, i, BT_msj); 
            cout << s;
        }
        else { 
            string s(b, ' ');
            llenar_string_bloque(s, i, BT_msj);
            cout << s;
        }
        ++cont;
    }
    cout << '"';                                                        //comillas finales de la salida del mensaje.
    cout << endl;
}


void Patron::decodificar(string& mensaje, int& b) {
    int n = mensaje.length();
    int cont = 0;
    int pos = 0;
    int i = 1;
    
    cout << '"';                                            //comillas iniciales de la salida del mensaje.
    string aux = " ";                                       //Primera iteracion para crear el mosaico.
        for (int k = 0; (k<b) and (pos<n); ++k) {           //El mensaje se introduce a los BinTree por bloques de tamaño b.
           // aux += mensaje[pos];
            ++pos;
        }
        llenar_BinTree_mensaje(aux, i, BT_msj);
        crear_mosaico(BT_msj, BT_mosaico, BT_patron); //Se crea el mosaico solo en la primera iteración del bloque
       // restar_mosaico(BT_msj, BT_mosaico);
        
        if (n < b) { 
            string s(n,' ');
            llenar_string_bloque(s, i, BT_msj); /////duplicar como antes para poder tratar el bloque sino hacerlo por colas
            cout << s;
        }
        else { 
            string s(b, ' ');
            llenar_string_bloque(s, i, BT_msj);
            cout << s;
        }
        ++cont;
    
    while ((cont*b) < n) {
        string aux = " ";
        for (int k = 0; (k<b) and (pos<n); ++k) {         //El mensaje se introduce a los BinTree por bloques de tamaño b.
            aux += mensaje[pos];
            ++pos;
        }
        llenar_BinTree_mensaje(aux, i, BT_msj);
       // restar_mosaico(BT_msj, BT_mosaico);
        
        if (n-pos < b) { 
            string s(n-pos,' ');
            llenar_string_bloque(s, i, BT_msj); /////duplicar como antes para poder tratar el bloque sino hacerlo por colas
            cout << s;
        }
        else { 
            string s(b, ' ');
            llenar_string_bloque(s, i, BT_msj);
            cout << s;
        }
        ++cont;
    }
    cout << '"';                                        //comillas finales de la salida del mensaje.
    cout << endl;
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








#include "Patron.hh"
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


void Patron::crear_mosaico(const BinTree<char>& BT_msj, BinTree<int> BT_mosaico, BinTree<int> BT_ptr_aux) {  //BT_ptr_aux es el BinTree patron que se va descomponiendo
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
    else 
        BT_mosaico = BinTree<int>();
}


void Patron::sumar_mosaico(BinTree<char>& BT_msj, const BinTree<int>& BT_mosaico) {
    if (not BT_msj.empty()) {
        BinTree<char> msj_l = BT_msj.left();
        BinTree<char> msj_r = BT_msj.right();
        
        BinTree<int> mos_l = BT_mosaico.left();
        BinTree<int> mos_r = BT_mosaico.right();
        
        sumar_mosaico(msj_l, mos_l);
        sumar_mosaico(msj_r, mos_r);
        
        
        int d = BT_mosaico.value();
        char c = BT_msj.value();
        char cod = 32 + (c + d - 32) % 95; 
        
        BT_msj = BinTree<char>(cod, msj_l, msj_r);
        
    }
    
    else BT_msj = BinTree<char>();
}


void Patron::restar_mosaico(BinTree<char> BT_msj, BinTree<int> BT_mosaico) {
    if (not BT_msj.empty()) {
        BinTree<char> l = BT_msj.left();
        BinTree<char> r = BT_msj.right();
        
        restar_mosaico(l, BT_mosaico.left());
        restar_mosaico(r, BT_mosaico.right());
        
        int d = BT_mosaico.value();
        char c = BT_msj.value();
        char cod = 32 + (c + (95-d) - 32) % 95; 
        
        BT_msj = BinTree<char>(cod,l,r);
    }
}
        

string Patron::leer_patron_mensaje(BinTree<char>& BT_msj) {
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
    string mensaje_completo;
    
    
    cout << '"';                                                        //comillas iniciales de la salida del mensaje.        
    while ((cont*b) < n) {                                              //Primera iteracion para crear el mosaico.
        string mensaje_bloque;
        string aux = " ";
        for (int k = 0; (k<b) and (pos<n); ++k) {                        //El mensaje se introduce a los BinTree por bloques de tamaño b.
            aux += mensaje[pos];
            ++pos;
        }
        llenar_BinTree_mensaje(aux, i, BT_msj);
        if (cont == 0) crear_mosaico(BT_msj, BT_mosaico, BT_patron);
       // sumar_mosaico(BT_msj, BT_mosaico);
        
        mensaje_bloque = leer_patron_mensaje(BT_msj);
        mensaje_completo += mensaje_bloque;
        ++cont;
    }
    cout << mensaje_completo << '"' << endl;                                       //comillas finales de la salida del mensaje.
}


void Patron::decodificar(string& mensaje, int& b) {
    int n = mensaje.length();
    int cont = 0;
    int pos = 0;
    int i = 1;
    
    cout << '"';                                            //comillas iniciales de la salida del mensaje.    
    while ((cont*b) < n) {                                  //Primera iteracion para crear el mosaico.
        string aux = " ";
        for (int k = 0; (k<b) and (pos<n); ++k) {           //El mensaje se introduce a los BinTree por bloques de tamaño b.
            aux += mensaje[pos];
            ++pos;
        }
        llenar_BinTree_mensaje(aux, i, BT_msj);
        if (cont == 0) crear_mosaico(BT_msj, BT_mosaico, BT_patron);
       // restar_mosaico(BT_msj, BT_mosaico);
        
        mensaje_bloque = leer_patron_mensaje(BT_msj);
        mensaje_completo += mensaje_bloque;
        ++cont;
    }
    cout << mensaje_completo << '"' << endl;                 //comillas finales de la salida del mensaje.
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









#include "Sesion.hh"
using namespace std;

Sesion::Sesion() {
    identif_sesion = "";    
}


Sesion::Sesion(string s) {
    identif_sesion = s;    
}

void Sesion::leer_string_BinTree() {
    leer_string_BinTree(sesion);
}

void Sesion::leer_string_BinTree(BinTree<string>& sesion) {
    string p;
    cin >> p;
    if (p != "0"){
        BinTree<string> l;
        leer_string_BinTree(l);
        BinTree<string> r;
        leer_string_BinTree(r);
        sesion = BinTree<string>(p,l,r);
  }
}


void Sesion::actualiza_problem_enviables(string& p, map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos) {
    BinTree<string> sesion_problem_enviables = buscar_problema_bin(p, sesion);
    actualiza_problem_enviables_bin(sesion_problem_enviables, problem_enviables, problem_resueltos);
        
}


BinTree<string> Sesion::buscar_problema_bin(string& p, BinTree<string>& s) {
    if (s.empty()) return BinTree<string>(); 
    
    if (s.value() == p) {
        BinTree<string> l = s.left();
        BinTree<string> r = s.right();
        return BinTree<string>(p,l,r);
    }
    else {
        BinTree<string> l = s.left();
        BinTree<string> left = buscar_problema_bin(p,l);
        
        if (size(left) == 0) {
        BinTree<string> r = s.right();
        BinTree<string> right = buscar_problema_bin(p,r);
        return right;
        }
        else return left;
    }
}


void Sesion::actualiza_problem_enviables_bin(BinTree<string>& ses, map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos) {
    
    if (not ses.empty()) {
        string s = ses.value();
        map<string, Problema>::const_iterator it = problem_resueltos.find(s);
        if (it == problem_resueltos.end())  problem_enviables.insert(make_pair(s, Problema(s)));
       
        else {
        BinTree<string> l = ses.left();
        actualiza_problem_enviables_bin(l, problem_enviables, problem_resueltos);
        BinTree<string> r = ses.right();
        actualiza_problem_enviables_bin(r, problem_enviables, problem_resueltos);
        
        }
    }
}


void Sesion::devolver_problema(map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos) {
    actualiza_problem_enviables_bin(sesion, problem_enviables, problem_resueltos);
}


bool Sesion::buscar_problema(string& prob) {
     return buscar_problema(prob, sesion);
}

bool Sesion::buscar_problema(string& p, const BinTree<string>& s) {
    if (s.empty()) return false;
    else {
        BinTree<string> l = s.left();
        BinTree<string> r = s.right();
        return (s.value() == p) or buscar_problema(p, l) or buscar_problema(p, r);
    }
}


vector<string> Sesion::problemas_sesion() {
    vector<string> problemas;
    return problemas_sesion(sesion, problemas);
}


vector<string> Sesion::problemas_sesion(const BinTree<string>& s, vector<string>& problemas) {
    if (not s.empty()) {
        problemas.push_back(s.value());
        BinTree<string> l = s.left();
        problemas_sesion(l, problemas); 
        BinTree<string> r = s.right();
        problemas_sesion(r, problemas);
    }
    return problemas;
}
    

void Sesion::escribir_string_BinTree(const BinTree<string>& sesion) {

    if (not sesion.empty()) {
        string s = sesion.value();
        BinTree<string> l = sesion.left();
        cout << "(";
        escribir_string_BinTree(l); 
        BinTree<string> r = sesion.right(); 
        escribir_string_BinTree(r);
        cout << s << ")";
    }
}

int Sesion::size(BinTree<string> s) {
    if (s.empty()) return 0;
    else return 1 + size(s.left()) + size(s.right()); 
}


void Sesion::escribir()const {
    cout << identif_sesion << " " <<  size(sesion) << " ";
    escribir_string_BinTree(sesion);
    cout << endl;
    
}
