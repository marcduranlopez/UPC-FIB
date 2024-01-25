/** @file Mensaje.hh
    @brief Especificación de la clase Mensaje.
*/

#ifndef _MENSAJE_HH_
#define _MENSAJE_HH_

#ifndef NO_DIAGRAM
#include <iostream>
using namespace std;

#endif

/** @class Mensaje
    @brief Representa un mensaje de la plataforma.
    
    El mensaje se representa con un identificador <em>idm</em>. 
    
*/

class Mensaje 
{
private:
    
    /** @brief Identificador del mensaje.  */
    string idm;
    
    /** @brief Mensaje a codificar/decodificar. */
    string mensaje;
    
    
public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un Mensaje.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de un mensaje vacío.
    */
    
    Mensaje();
    
    
    /** @brief Creadora por nombre.
     
        Se ejecuta automáticamente al declarar un Mensaje.
        \pre <em>cierto</em>.
        \post El resultado es una estructura con el identificador <em>idm</em>.
    */
    
    Mensaje(string idm);
    
    
    //Modificadoras
    
    /** @brief Añade los parametros como el identificador <em>idm</em> y su mensaje correpondiente.
     
        \pre La clase <em>Mensaje</em> está inicializado.
        \post Se obtiene el mensaje con los siguientes parametros ya inicializados: identificador <em>idm</em> y mensaje de dicho identificador.
    */
    void rellenar_parametros(string idm, string mensaje);
    
    
    //Consultoras
    
    /** @brief Devuelve el mensaje.
      
        \pre <em>cierto</em>.
        \post Devuelve el mensaje implicito. 
    */
    string obtener_mensaje();
    
    
    //Escritura de un mensaje.
    
    /** @brief Escribe el identificador del mensaje y el mensaje de dicho identificador.
     
        \pre <em>cierto</em>.
        \post Se imprime el string identificador del mensaje, y el mensaje de dicho identificador.
    */
    void escribir()const;

    
};
#endif
