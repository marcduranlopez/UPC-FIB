/**
 * @mainpage EVALUATOR: Plataforma de gestión de problemas y cursos de programación.

    La plataforma EVALUATOR integra una colección de problemas de programación, un repositorio de sesiones compuestas por problemas de dicha colección, un conjunto de cursos formados por una o más sesiones, y un conjunto de usuarios registrados. Se introducen las clases <em>conj_problemas</em>, <em>Problema</em>, <em>conj_sesiones</em>, <em>Sesion</em>, <em>conj_cursos</em>, <em>Curso</em>, <em>conj_usuarios</em> y <em>Usuario</em>.
 */

/** @file program.cc
    @brief Programa principal para el proyecto EVALUATOR: <em>Plataforma de gestión de problemas y cursos de programación</em>.
*/

#include "conj_problemas.hh"
#include "conj_sesiones.hh"
#include "conj_cursos.hh"
#include "conj_usuarios.hh"

#include <iostream>
using namespace std;

/** @brief Programa principal para el proyecto EVALUATOR: <em>Plataforma de gestión de problemas y cursos de programación</em>.
 */

int main() {
    conj_problemas cp;
    conj_sesiones cs;
    conj_cursos cc;
    conj_usuarios cu;
    
    cp.leer();
    cs.leer();
    cc.leer();
    cu.leer();
    
    string op;
    cin >> op;
    
    string p, s, u;
    int c;
    int r;
    
    while (op != "fin") {
        if (op == "nuevo_problema" or op == "np") {
            cin >> p;
            if (op == "np") cout << "#np " << p << endl;
            else cout << "#nuevo_problema " << p << endl;
            
            if (cp.existe(p)) cout << "error: el problema ya existe" << endl;
            else
                cp.nuevo_problema(p);
        }
        
        
        else if (op == "nueva_sesion" or op == "ns") {
            cin >> s;
            if (op == "ns") cout << "#ns " << s << endl;
            else cout << "#nueva_sesion " << s << endl;
            
            if (cs.existe(s)) cout << "error: la sesion ya existe" << endl;
            else
                cs.nueva_sesion(s);
        }
        
        
        else if (op == "nuevo_curso" or op == "nc") {
            if (op == "nc") cout << "#nc" << endl;
            else cout << "#nuevo_curso" << endl;
            
            cc.nuevo_curso(cs);
        } 


        else if (op == "alta_usuario" or op == "a") {
            cin >> u;
            if (op == "a") cout << "#a " << u << endl;
            else cout << "#alta_usuario " << u << endl;
            
            if (cu.existe(u)) cout << "error: el usuario ya existe" << endl;
            else
                cu.alta_usuario(u);
        }
        
        
        else if (op == "baja_usuario" or op == "b") {
            cin >> u;
            if (op == "b") cout << "#b " << u << endl;
            else cout << "#baja_usuario " << u << endl;
            
            if (not cu.existe(u)) cout << "error: el usuario no existe" << endl;
            else
                cu.baja_usuario(u,cc);
        }
        
        
        else if (op == "inscribir_curso" or op == "i") {
            cin >> u >> c;
            if (op == "i") cout << "#i " << u << " " << c << endl;
            else cout << "#inscribir_curso " << u << " " << c << endl;
            
            if (not cu.existe(u)) cout << "error: el usuario no existe" << endl; 
            else if (not cc.existe(c)) cout << "error: el curso no existe" << endl;
            else if ((cu.curso_usuario(u) != 0)) cout << "error: usuario inscrito en otro curso" << endl;
            else 
                cu.inscribir_curso(u,c,cc,cs);
        }
        
        
        else if (op == "curso_usuario" or op == "cu") {
            cin >> u;
            if (op == "cu") cout << "#cu " << u << endl;
            else cout << "#curso_usuario " << u << endl;
            
            if (not cu.existe(u)) cout << "error: el usuario no existe" << endl;
            else
               cout << cu.curso_usuario(u) << endl;
        }
        
        
        else if (op == "sesion_problema" or op == "sp") {
            cin >> c >> p;
            if (op == "sp") cout << "#sp " << c << " " << p << endl;
            else cout << "#sesion_problema " << c << " " << p << endl;
            
            if (not cc.existe(c)) cout << "error: el curso no existe" << endl;
            else if (not cp.existe(p)) cout << "error: el problema no existe" << endl;
            else if (not cc.pertenece(c,p,cs)) cout << "error: el problema no pertenece al curso" << endl;
            else 
               cout << cc.sesion_problema(c,p,cs) << endl;
        }
        
        
        else if (op == "problemas_resueltos" or op == "pr") {
           cin >> u;
           if (op == "pr") cout << "#pr " << u << endl;
           else cout << "#problemas_resueltos " << u << endl;
           
           if (not cu.existe(u)) cout << "error: el usuario no existe" << endl;
           else
               cu.problemas_resueltos(u); 
        }
        
        
        else if (op == "problemas_enviables" or op == "pe") {
            cin >> u;
            if (op == "pe") cout << "#pe " << u << endl;
            else cout << "#problemas_enviables " << u << endl;
            
            if (not cu.existe(u)) cout << "error: el usuario no existe" << endl;
            else if (cu.curso_usuario(u) == 0) cout << "error: usuario no inscrito en ningun curso" << endl;
            else
                cu.problemas_enviables(u);
        }
        
        
        else if (op == "envio" or op == "e") {
            cin >> u >> p >> r;
            if (op == "e") cout << "#e " << u << " " << p << " " << r << endl;
            else cout << "#envio " << u << " " << p << " " << r << endl;
            
            cu.envio(u,p,r,cp,cs,cc);
        }
        
        
        else if (op == "listar_problemas" or op == "lp") {
            if (op == "lp") cout << "#lp" << endl;
            else cout << "#listar_problemas" << endl;
            
            cp.listar_problemas();
        }
        
        
        else if (op == "escribir_problema" or op == "ep") {
            cin >> p;
            if (op == "ep") cout << "#ep " << p << endl;
            else cout << "#escribir_problema " << p << endl;
            
            if (not cp.existe(p)) cout << "error: el problema no existe" << endl;
            else
            cp.escribir_problema(p);
            
        }
        
        
        else if (op == "listar_sesiones" or op == "ls") {
            if (op == "ls") cout << "#ls" << endl;
            else cout << "#listar_sesiones" << endl;
            
            cs.listar_sesiones();
        }
        
        
        else if (op == "escribir_sesion" or op == "es") {
            cin >> s;
            if (op == "es") cout << "#es " << s << endl;
            else cout << "#escribir_sesion " << s << endl;
        
            if (not cs.existe(s)) cout << "error: la sesion no existe" << endl;
            else
            cs.escribir_sesion(s);
        }
        
        
        else if (op == "listar_cursos" or op == "lc") {
            if (op == "lc") cout << "#lc" << endl;
            else cout << "#listar_cursos" << endl;
            
            cc.listar_cursos();
        }
        
        
        else if (op == "escribir_curso" or op == "ec") {
            cin >> c;
            if (op == "ec") cout << "#ec " << c << endl;
            else cout << "#escribir_curso " << c << endl;
            
            if (not cc.existe(c)) cout << "error: el curso no existe" << endl;
            else
            cc.escribir_curso(c);
        }
        
        
        else if (op == "listar_usuarios" or op == "lu") {
            if (op == "lu") cout << "#lu" << endl;
            else cout << "#listar_usuarios" << endl;
            
            cu.listar_usuarios();
        }
        
        
        else if (op == "escribir_usuario" or op == "eu") {
            cin >> u;
            if (op == "eu") cout << "#eu " << u << endl;
            else cout << "#escribir_usuario " << u << endl;
            
            if (not cu.existe(u)) cout << "error: el usuario no existe" << endl;
            else
            cu.escribir_usuario(u);
        }
        
        cin >> op;
    }
}
        
