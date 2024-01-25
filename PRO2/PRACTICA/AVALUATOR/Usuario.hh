/** @file Usuario.hh
    @brief Especificación de la clase Usuario.
*/

#ifndef _USUARIO_HH_
#define _USUARIO_HH_

#include "Problema.hh"
#include "conj_sesiones.hh"
#include "conj_cursos.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <vector>
#include <map>
using namespace std;

#endif

/** @class Usuario
    @brief Representa un Usuario de la plataforma.
    
    El usuario se representa con un identificador. Algunas de las características de cada usuario son, por ejemplo, cuántos envíos en total ha realizado, cuántos problemas ha resuelto satisfactoriamente, cuántos problemas ha intentado resolver, y el curso donde está inscrito o no.

*/

class Usuario 
{
private:
    
    /** @brief identificador del usuario. */
    string usuario;
    
    /** @brief Número total de envíos que ha realizado el usuario */
    int env_totales_usuario;
    
     /** @brief Identificador del curso en el que esta inscrito el usuario. 0 si no esta inscrito a ningun curso. */
    int curso_inscrito;

    /** @brief Map (string - Problema) que tiene como parametro clave los identificadores de los problemas que ha resuelto el usuario y como parametro asociado la clase Problema correspondiente. */
    map<string, Problema> problem_resueltos;
    
    /** @brief Map (string - Problema) que tiene como parametro clave los identificadores de los problemas enviables para el usuario y como parametro asociado la clase Problema correspondiente. */
    map<string, Problema> problem_enviables;
    
    /** @brief Map (string - int) que tiene como parametro clave los identificadores de los problemas que ha intentado resolver (al menos ha hecho un envío) el usuario y como parametro asociado el contador de envios de cada uno de ellos. */
    map<string, int> intentos_problema_p;
    

public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un usuario.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de un usuario vacía.
    */
    Usuario();
    
    /** @brief Creadora por nombre.
     
        \pre <em>cierto</em>
        \post El resultado es una estructura del usuario. <em>u</em>.
     */
    Usuario(string u);
    
    
    //Modificadoras
   
    /** @brief Inscribe al usuario definido en el parametro implícito en el curso con identificador <em>c</em>.             
            
        \pre El usuario implícito no está inscrito en otro curso que no ha sido completado y existe el curso <em>c</em>.
        \post Se escribe el número de usuarios inscritos al curso <em>c</em> despues de inscribir al usuario implícito a este.
    */
    void inscribir(int& c, conj_cursos& curs, conj_sesiones& s);
    
    
    /** @brief Disminuye en uno el numero de usuarios inscritos al curso al que está inscrito el usuario definido en el parámetro implícito.
        
        \pre El usuario implícito esta inscrito a un curso.
        \post El numero de usuarios inscritos al curso en el que esta inscrito el usuario implícito es los inscritos previamente menos uno.
    */
    void decrementar_inscritos(conj_cursos& cc);

    
    /** @brief Se agrega a un map (string - int) el problema con identificador <em>p</em> si no estaba ya previamente y se contabiliza cuantos envios ha hecho el usuario implicto a ese problema <em>p</em>.
        
        \pre Existe el problema con identificador <em>p</em>.
        \post Se actualiza el map anterior (string - int) con los identificadores de problemas que han sido enviados previamente al menos una vez por el usuario implicito (parametro clave del map) mas el identificador<em>p</em> si no habia sido enviado antes. Tambien se actualiza el parametro asociado del map, se suma uno al contador de envios de ese problema.
    */

    void intentos_problema(string& p);
    
    
    /** @brief Se agrega el problema con identificador <em>p</em> a los problemas resueltos del usuario implícito mediante un map (string - Problema). Como se utiliza un map, estan ordenados por identificador.
        
        \pre Existe el problema con identificador <em>p</em>.
        \post El resultado es el map anterior de problemas resueltos del usuario implicto mas el problema con identificador <em>p</em>. 
    */
    void agregar_problema_resuelto(string& p);
    
    
    /** @brief Se actualizan los parametros del usuario implicito dependiento del resultado del envio <em>r</em> (si es envio con exito <em>r</em> = 1, en caso contrario <em>r</em> = 0 ) de un nuevo envío al problema <em>p</em> del usuario implícito.
        
        \pre El usuario implícito está registrado e inscrito en un curso donde aparece el problema con identificador <em>p</em> y que este pertenece al conjunto de problemas a los que el parámetro implícito puede enviar una solución por cumplir los prerrequisitos.
        \post Se actualiza las estadísticas del parámetro implícito del problema con identificador <em>p</em>. Si <em>r</em> = 1 también tambien se actualizadan los problemas enviables y resueltos del usuario implícito. En el caso de que se haya completado el curso al que pertenece <em>p</em> el usuario implícito deja de estar inscrito en él. 
    */
    void envio_usuario(string& p, int& r, conj_problemas& cp, conj_sesiones& cs, conj_cursos& cc);
    
    
    //Consultoras
    
    /** @brief Se indica el identificador del curso en el que está inscrito el usuario <em>u</em> o un 0 si no está inscrito en ninguno. 
     
        \pre Existe el usuario <em>u</em> en la plataforma.
        \post Se imprime  el identificador del curso en el que está inscrito el usuario <em>u</em> o un 0 si no está inscrito en ninguno. 
    */
    int curso_usuario()const;

    
    //Escritura problemas resueltos.
    
    /** @brief Se escriben los elementos del map problemas resueltos del usuario implicito y para cada uno de ellos se imprime el numero de envios. Como utiliza un map estos estan ordenados por identificador.
     
        \pre <em>Cierto</em>.
        \post Se imprimen los identificadores del map problemas resueltos del usuario implicito y para cada uno de ellos se escribe el numero de envios (buscando en el map intentos_problema_p). 
    */
    void p_resueltos()const;
    
    
    //Escritura problemas enviables.
    
    /** @brief Se escriben los elementos del map problemas enviables del usuario implicito y para cada uno de ellos se imprime el numero de envios. Como utiliza un map estos estan ordenados por identificador.
     
        \pre <em>Cierto</em>.
        \post Se imprimen los identificadores del map problemas enviables del usuario implicito y para cada uno de ellos se escribe el numero de envios (buscando en el map intentos_problema_p). 
    */
    void p_enviables()const;
    
    
    //Escritura de un usuario
    
    /** @brief Se escibe para el usuario implicito, su identificador, cuántos envíos en total ha realizado, cuántos problemas ha resuelto satisfactoriamente, cuántos problemas ha intentado resolver (al menos ha hecho un envío), y el identificador del curso en el que está inscrito o un 0 si no está inscrito en ninguno.
     
        \pre <em>Cierto</em>.
        \post Imprime para el usuario implicito, su identificador, sus envíos totales realizados, los problemas resueltos y los que ha intentado resolver y, por último, el identificador el curso donde está inscrito. Si no está inscrito en ninguno se imprime un 0.  
    */
    void escribir()const;

    
};
#endif
    
    
