/** @file Cjt_patrones.hh
    @brief Especificación de la clase Cjt_patrones.
*/

#ifndef _CJT_PATRONES_HH_
#define _CJT_PATRONES_HH_

#include "Cjt_mensajes.hh"
#include "Patron.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <vector>
using namespace std;

#endif

/** @class Cjt_patrones
    @brief Representa un conjunto de patrones inrtroducidos en la plataforma.
    
    Cada patron del conjunto es representado con un identificador (idp). 
    
*/


class Cjt_patrones
{
private:
    
     /** @brief Vector que contiene las clases Patron de todos los patrones la plataforma. */
    vector<Patron> VEC_patrones;  


public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un conjunto de patrones.
        \pre <em>cierto</em>.
        \post El resultado es un conjunto de patrones vacío.
    */
    Cjt_patrones();
    
    
    //Modificadoras
    
     /** @brief Añade los patrones <em>idp</em> introducidos en la entrada del programa a un vector <em>VEC_patrones</em> de clases Patron.
     
        \pre La clase <em>Cjt_patrones</em> esta inicializada.
        \post Se obtiene el vector <em>VEC_patrones</em> con todas las clases Patron como parametro implicito del Cjt_patrones. Para cada patron añadido se leen sus valores en preorden con marca -1.
    */
    void leer();
    
    
    /** @brief Añade una nuevo patron con identificador <em>idp</em> al conjunto de patrones.
     
        \pre <em>cierto</em>.
        \post El parámetro implícito pasa a contener el conjunto de patrones original más uno y imprime el número de patrones totales despues de añadirlo. 
    */
    void nuevo_patron();
    
    
    /** @brief Lee y codifica un mensaje mediante el patron con identificador <em>idp</em>, dividiendo el mensaje en bloques de tamaño <em>b</em>.
     
        \pre Existe el patron con identificador <em>idp</em>.
        \post Imprime el mensaje codificado por el metodo de sustitucion utilizando el patron <em>idp</em>.
    */
    void codificar_patron(int idp, int b);
    
    
    
     /** @brief Codifica el mensaje con identificador <em>idm</em> mediante lel patron con identificador <em>idp</em>, dividiendo el mensaje en bloques de tamaño <em>b</em>.
     
        \pre Existe el mensaje con identificador <em>idm</em> y el patron con identificador <em>idp</em>.
        \post Imprime el mensaje con identificador <em>idm</em> codificado por el metodo de sustitucion utilizando el patron <em>idp</em>. 
    */
    void codificar_guardado_patron(string idm, int idp, int b, Cjt_mensajes& cm);
    
    
    
    /** @brief Lee y decodifica un mensaje mediante el patron con identificador <em>idp</em>, dividiendo el mensaje en bloques de tamaño <em>b</em>.
     
        \pre Existe el patron con identificador <em>idp</em>.
        \post Imprime el mensaje decodificado por el metodo de sustitucion utilizando el patron <em>idp</em>.
    */
    void decodificar_patron(int idp, int b);
    
    
    //Consultoras
    
    /** @brief Comprueba que el patron <em>idp</em> se encuentre en el conjunto de patrones de la plataforma.
      
        \pre <em>cierto</em>.
        \post Devuelve 1 (cierto) si el patron <em>idp</em> existe en el conjunto de patrones de la plataforma. En caso contrario devuelve 0 (falso).
    */
    bool existe(int& idp)const;
    
    
    //Escritura del conjunto de mensajes
    
    /** @brief Se listan los patrones de la colección por orden creciente de identificador. 
     
        \pre <em>cierto</em>.
        \post Se escribe los patrones de la plataforma por orden creciente de identificador.
    */
    void listar_patrones();
 
};    
#endif
