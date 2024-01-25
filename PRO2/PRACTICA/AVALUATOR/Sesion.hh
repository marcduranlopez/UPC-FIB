/** @file Sesion.hh
    @brief Especificación de la clase Sesion.
*/

#ifndef _SESION_HH_
#define _SESION_HH_

#include "Problema.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <vector>
#include <map>
using namespace std;

#include "BinTree.hh"
#endif

/** @class Sesion
    @brief Representa una sesión de la plataforma.
    
    La sesión se representa con un identificador. Cada sesión contiene un número de problemas representados cada uno de ellos con un identificador.
    
*/

class Sesion 
{
private:
    
    /** @brief Arbol binario que contiene todos los problemas de la sesion. */
    BinTree<string> sesion;
    
    /** @brief identificador de la sesion.  */
    string identif_sesion; 
    
    
    /** @brief Añade los identificadores de los problemas <em>p</em> introducidos en la entrada del programa al arbol binario de la sesion.
     
        \pre Existe la sesion definida en el parametro implicito.
        \post Utilizando recursividad se obtiene el arbol binario de la sesion con todos los identificadores de los problemas introducidos en el canal de entrada. 
    */
    static void leer_string_BinTree(BinTree<string>& ses); 
    
    
    /** @brief Escribe por el canal estandar de salida los identificadores de los problemas <em>p</em> que contiene el arbol binario de la sesion.
     
        \pre El arbol binario de la sesion esta inicializado.
        \post Utilizando recursividad se escribe por el canal estandar de salida los identificadores de los problemas <em>p</em> que contiene el arbol binario de la sesion.
    */
    static void escribir_string_BinTree(const BinTree<string>& ses);  
    
    
    /** @brief Devuelve el numero de problemas que contiene el arbol binario (medida del BinTree).
     
        \pre El arbol binario de la sesion esta inicializado.
        \post Devuelve el numero de problemas que contiene el arbol binario referenciado en el parametro explicito de la funcion.
    */
    static int size(BinTree<string> ses);
    
    
    /** @brief Consulta si el problema con identificador <em>p</em> esta en el arbol binario de la sesion referenciado en el parametro explicito de la funcion.
        
        \pre Existe el problema <em>p</em> y el arbol binario de la sesion esta inicializado.
        \post Devuelve 1 (cierto) si el problema con identificador <em>p</em> esta en el arbol binario de la sesion referenciado en el parametro explicito de la funcion. En caso contrario devuelve 0 (falso).
    */
    static bool buscar_problema(string& p, const BinTree<string>& s);
    
    
    /** @brief Se leen los identificadores de los problemas del arbol binario de forma recursiva y se van añadiendo a un vector. Cuando acaba la recursividad devuelve el vector. 
        \pre Existe la sesión implicita en la plataforma y el arbol binario de la sesion esta inicializado.
        \post Devuelve un vector con los identificadores de los problemas de la sesión.
    */
    static vector<string> problemas_sesion(const BinTree<string>& s, vector<string>& problemas);
    
    
    /** @brief Busca de forma recursiva la raiz del arbol o subarbol binario con identificador igual a <em>p</em>. Cuando lo encuentra devuelve el subarbol binario que tiene como raiz el identificador <em>p</em>.
        
        \pre Existe el problema <em>p</em> y el arbol binario de la sesion esta inicializado.
        \post Devuelve el subarbol binario que tiene como raiz el identificador <em>p</em>.
    */
    BinTree<string> buscar_problema_bin(string& p, BinTree<string>& s);
    
    
    /** @brief Recorre el arbol binario <em>s</em> recursivamente en preorden actualizando los problemas que son enviables. 
        \pre <em>Cierto</em>.
        \post Los problemas enviables listados cumplen todos los prerrequisitos para ser enviados.
    */
    void actualiza_problem_enviables_bin(BinTree<string>& s, map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos);
    

public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar una sesión.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de una sesión vacía.
    */
    Sesion();
    
    
     /** @brief Creadora por nombre.
     
        Se ejecuta automáticamente al declarar una sesión.
        \pre <em>cierto</em>.
        \post El resultado es una estructura con la sesión <em>s</em>.
    */
    Sesion(string s);
    
    
    //Modificadoras
    
    /** @brief Añade los problemas <em>p</em> introducidos en la entrada del programa al arbol binario de la sesion.
     
        \pre Existe la sesion definida en el parametro implicito.
        \post Se obtiene el arbol binario de la sesion con todos los problemas introducidos en la entrada.
    */
    void leer_string_BinTree(); 

    
    /** @brief Actualiza el map de los problemas enviables de la sesión a la que pertenece el problema con identificador <em>p</em> despues de hacer el envio de este.
        
        \pre Existe el problema <em>p</em>.
        \post Se actualiza el map de problemas enviables con los problemas que cumplen todos los prerrequisitos para ser enviados.
    */
    void actualiza_problem_enviables(string& p, map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos);
    
   
     /** @brief Actualiza el map de los problemas que son enviables a la sesión teniendo en cuenta los problemas que se han resuleto hasta el momento.
        
        \pre <em>Cierto</em>.
        \post Se actualiza el map de problemas enviables con los problemas que cumplen todos los prerrequisitos para ser enviados.
    */
    void devolver_problema(map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos);
    
    
    //Consultoras
    
    
    /** @brief Se leen los identificadores de los problemas de la sesión implicitra de forma recursiva y se van añadiendo a un vector. Cuando acaba la recursividad devuelve el vector. 
        \pre Existe la sesión implicita.
        \post Devuelve un vector con los identificadores de los problemas de la sesión implicita.
    */
    vector<string> problemas_sesion();
    
    
    /** @brief Consulta si el problema con identificador <em>p</em> pertenece al parametro implícito.
        
        \pre Existe el problema <em>p</em>.
        \post Se imprime 1 (cierto) si el problema con identificador <em>p</em> pertenece al parametro implícito. En caso contrario devuelve 0 (falso).
    */
    bool buscar_problema(string& p);
    
    
    //Escritura 
    
    /** @brief Se escribe el número de problemas que forman la sesión de la sesion implícita y los identificadores de esos problemas en preorden.
        
        \pre Existe la sesión con identificador <em>s</em>.
        \post Se escribe el identificador y el número de problemas de la sesion implícita con sus correspondientes identificadores.
    */ 
    void escribir()const;
    
    
};
#endif
