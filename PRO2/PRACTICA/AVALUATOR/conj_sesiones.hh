/** @file conj_sesiones.hh
    @brief Especificación de la clase conj_sesiones.
*/

#ifndef _CONJ_SESIONES_HH_
#define _CONJ_SESIONES_HH_

#include "Sesion.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <map>
using namespace std;

#endif

/** @class conj_sesiones
    @brief Representa un conjunto de sesiones de la plataforma.
    
    Cada sesión del conjunto es representado con un nombre que ira seguida de una secuencia de identificadores de problemas, siguiendo un recorrido en preorden de su estructura de prerequisitos.
    
*/

class conj_sesiones 
{
private:
    
    /** @brief Map (string - Sesion) que tiene como parametro clave los identificadores de las sesiones de la plataforma y como parametro asociado la clase Sesion correspondiente. */
    map<string, Sesion> sesiones;
    
    
public:    
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un conjunto de sesiones.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de conjunto de sesiones vacía.
    */
    conj_sesiones();
    
    
    //Modificadoras
    
    /** @brief Añade las sesiones <em>s</em> introducidas en la entrada del programa a un map <em>sesiones</em>  que tiene como parametro clave el string de la sesion y como parametro asociado la misma clase Sesion. Es el parametro implicito de la funcion.
     
        \pre La clase <em>conj_sesiones</em> esta inicializada.
        \post Se obtiene el map <em>sesiones</em> con todas las sesiones introducidas en el canal de entrada del programa y sus respectivas clases Sesion. Estan ordenadas por orden alfabetico. Queda como parametro implicito del conj_sesiones.
    */
    void leer();
    
    
    /** @brief Añade una nueva sesión con identificador <em>s</em> al conjunto de sesiones.
     
        \pre La sesión <em>s</em> no existe en el conjunto de sesiones.
        \post El parámetro implícito pasa a contener el conjunto de sesiones original más <em>s</em>.
    */
    void nueva_sesion(string& s);
    
    
    /** @brief Actualiza el map de los problemas que son enviables a la sesión <em>s</em> a la que pertenece el problema con identificador <em>p</em> despues de hacer el envio de este.
        
        \pre Existe el problema <em>p</em> y la sesión <em>s</em>.
        \post Se actualiza el map de problemas enviables con los problemas que cumplen todos los prerrequisitos para ser enviados.
    */
    void actualiza_problem_enviables(string& p, string& s, map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos);
     
    
     /** @brief Actualiza el map de los problemas que son enviables a la sesión <em>s</em> teniendo en cuenta los problemas que se han resuleto hasta el momento.
        
        \pre Existe la sesión <em>s</em>.
        \post Se actualiza el map de problemas enviables con los problemas que cumplen todos los prerrequisitos para ser enviados.
    */
    void devolver_problema(string& s, map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos);
     
    
    //Consultoras
    
    /** @brief Consulta si la sesion con identificador <em>s</em> contiene el problema con identificador <em>p</em>.
        
        \pre Existe la sesion <em>s</em> y el problema <em>p</em>. 
        \post Devuelve 1 (cierto) si el problema <em>p</em> pertenece a la sesion <em>s</em>. En caso contrario devuelve 0 (falso).
    */
    bool buscar_problema(string& s, string& p);


     /** @brief Comprueba que la sesión <em>s</em> se encuentre en el conjunto de sesiones de la plataforma.
      
        \pre <em>cierto</em>.
        \post Devuelve 1 (cierto) si la sesión <em>s</em> existe en el conjunto de sesiones de la plataforma. En caso contrario devuelve 0 (falso).
    */
    bool existe(string& s)const;
    
    
    /** @brief Se leen los identificadores de los problemas de la sesión <em>s</em> de forma recursiva y se van añadiendo a un vector. Cuando acaba la recursividad devuelve el vector. 
        \pre Existe la sesión <em>s</em> en la plataforma.
        \post Devuelve un vector con los identificadores de los problemas de la sesión <em>s</em>.
    */
    vector<string> problemas_sesion(string s);
    
    
    //Escritura del conjunto de sesiones
    
    /** @brief Se listan las sesiones actuales de la plataforma, ordenadas crecientemente por su identificador y mostrando, para cada sesión, el número de problemas que la forman y los identificadores de dichos problemas, siguiendo su estructura de prerequisitos en postorden.
     
        \pre <em>cierto</em>.
        \post Imprime un listado con las sesiones actuales de la plataforma, ordenadas crecientemente por identificador y para cada sesión imprime el número de problemas y sus identificadores en postorden.
    */
    void listar_sesiones()const;
    
    
    //Escritura de una sesión
    
    /** @brief Se indica, siguiendo la estructura de prerequisitos en postorden, el número de problemas que forman las sesión <em>s</em> y sus identificadores.
     
        \pre Existe la sesión <em>s</em> en la plataforma.
        \post Se imprime el número de problemas que forman la sesión <em>s</em> y sus identificadores. 
    */
    void escribir_sesion(string& s)const;
    
    
};
#endif
    
    
