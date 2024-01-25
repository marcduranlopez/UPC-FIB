/** @file Problema.hh
    @brief Especificación de la clase Problema.
*/

#ifndef _PROBLEMA_HH_
#define _PROBLEMA_HH_

#ifndef NO_DIAGRAM
#include <iostream>
using namespace std;

#endif

/** @class Problema
    @brief Representa un problema de la plataforma.
    
    El problema se representa con un identificador. Algunas de las características de cada problema son, por ejemplo, el número <em>t</em> de envíos totales y el número <em>e</em> de envíos con éxito.
    
*/

class Problema 
{
private:
    
    /** @brief identificador del problema.  */
    string problema;
    
    /** @brief Número <em>t</em> de envíos totales del problema. */
    int env_totales_problem;
    
    /** @brief Número <em>e</em> de envíos con exito del problema. */
    int env_exito_problem;
    
    
public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un Problema.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de un problema vacío.
    */
    
    Problema();
    
    
    /** @brief Creadora por nombre.
     
        Se ejecuta automáticamente al declarar un Problema.
        \pre <em>cierto</em>.
        \post El resultado es una estructura con el problema p.
    */
    
    Problema(string p);
    
    
    //Modificadoras
    
    /** @brief Incrementa en una unidad el numero de envíos totales del problema <em>p</em> que viene implícito.
     
        \pre <em>cierto</em>.
        \post Se ha sumado en uno el numero de envíos totales del problema <em>p</em> que viene como parámetro implícito.
    */
    void suma_envio();
    
    
    /** @brief Incrementa en una unidad el numero de envíos con exito del problema <em>p</em> que viene implícito.
     
        \pre <em>cierto</em>.
        \post Se ha sumado en uno el numero de envíos con exito del problema <em>p</em> que viene como parámetro implícito.
    */
    void suma_envio_exito();
    
    
    //Consultoras
    
    /** @brief Devuelve el ratio del problema.
     
        \pre Existe el problema implícito.
        \post Devuelve un double con el ratio del problema implcito ((t + 1)/(e + 1)). 
    */
    double ratio_p()const;
    
    
    /** @brief Da las pautas de orden para los problemas.
     
        \pre La clase Problema esta inicializada.
        \post Define un orden para los problemas. Ordenados primero por ratio de forma creciente y luego por identificador. 
    */
    bool operator<(const Problema& a)const;
    
    
    //Escritura de un problema.
    
    /** @brief Escribe el string del problema implícito, el número <em>t</em> de envíos totales y el número <em>e</em> de envíos con éxito del problema implícito y, por ultimo, también se muestra su ratio ((t + 1)/(e + 1)).
     
        \pre <em>cierto</em>.
        \post Se imprime string del problema implícito, el número <em>t</em> de envíos totales y el número <em>e</em> de envíos con éxito del problema implícito y, por ultimo, también se muestra su ratio ((t + 1)/(e + 1)).
    */
    void escribir()const;


};
#endif
