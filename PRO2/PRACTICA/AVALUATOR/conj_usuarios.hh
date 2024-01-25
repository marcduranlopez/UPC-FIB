/** @file conj_usuarios.hh
    @brief Especificación de la clase conj_usuarios.
*/

#ifndef _CONJ_USUARIOS_HH_
#define _CONJ_USUARIOS_HH_

#include "conj_sesiones.hh"
#include "conj_cursos.hh"
#include "Usuario.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <map>
using namespace std;

#endif

/** @class conj_usuarios
    @brief Representa un conjunto de usuarios de la plataforma.
    
    Cada usuario tiene un nombre que lo identifica (string). Los usuarios pueden darse de alta y de baja de la plataforma cuando quieran. Al darse de baja, toda la información asociada al usuario es borrada del sistema. Los usuarios también pueden inscribirse en un curso para resolver los problemas de las sesiones que lo forman. 
    
*/

class conj_usuarios 
{
private:
    
    /** @brief Map (string - Usuario) que tiene como parametro clave los identificadores de los usuarios de la plataforma y como parametro asociado la clase Usuario correspondiente. */
    map<string, Usuario> usuarios;
    

public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un conjunto de usuarios.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de conjunto de usuarios vacía.
    */
    conj_usuarios();
    
    
    //Modificadoras
    
    /** @brief Añade los usuarios <em>u</em> introducidos en la entrada del programa a un map <em>usuarios</em> que tiene como parametro clave el string del usuario y como parametro asociado la misma clase Usuario.
     
        \pre La clase <em>conj_usuarios</em> esta inicializada.
        \post Se obtiene el map <em>usuarios</em> con todos los usuarios introducidos en el canal de entrada del programa y sus respectivas clases Usuario. Estan ordenados por orden alfabetico. Queda como parametro implicito del conj_usuarios.
    */
    void leer();

    /** @brief Añade un nuevo usuario con identificador <em>u</em> al conjunto de usuarios.
     
        \pre El usuario <em>u</em> no existe en el conjunto de usuarios.
        \post El parámetro implícito pasa a contener el conjunto de usuarios original más <em>u</em>.
    */
    void alta_usuario(string& u);
    
    
    /** @brief Suprime el usuario con identificador <em>u</em> del conjunto de usuarios.
     
        \pre El usuario <em>u</em> existe en el conjunto de usuarios.
        \post El parámetro implícito pasa a contener el conjunto de usuarios original menos <em>u</em>.
    */
    void baja_usuario(string& u, conj_cursos& cc);
    
    
    /** @brief Inscribe un usuario <em>u</em> en el curso con identificador <em>c</em>.
     
        \pre Existe el usuario <em>u</em> y el curso <em>c</em> y <em>u</em> no esta inscrito en otro curso.
        \post Imprime el número de usuarios inscritos en el curso <em>c</em> después de añadirlo.
    */
    void inscribir_curso(string& u, int& c, conj_cursos& cursos, conj_sesiones& s);
    
    
    /** @brief Se toma nota del resultado <em>r</em> (<em>r</em> = 1 si éxito o <em>r</em> = 0 si fallo) de un nuevo envío del usuario <em>u</em> al problema <em>p</em>.
     
        \pre El usuario <em>u</em> está registrado e inscrito en un curso donde aparece el problema <em>p</em> y que <em>p</em> pertenece al conjunto de problemas a los que <em>u</em> puede enviar una solución por cumplir los prerequisitos.
        \post Se actualizan las estadísticas del usuario <em>u</em> y del problema <em>p</em>. Si r=1, se actualizan los problemas resueltos y enviables del usuario <em>u</em> y se comprueba si se ha completado el curso en el que estaba inscrito. En caso afirmativo, el usuario <em>u</em> deja de estar inscrito en el curso.
    */
    void envio(string& u, string& p, int& r, conj_problemas& cp, conj_sesiones& cs, conj_cursos& cc);
    
    
    //Consultoras
    
     /** @brief Comprueba que el usuario <em>u</em> se encuentre en el conjunto de usuarios de la plataforma.
      
        \pre <em>cierto</em>.
        \post Devuelve 1 (cierto) si el usuario <em>u</em> existe en el conjunto de usuarios de la plataforma. En caso contrario devuelve 0 (falso).
    */
    bool existe(string& u)const;
    
    
      /** @brief Consulta el curso en el que esta inscrito un usuario <em>u</em>.
     
        \pre Existe el usuario <em>u</em> en la plataforma.
        \post Se imprime el identificador del curso o un cero si no esta inscrito en ningún curso.
    */
    int curso_usuario(const string& u);
    
    
    //Escritura conjunto usuarios.
    
    /** @brief Se listan en orden creciente por identificador los problemas solucionados con éxito por el usuario <em>u</em>, ya sea en el curso en que está inscrito actualmente (si lo está en alguno) como los resueltos en cursos anteriores. Además de los identificadores se imprime también el número de envíos realizados por el usuario a cada problema listado (valor mayor o igual a uno).
     
        \pre Existe el usuario <em>u</em> en la plataforma.
        \post Listado con los problemas resueltos del curso donde está inscrito el usuario <em>u</em> y de sus cursos anteriores. Imprime, también, el número de envíos realizados por el usuario <em>u</em> a cada problema.
    */
    void problemas_resueltos(string& u);
    
    
    /** @brief Se listan en orden creciente por identificador los problemas que el usuario no ha solucionado todavía en el curso en el que está inscrito actualmente, pero a los cuales ya puede realizar un envío (porque cumple todos sus prerequisitos, directos e indirectos). Además de los identificadores se imprime también el número de envíos realizados por el usuario a cada problema del listado (valor mayor o igual que cero).
     
        \pre Existe el usuario <em>u</em> en la plataforma y este pertenece a algún curso.
        \post Se imprime una lista con los problemas del curso donde está inscrito <em>u</em> que no ha resuelto todavía y el número de envíos realizados de dichos problemas.
    */
    void problemas_enviables(string& u);
    
    
    //Escritura del conjunto de usuarios
    /** @brief Se escriben los usuarios registrados actualmente en la plataforma, ordenados crecientemente por su nombre y mostrando, para cada usuario, su identificador, cuántos envíos en total ha realizado, cuántos problemas ha resuelto satisfactoriamente, cuántos problemas ha intentado resolver (al menos ha hecho un envío), y el identificador del curso en el que está inscrito o un 0 si no está inscrito en ninguno.
     
        \pre <em>cierto</em>.
        \post Un listado con los usuarios registrados en la plataforma actualmente ordenados por nombre. También se obtiene, para cada usuario, su identificador, sus envíos totales, el número de problemas resueltos y de los que ha intentado resolver y, por último, el identificador el curso donde está inscrito. Si no está inscrito en ninguno se imprime un 0.  
    */
    void listar_usuarios();
    
    
    //Escritura de un usuario.
    
    /** @brief Se escribe para el usuario <em>u</em> su identificador, cuántos envíos en total ha realizado, cuántos problemas ha resuelto satisfactoriamente, cuántos problemas ha intentado resolver (al menos ha hecho un envío), y el identificador del curso en el que está inscrito o un 0 si no está inscrito en ninguno.
     
        \pre Existe el usuario <em>u</em> en la plataforma.
        \post Imprime para el usuario <em>u</em>, su identificador, sus envíos totales realizados, los problemas resueltos y los que ha intentado resolver y, por último, el identificador el curso donde está inscrito. Si no está inscrito en ninguno se imprime un 0.  
    */
    void escribir_usuario(string& u);
    
    
};
#endif
