/** @file Cjt_rejillas.hh
    @brief Especificación de la clase Cjt_rejillas.
*/

#ifndef _CJT_REJILLAS_HH_
#define _CJT_REJILLAS_HH_

#include "Cjt_mensajes.hh"
#include "Rejilla.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <vector>
using namespace std;

#endif

/** @class Cjt_rejillas
    @brief Representa un conjunto de rejillas inrtroducidas en la plataforma.
    
    Cada rejilla del conjunto es representado con un identificador (idr). Las rejillas deben cumplir prerrequisitos de dimension y longitud para que sean validas para encriptar mensajes.
    
*/


class Cjt_rejillas
{
private:
    
     /** @brief Vector que contiene las clases Rejilla de todos las rejillas de la plataforma. */
    vector<Rejilla> VEC_rejillas;  


public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un conjunto de rejillas.
        \pre <em>cierto</em>.
        \post El resultado es un conjunto de rejillas vacío.
    */
    Cjt_rejillas();
    
    
    //Modificadoras
    
     /** @brief Añade las rejillas <em>idr</em> introducidas en la entrada del programa a un vector <em>VEC_rejillas</em> de clases Rejilla.
     
        \pre La clase <em>Cjt_rejillas</em> esta inicializada.
        \post Se obtiene el vector <em>VEC_rejillas</em> con todas las clases Rejilla como parametro implicito del Cjt_rejillas. Para cada rejilla se leera su dimension <em>n</em>, su tamaño <em>k</em> y sus <em>k</em> posiciones. Las rejillas añadidas al vector son validas para encriptar mensajes.
    */
    void leer();
    
    
    /** @brief Añade una nueva rejilla con identificador <em>idr</em> al conjunto de rejillas.
     
        \pre <em>cierto</em>.
        \post El parámetro implícito pasa a contener el conjunto de rejillas original más uno y imprime el número de rejillas totales despues de añadirlo. La nueva rejilla añadida es consistente en dimension y longitud y es valida para encriptar.
    */
    void nueva_rejilla(int& dim, int& tam);
    
    
    /** @brief Lee y codifica un mensaje mediante la rejilla con identificador <em>idr</em>.
     
        \pre Existe la rejilla con identificador <em>idr</em>.
        \post Imprime el mensaje codificado por el metodo de permutacion utilizando la rejilla <em>idr</em>. Si el ultimo bloque del mensaje no se llena, se completa con caracteres blancos (' ') antes de codificarlo.
    */
    void codificar_rejilla(int idr);
    
    
    /** @brief Codifica el mensaje con identificador <em>idm</em> mediante la rejilla con identificador <em>idr</em>.
     
        \pre Existe el mensaje con identificador <em>idm</em> y la rejilla con identificador <em>idr</em>.
        \post Imprime el mensaje con identificador <em>idm</em> codificado por el metodo de permutacion utilizando la rejilla <em>idr</em>. Si el ultimo bloque del mensaje no se llena, se completa con caracteres blancos (' ') antes de codificarlo.
    */
    void codificar_guardado_rejilla(string idm, int idr, Cjt_mensajes& cm);
    
    
    /** @brief Lee y decodifica un mensaje mediante la rejilla con identificador <em>idr</em>.
     
        \pre Existe la rejilla con identificador <em>idr</em> y la longitud del mensaje a decodificar es multiplo del cuadrado de la dimension de la rejilla.
        \post Imprime el mensaje decodificado por el metodo de permutacion utilizando la rejilla <em>idr</em>. Este tendra siempre la misma longitud que el mensaje codificado. No obstate, puede no coincidir con la del original, ya que durante el la codificacion se han podido añadir caracteres blancos al final del mensaje, que han de consevarse al decodificar.
    */
    void decodificar_rejilla(int idr);
    
    
    //Consultoras
    
    /** @brief Comprueba que la rejilla <em>idr</em> se encuentre en el conjunto de rejillas de la plataforma.
      
        \pre <em>cierto</em>.
        \post Devuelve 1 (cierto) si la rejilla <em>idr</em> existe en el conjunto de rejillas de la plataforma. En caso contrario devuelve 0 (falso).
    */
    bool existe(int& idr)const;
    
    
    
     /** @brief Comprueba que la dimension y tamaño introducidos sean consistentes para formar una rejilla valida.
      
        \pre La dimension y tamaño introducidos seran enteros mayores que 1 y 0 respectivamente.
        \post Devuelve 1 (cierto) si la dimension y el tamaño son consistentes para formar una rejilla. En caso contrario devuelve 0 (falso).
    */
    bool consistencia(int dim, int tam)const;
    
    
    
    /** @brief Comprueba que los datos introducidos puedan formar una rejilla valida. 
      
        \pre La dimension y tamaño son consistentes.
        \post Devuelve 1 (cierto) si los datos introducidos pueden formar una rejilla valida. En caso contrario devuelve 0 (falso).
    */
    bool validacion(int dim, int tam, int pos)const;
  

    //Escritura del conjunto de mensajes
    
    /** @brief Se listan las rejillas de la colección por orden creciente de identificador. Indicando para cada rejilla sus huecos originales y los producidos en los tres giros.
     
        \pre <em>cierto</em>.
        \post Se escribe las rejillas de la plataforma por orden creciente de identificador y mostrando sus huecos iniciales y despues de los giros.
    */
    void listar_rejillas();
 
};    
#endif
