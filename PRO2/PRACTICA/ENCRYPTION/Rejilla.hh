/** @file Rejilla.hh
    @brief Especificación de la clase Rejilla.
*/

#ifndef _REJILLA_HH_
#define _REJILLA_HH_

#ifndef NO_DIAGRAM
#include <iostream>
#include <vector>
using namespace std;

#endif

/** @class Rejilla
    @brief Representa una rejilla de la plataforma.
    
    La rejilla se representa con un identificador <em>idr</em>. 
    
*/

typedef vector< vector<int> > Matriz;

class Rejilla 
{
private:
    
    /** @brief Identificador de la rejilla.  */
    int idr;
    
    /** @brief Dimension de la rejilla. */
    int dim;
    
    /** @brief Tamaño de la rejilla. */
    int tam;
    
     /** @brief Vector con las posiciones de la rejilla. */
    vector < pair<int,int> > posiciones;
    
    /** @brief Matriz que cumple como una plantilla de codificacion de un mensaje. */
    vector < vector<pair<int,int>> > Plantilla;
    
    
public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar una Rejilla.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de una rejilla vacía.
    */
    
    Rejilla();
    
    
    /** @brief Creadora por nombre.
     
        Se ejecuta automáticamente al declarar una Rejilla.
        \pre <em>cierto</em>.
        \post El resultado es una estructura con el identificador <em>idr</em> de la rejilla su dimension y el vector con los pares de posiciones.
    */
    
 //   Rejilla(int idr, int dim, vec<int> vec_rejilla);
    
    
    //Modificadoras
    
     /** @brief Añade los parametros como el identificador <em>idr</em> de la rejilla, su dimension y el vector de posiciones de esta.
     
        \pre La clase <em>Rejilla</em> está inicializada.
        \post Se obtiene la rejilla con los siguientes parametros ya inicializados: identificador <em>idr</em>, dimension y posiciones.
    */
    void rellenar_parametros(int i, int dimension, vector < pair<int,int> >& vec_rejilla);
    
    
    /** @brief Rota 90 grados la matriz pasada por parametro explicito. 
     
        \pre Obtienes una matriz valida como parametro explicito..
        \post Se gira 90 grados la matriz hacia la izquierda. 
    */
     Matriz rotar_90(Matriz& mat);
    
    
    /** @brief Gira la rejilla 90 grados con tal de obtener los nuevos huecos para formar la plantilla de codificacion.. 
     
        \pre <em>cierto</em>.
        \post Se obtiene la rejilla rotada 90 grados hacia la izquierda con los nuevos huecos para completar la plantilla de codificacion. 
    */
     vector< pair<int,int> > girar_rejilla(vector < pair<int,int> >& pos);
    
    
    /** @brief Plantilla de codificacion formada por las posiciones que debera ocupar los caracteres del mensaje en el estado inicial de la rejilla y cada vez que esta gire 90 grados. 
     
        \pre <em>cierto</em>.
        \post Se obtiene la plantilla de codificacion para los mensajes que se introduzcan. 
    */
    void crear_plantilla();
    
    
    /** @brief Codifica el mensaje que tiene como parametro.
     
        \pre <em>cierto</em>.
        \post Imprime el mensaje que tiene como parametro explicito codificado por el metodo de permutacion utilizando la rejilla implicita. Si el ultimo bloque del mensaje no se llena, se completa con caracteres blancos (' ') antes de codificarlo.
    */
    void codificar(string& mensaje);
    
    
    /** @brief Decodifica el mensaje que tiene como parametro.
     
        \pre <em>cierto</em>.
        \post Imprime el mensaje que tiene como parametro explicito decodificado por el metodo de permutacion utilizando la rejilla implicita. Este tendra siempre la misma longitud que el mensaje codificado. No obstate, puede no coincidir con la del original, ya que durante el la codificacion se han podido añadir caracteres blancos al final del mensaje, que han de consevarse al decodificar.
    */
    void decodificar(string& mensaje_codificado);
    
    
    //Consultoras
    
    /** @brief Consulta si la rejilla es valida.
        
        \pre La rejilla ha sido inicializada.
        \post Devuelve 1 (cierto) si la rejilla es valida. En caso contario devuelve 0 (falso).
    */
    bool validacion();
    
    /** @brief Consulta si el mensaje codificado pasado por parametro explicito es valido.
        
        \pre Se obtiene un mensaje codificado por parametro explicito.
        \post Devuelve 1 (cierto) si el mensaje es valido. En caso contario devuelve 0 (falso).
    */
    bool mensaje_valido(string& mensaje_codificado)const;
   
    
    
    //Escritura de un mensaje.
    
    /** @brief Escribe por cada fila los huecos correspondientes a cada giro de la rejilla.
     
        \pre <em>cierto</em>.
        \post Se imprimen 4 filas, cada una de ellas correspondientes a un giro de la rejilla, y cada fila muestra sus huecos.
    */
    void escribir()const;
    
    
    
};
#endif
