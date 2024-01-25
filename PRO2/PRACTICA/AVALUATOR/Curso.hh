/** @file Curso.hh
    @brief Especificación de la clase Curso.
*/

#ifndef _CURSO_HH_
#define _CURSO_HH_

#include "conj_problemas.hh"
#include "conj_sesiones.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <vector>
#include <map>
using namespace std;

#endif

/** @class Curso
    @brief Representa un curso de la plataforma.
    
    Es representado por un entero entre 1 y <em>N</em>. Algunas de las características de cada curso son, por ejemplo, el número de usuarios actuales o pasados que lo han completado, el número de usuarios inscritos actualmente, el número de sesiones que lo forman y los identificadores de dichas sesiones.
    
*/

class Curso 
{
private:
    
    /** @brief identificador del curso.  */
    int curso;
    
    /** @brief Número de usuarios actuales o pasados que han completado el curso.  */
    int num_completados;
    
    /** @brief Número de usuarios inscritos actualmente al curso. */
    int num_inscritos;
    
    /** @brief Número de sesiones del curso. */
    int num_sesiones;
    
    /** @brief Vector que contiene los identificadores de las sesiones del curso */
    vector<string> identif_sesiones;
    
    /** @brief  Marca los identificadores de las sesiones a los que pertenecen cada problema del curso. */
    map<string, string> map_ses_prob;
    
    
public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un curso.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de un curso vacía.
    */
    Curso();
    
    
    //Modificadoras    
    
    /** @brief Aumenta en uno el numero de usuarios inscritos al curso definido en el parámetro implícito.
        
        \pre <em>Cierto</em>.
        \post El numero de usuarios inscritos al curso definido en el parámetro implícito son los inscritos previamente mas uno.
    */
    int incrementar_usuario();
    
    
    /** @brief Disminuye en uno el numero de usuarios inscritos al curso definido en el parámetro implícito.
        
        \pre <em>Cierto</em>.
        \post El numero de usuarios inscritos al curso definido en el parámetro implícito son los inscritos previamente menos uno.
    */
    void decrementar_usuario();

    
    /** @brief Define el identificador del curso el cual estamos tratando. Le da el valor provinente del parametro explicito.
        
        \pre <em>Cierto</em>.
        \post Define el identificador del atributo implícito <em>curso</em> = <em>c</em>.
    */
    void identificar_curso(int c);
    
    
    /** @brief Se lee la secuencia de sesiones que pertenecen al curso definido en el parámetro implícito.
        
        \pre Las sesiones introducidas existen en el conjunto de sesiones de la plataforma.
        \post El curso definido en el parámetro implícito pasa a contener los identificadores de las sesiones leidas por el canal de entrada.
    */
    void leer_sesiones();
    
    
    /** @brief Aumenta en uno el numero de usuarios que han completado el curso definido en el parámetro implícito.
        
        \pre <em>Cierto</em>.
        \post El numero de usuarios que han completado el curso definido en el parametro implícito son los completados previamente mas uno.
    */
    void suma_cursos_resueltos();
    
    
    //Consultoras
    
    /** @brief Consulta si el problema con identificador <em>p</em> se encuentra en alguna de las sesiones del curso definido en el parámetro implícito.
        
        \pre Existe el problema <em>p</em>.
        \post Devuelve 1 (cierto) si se encuentra <em>p</em> en alguna de las sesiones del curso definido en el parámetro implícito. En caso contario devuelve 0 (falso).
    */
    bool identificar_sesiones_bool(string& p, conj_sesiones& cs)const;
    
    
    /** @brief Busca la sesión del problema con identificador <em>p</em> en el curso definido en el parámetro implícito.
        
        \pre Existe el problema con identificador <em>p</em>.
        \post Devuelve el identificador de la sesión al cual pertenece <em>p</em> en el curso del parámetro implícito.
        \coste Constante
    */
    string identificar_sesiones_string(string& p, conj_sesiones& cs)const;
    
    /** @brief Se consultan los diferentes identificadores de las sesiones que forman el curso <em>c</em>.  
    
        \pre Existe el curso <em>c</em>.
        \post Devuelve un vector de strings con los identificadores de las sesiones del parámetro implícito.
    */
    vector<string> identificar_sesiones_vec()const;

    
    /** @brief Busca las sesiones del curso implicito y compara si se repite algun problema de la coleccion dentro del mismo curso.
      
        \pre El conj_problemas y el conj_sesiones estan inicializados.
        \post Devuelve cierto si algun problema de las sesiones del curso implicito se repite. En caso contario devuelve falso.
    */
    bool rep_problema_curso(conj_sesiones& ses);

    
    //Escritura de la sesiones del curso.
   
     /** @brief Se imprimen todas las sesiones del curso <em>c</em> definido en el parametro implicito.
        
        \pre <em>Cierto</em>.
        \post Se escriben las sesiones pertenecientes al curso implícito en el canal de salida en orden de creación.
    */
    void escribir_sesiones(); 
    
    
    //Escritura de un curso
    
    /** @brief Se escribe para el curso implicito su identificador, el número de usuarios actuales o pasados que lo han completado, el número de usuarios inscritos actualmente, el número de sesiones que lo forman y los identificadores de dichas sesiones, en el mismo orden en el que se leyeron cuando se creó el curso.
        
        \pre <em>Cierto</em>.
        \post Se escriben las características del parámetro implícito anteriormente mencionadas en el canal estándar de salida.  
    */
    void escribir();
    

};
#endif
