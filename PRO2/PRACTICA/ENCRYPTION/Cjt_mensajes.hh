/** @file Cjt_mensajes.hh
    @brief Especificación de la clase Cjt_mensajes.
*/

#ifndef _CJT_MENSAJES_HH_
#define _CJT_MENSAJES_HH_

#include "Mensaje.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <map>
using namespace std;

#endif

/** @class Cjt_mensajes
    @brief Representa un conjunto de mensajes inrtroducidas en la plataforma.
    
    Cada mensajes del conjunto es representado con un identificador <em>idm</em>. Como prerrequisito no puede haber dos mensajes en el sistema con el mismo identificador.
    
*/


class Cjt_mensajes 
{
private:
    
    /** @brief Map (string - Mensaje) que tiene como parámetro clave los identificadores de los mensajes <em>idm</em> del sistema y como parámetro asociado la clase Mensaje correspondiente. */
    map<string, Mensaje> MAP_mensajes;


public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un conjunto de mensajes.
        \pre <em>cierto</em>.
        \post El resultado es un conjunto de mensajes vacío.
    */
    Cjt_mensajes();
    
    
    //Modificadoras
    
     /** @brief Añade los mensajes <em>idm</em> introducidos en la entrada del programa a un map <em>MAP_mensajes</em> que tiene como parámetro clave el string identificador del mensaje y como parámetro asociado la misma clase Mensaje.
     
        \pre La clase <em>Cjt_mensajes</em> está inicializada.
        \post Se obtiene el map <em>MAP_mensajes</em> con todos los identificadores introducidos en el canal de entrada del programa y sus respectivas clases Mensaje. Están ordenados por orden alfabético (propiedad del map).
    */
    void leer();
    
    
    /** @brief Añade un nuevo mensaje con identificador <em>idm</em> al conjunto de mensajes.
     
        \pre El mensaje <em>idm</em> no existe en el conjunto de mensajes.
        \post El parámetro implícito pasa a contener el conjunto de mensajes original más <em>idm</em> e imprime el número de mensajes totales despues de añadirlo.
    */
    void nuevo_mensaje(string& idm);
    
    
    /** @brief Suprime el mensaje con identificador <em>idm</em> del conjunto de mensajes.
     
        \pre El mensaje <em>idm</em> existe en el conjunto de mensajes.
        \post El parámetro implícito pasa a contener el conjunto de mensajes original menos <em>idm</em>.
    */
    void borra_mensaje(string& idm);
    

    //Consultoras
    
    /** @brief Comprueba que el mensaje <em>idm</em> se encuentre en el conjunto de mensajes de la plataforma.
      
        \pre <em>cierto</em>.
        \post Devuelve 1 (cierto) si el mensaje <em>idm</em> existe en el conjunto de mensajes de la plataforma. En caso contrario devuelve 0 (falso).
    */
    bool existe(string& idm)const;
   
    
    /** @brief Busca el mensaje con identificador <em>idm</em>.
      
        \pre Existe el mensaje con identificador <em>idm</em>.
        \post Devuelve el mensaje con identificador <em>idm</em>. 
    */
    string obtener_mensaje(string& idm);
    
    
    //Escritura del conjunto de mensajes
    
    /** @brief Se listan los mensajes de la colección ordenados alfabeticamente por su identificador.
     
        \pre <em>cierto</em>.
        \post Se escribe los mensajes de la plataforma ordenados alfabeticamente por su identificador.
    */
    void listar_mensajes();
 
};    
#endif
