/**
 * @mainpage ENCRIPTACION DE MENSAJES: Plataforma para encriptar y desencriptar mensajes por permutacion y sustitucion.

    La plataforma ENCRIPTACION DE MENSAJES integra dos metodos de incriptacion. Estos son el de <em>permutacion</em>, utilizando el algoritmo de <em>reordenacion por rejillas</em>, y el de <em>sustitucion</em>, utilizando el algoritmo de <em>patrones arborescentes</em>. Tambien se implementan los algoritmos de desencriptacion para cada uno de ellos. 
 */

/** @file program.cc
    @brief Programa principal para el proyecto ENCRIPTACION DE MENSAJES: <em>Plataforma para encriptar y desencriptar mensajes por permutacion y sustitucion</em>.
*/

#include "Cjt_mensajes.hh"
#include "Cjt_rejillas.hh"
#include "Cjt_patrones.hh"

#include <iostream>
using namespace std;

/** @brief Programa principal para el proyecto ENCRIPTACION DE MENSAJES: <em>Plataforma para encriptar y desencriptar mensajes por permutacion y sustitucion</em>.
*/


int main() {
    Cjt_mensajes cm;
    Cjt_rejillas cr;
    Cjt_patrones cp;
    
    cm.leer();
    cr.leer();
    cp.leer();
    
    string op;           //operacion a ejecutar
    cin >> op;
    
    string idm;          //identificador del mensaje
    int idr,idp;         //identificador de rejilla y patron
    int dim, tam;        //Dimension y tamaño rejilla
    int b;               //tamaño bloques
    
     while (op != "fin") {
        if (op == "nuevo_mensaje" or op == "nm") {
            cin >> idm;
            if (op == "nm") cout << "#nm " << idm << endl;
            else cout << "#nuevo_mensaje " << idm << endl;
            
            if (cm.existe(idm)) cout << "error: ya existe un mensaje con ese identificador" << endl;
            else
                cm.nuevo_mensaje(idm);
        }
        
        
        else if (op == "nueva_rejilla" or op == "nr") {
            cin >> dim >> tam;
            if (op == "nr") cout << "#nr" << endl;
            else cout << "#nueva_rejilla" << endl;
            
            if (4*tam != ((dim*dim))) cout << "error: dimensiones incorrectas de la rejilla" << endl; 
            else
                cr.nueva_rejilla(dim, tam);
        }
        
        
        else if (op == "nuevo_patron" or op == "np") {
            if (op == "np") cout << "#np" << endl;
            else cout << "#nuevo_patron" << endl;
            
                cp.nuevo_patron();
        }
        
        
        else if (op == "borra_mensaje" or op == "bm") {
            cin >> idm;
            if (op == "bm") cout << "#bm " << idm << endl;
            else cout << "#borra_mensaje " << idm << endl;
            
            if (not cm.existe(idm)) cout << "error: el mensaje no existe" << endl;
            else
                cm.borra_mensaje(idm);
        }
        
        
        else if (op == "listar_mensajes" or op == "lm") {
            if (op == "lm") cout << "#lm" << endl;
            else cout << "#listar_mensajes" << endl;
            
            cm.listar_mensajes();
        }
        
        
        else if (op == "listar_rejillas" or op == "lr") {
            if (op == "lr") cout << "#lr" << endl;
            else cout << "#listar_rejillas" << endl;
            
            cr.listar_rejillas();
        }
        
        
        else if (op == "listar_patrones" or op == "lp") {
            if (op == "lp") cout << "#lp" << endl;
            else cout << "#listar_patrones" << endl;
            
            cp.listar_patrones();
        }
        
        
        else if (op == "codificar_rejilla" or op == "cr") {
            cin >> idr;
            if (op == "cr") cout << "#cr " << idr << endl;
            else cout << "#codificar_rejilla " << idr << endl;
            
            if (not cr.existe(idr)) cout << "error: la rejilla no existe" << endl;
            else
                cr.codificar_rejilla(idr);
        }
        
        
        else if (op == "codificar_guardado_rejilla" or op == "cgr") {
            cin >> idm >> idr;
            if (op == "cgr") cout << "#cgr " << idm << ' ' << idr << endl;
            else cout << "#codificar_guardado_rejilla " << idm << ' ' << idr << endl;
            
            if (not cm.existe(idm)) cout << "error: el mensaje no existe" << endl;
            else if (not cr.existe(idr)) cout << "error: la rejilla no existe" << endl;
            else
                cr.codificar_guardado_rejilla(idm, idr, cm);
        }
        
        
        else if (op == "decodificar_rejilla" or op == "dr") {
            cin >> idr;
            if (op == "dr") cout << "#dr " << idr << endl;
            else cout << "#decodificar_rejilla " << idr << endl;
            
            if (not cr.existe(idr)) cout << "error: la rejilla no existe" << endl;
            else
                cr.decodificar_rejilla(idr);
        }

        
        else if (op == "codificar_patron" or op == "cp") {
            cin >> idp >> b;
            if (op == "cp") cout << "#cp " << idp << ' ' << b << endl;
            else cout << "#codificar_patron " << idp << ' ' << b << endl;
            
            if (not cp.existe(idp)) cout << "error: el patron no existe" << endl;
            else
                cp.codificar_patron(idp, b);
        }
        
        
        else if (op == "codificar_guardado_patron" or op == "cgp") {
            cin >> idm >> idp >> b;
            if (op == "cgp") cout << "#cgp " << idm << ' ' << idp  << ' ' << b << endl;
            else cout << "#codificar_guardado_patron " << idm << ' ' << idp << ' ' << b << endl;
            
            if (not cm.existe(idm)) cout << "error: el mensaje no existe" << endl;
            else if (not cp.existe(idp)) cout << "error: el patron no existe" << endl;
            else
                cp.codificar_guardado_patron(idm, idp, b, cm);
        }
        
        
        else if (op == "decodificar_patron" or op == "dp") {
            cin >> idp >> b;
            if (op == "dp") cout << "#dp " << idp << ' ' << b << endl;
            else cout << "#decodificar_patron " << idp << ' ' << b << endl;
            
            if (not cp.existe(idp)) cout << "error: el patron no existe" << endl;
            else
                cp.decodificar_patron(idp, b);
        }
        
        cin >> op;
     }
}
        
