/** @file conj_cursos.hh
    @brief Especificación de la clase conj_cursos.
*/

#ifndef _CONJ_CURSOS_HH_
#define _CONJ_CURSOS_HH_

#include "conj_problemas.hh"
#include "conj_sesiones.hh"
#include "Curso.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <vector>
using namespace std;

#endif

/** @class conj_cursos
    @brief Representa un conjunto de cursos de la plataforma.
    
    Cada curso del conjunto es representado por un entero entre 1 y <em>N</em> que ira seguida del número de sesiones y de una secuencia de identificadores de sesiones, válidos y sin repeticiones.
    
*/

class conj_cursos 
{
private:
    
    /** @brief Vector que contiene las clases Curso de todos los cursos de la plataforma. */
    vector<Curso> cursos;    
    
    
public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un conjunto de cursos.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de conjunto de cursos vacía.
    */
    conj_cursos();
    
    
    //Modificadoras
    
    /** @brief Añade los cursos <em>c</em> introducidos en la entrada del programa a un vector <em>cursos</em> de clases Curso.
     
        \pre La clase <em>conj_cursos</em> esta inicializada.
        \post Se obtiene el vector <em>cursos</em> con todas las clases Curso como parametro implicito del conj_cursos.
    */
    void leer();
    
    
    /** @brief Aumenta en una unidad el numero de usuarios inscritos al curso con identificador <em>c</em>.
        
        \pre Existe el curso con identificador <em>c</em>.
        \post El numero de usuarios inscritos al curso con identificador <em>c</em> son los inscritos previamente mas uno.
    */
    int incrementar_usuario(int& c);
    
    
    /** @brief Disminuye en una unidad el numero de usuarios inscritos al curso con identificador <em>c</em>.
        
        \pre Existe el curso con identificador <em>c</em>.
        \post El numero de usuarios inscritos al curso con identificador <em>c</em> son los inscritos previamente menos uno.
    */
    void decrementar_usuario(int& c);

    
    /** @brief Añade un nuevo curso con identificador <em>N</em> + 1 al conjunto de cursos. (<em>N</em> es el numero actual de cursos).
     
        \pre  No hay intersección de problemas entre las sesiones.
        \post Se añade el curso <em>N</em> + 1 al parámetro implícito y se imprime su identificador.
    */
    void nuevo_curso(conj_sesiones& cs);
    
    
    /** @brief Aumenta en uno el numero de usuarios que han completado el curso con identificador <em>c</em>.
        
        \pre Existe <em>c</em>.
        \post El numero de usuarios que han completado el curso con identificador <em>c</em> son los completados previamente mas uno.
    */
    void suma_cursos_resueltos(int& c);
    
    
    /** @brief Actualiza el map de los problemas enviables al curso <em>c</em> despues de hacer el envio del problema con identificador <em>p</em>.
        
        \pre Existe el curso <em>c</em> y el problema <em>p</em>.
        \post Se actualiza el map de problemas enviables con los problemas que cumplen todos los prerrequisitos para ser enviados.
    */    
    void actualiza_problem_enviables(int& c, conj_sesiones& cs, string& p, map<string,Problema>& problem_enviables, map<string,Problema>& problem_resueltos);
    
    
    //Consultoras
    
     /** @brief Comprueba que el curso <em>c</em> se encuentre en el conjunto de cursos de la plataforma.
      
        \pre <em>cierto</em>.
        \post Devuelve 1 (cierto) si el curso <em>c</em> existe en el conjunto de cursos de la plataforma. En caso contrario, devuelve 0 (falso).
    */
    bool existe(int& c)const;
    
    
     /** @brief Consulta la sesión del problema <em>p</em> en el curso con identificador <em>c</em>.
    
        \pre El curso <em>c</em> y el problema <em>p</em> existen. El problema <em>p</em> pertenece al curso <em>c</em>.
        \post Se imprime el identificador de la sesión donde se realiza el problema <em>p</em> en el curso <em>c</em>.
    */
    string sesion_problema(int& c, string& p, conj_sesiones& cs);

    
    /** @brief Comprueba que el problema <em>p</em> se encuentre en el curso <em>c</em>.
     
        \pre Existe el problema <em>p</em> y el curso <em>c</em>.
        \post Imprime 1 (cierto) si el problema <em>p</em> existe en el curso <em>c</em>. En caso contrario, imprime 0 (falso).
    */
    bool pertenece(int& c, string& p, conj_sesiones& sesiones);
    
    
    /** @brief Busca la clase Curso con identificador <em>c</em> del conjunto de cursos existente.
        
        \pre Existe el curso <em>c</em>.
        \post Se devuelve la clase Curso que corresponde al curso con identificador <em>c</em>.
    */
    Curso buscar_curso(int& c)const;
     
    
    //Escritura del conjunto de cursos.
    
    /** @brief Se escriben los cursos actuales de la plataforma, ordenados crecientemente por su identificador y mostrando, para cada curso, su identificador, el número de usuarios actuales o pasados que lo han completado, el número de usuarios inscritos actualmente, el número de sesiones que lo forman y los identificadores de dichas sesiones, en el mismo orden en el que se leyeron cuando se creó el curso.
     
        \pre <em>cierto</em>.
        \post Se imprime por el canal estandar de salida los cursos actuales de la plataforma, ordenados y mostrando, para cada curso, su identificador, el número de usuarios actuales y pasados que lo han completado. También, el número de usuarios inscritos actualmente y, por último, el número de sesiones y sus identificadores en orden de creación.
    */
    void listar_cursos();
    
    
    //Escritura de un curso
    
    /** @brief Se escribe para el curso <em>c</em> su identificador, el número de usuarios actuales o pasados que lo han completado, el nombre el número de usuarios inscritos actualmente, el número de sesiones que lo forman y los identificadores de dichas sesiones, en el mismo orden en el que se leyeron cuando se creó el curso.
     
        \pre Existe el curso <em>c</em> en la plataforma.
        \post Se imprime por el canal estandar de salida el identificador <em>c</em>, el número de usuarios pasados y actuales que han completado el curso <em>c</em>. También se imprime el número de sesiones que lo forman y los identificadores de dichas sesiones en orden de creación.
    */
    void escribir_curso(int& c);
    
    
};
#endif
     
     
     
