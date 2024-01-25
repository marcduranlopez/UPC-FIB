/** @file conj_problemas.hh
    @brief Especificación de la clase conj_problemas.
*/

#ifndef _CONJ_PROBLEMAS_HH_
#define _CONJ_PROBLEMAS_HH_

#include "conj_sesiones.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <map>
#include <set>
using namespace std;

#endif

/** @class conj_problemas
    @brief Representa un conjunto de problemas de la plataforma.
    
    Cada problema del conjunto es representado con un identificador. Como prerrequisito un problema no puede repetirse en la misma sesión ni en el mismo curso.
    
*/

class conj_problemas 
{
private:
    
    /** @brief Map (string - Problema) que tiene como parámetro clave los identificadores de los problemas de la plataforma y como parámetro asociado la clase Problema correspondiente. */
    map<string, Problema> problemas;
    
    /** @brief Conjunto de problemas de la clase */
    set<Problema> aux;


public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un conjunto de problemas.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de conjunto de problemas vacía.
    */
    conj_problemas();
    
    
    //Modificadoras
    
     /** @brief Añade los problemas <em>p</em> introducidos en la entrada del programa a un map <em>problemas</em> que tiene como parámetro clave el string del problema y como parámetro asociado la misma clase Problema.
     
        \pre La clase <em>conj_problemas</em> está inicializada.
        \post Se obtiene el map <em>problemas</em> con todos los problemas introducidos en el canal de entrada del programa y sus respectivas clases Problema. Están ordenados por orden alfabético. Queda como parámetro implícito del conj_problemas.
    */
    void leer();
    
    
    /** @brief Añade un nuevo problema con identificador <em>p</em> al conjunto de problemas.
     
        \pre El problema <em>p</em> no existe en el conjunto de problemas.
        \post El parámetro implícito pasa a contener el conjunto de problemas original más <em>p</em> y escribe el número de problemas después de añadirlo.
    */
    void nuevo_problema(string& p);
    
    
    /** @brief Incrementa en una unidad el número de envíos totales de un problema <em>p</em>.
     
        \pre El problema <em>p</em> existe en el conjunto de problemas.
        \post Se ha sumado en uno el número de envíos totales de la clase Problema correspondiente al problema <em>p</em>.
    */
    void suma_envio(string p);
    
    
    /** @brief Incrementa en una unidad el número de envíos con éxito de un problema <em>p</em>.
     
        \pre El problema <em>p</em> existe en el conjunto de problemas.
        \post Se ha sumado en uno el número de envíos con éxito de la clase Problema correspondiente al problema <em>p</em>.
    */
    void suma_envio_exito(string p); 
    
    
    /** @brief Llena un set auxiliar con todos los identificadores de los problemas de la plataforma. (Para ordenarlos crecientemente por ratio).
     
        \pre El map problemas está inicializado y contiene los identificadores de los problemas.
        \post Se obtiene un set auxiliar con todos los identificadores de los problemas de la plataforma ordenados crecientemente por ratio y por identificador.
    */
    void llenar_conjunto();
    
    
    //Consultoras
    
    /** @brief Comprueba que el problema <em>p</em> se encuentre en el conjunto de problemas de la plataforma.
      
        \pre <em>cierto</em>.
        \post Devuelve 1 (cierto) si el problema <em>p</em> existe en el conjunto de problemas de la plataforma. En caso contrario devuelve 0 (falso).
    */
    bool existe(string& p)const;
    
    
    //Escritura del conjunto de problemas
    
    /** @brief  Se listan los problemas de la colección, indicando para cada problema el string <em>p</em>, el número <em>t</em> de envíos totales y el número <em>e</em> de envíos con éxito a dicho problema, en ambos casos de usuarios presentes o pasados. También se ha de escribir el ratio (t + 1)/(e + 1), y los problemas han de listarse en orden creciente por dicho ratio. En caso de empate, se han de listar por orden creciente de identificador.
     
        \pre <em>cierto</em>.
        \post Se escribe para cada problema el string <em>p</em>, el número <em>t</em> de envíos totales y el número <em>e</em> de envíos con éxito, de usuarios pasados y actuales y, por último, también imprime el ratio ((t + 1)/(e + 1)) y los problemas irán en orden creciente de este.
    */
    void listar_problemas();
    

    //Escritura de un problema
    
    /** @brief Se escribe el string <em>p</em>, el número <em>t</em> de envíos totales y el número <em>e</em> de envíos con éxito de la clase Problema correspondiente al problema <em>p</em> y, por último, también se muestra su ratio ((t + 1)/(e + 1)).
     
        \pre Existe el problema <em>p</em> en la plataforma.
        \post Se imprime el string <em>p</em>, el número <em>t</em> de envíos totales y el número <em>e</em> de envíos con éxito de la clase Problema correspondiente al problema <em>p</em> y, por último, también se muestra su ratio ((t + 1)/(e + 1)).
    */
    void escribir_problema(string& p);
 
};    
#endif
