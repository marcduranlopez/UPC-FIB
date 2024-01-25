/** @file Patron.hh
    @brief Especificación de la clase Patron.
*/

#ifndef _PATRON_HH_
#define _PATRON_HH_

#include "BinTree.hh"

#ifndef NO_DIAGRAM
#include <iostream>
#include <vector>
using namespace std;

#endif

/** @class Patron
    @brief Representa un patron de la plataforma.
    
    El patron se representa con un identificador <em>idp</em>. 
    
*/

class Patron 
{
private:
    
    /** @brief Identificador del patron.  */
    int idp;
    
    /** @brief Tamaño de bloque.  */
    int b;
    
    /** @brief Arbol binario correspondiente al patron implicito.  */
    BinTree<int> BT_patron;
    
    /** @brief Arbol binario con el mensaje introducido (ordenado por niveles).  */
    BinTree<char> BT_msj;
    
    /** @brief Arbol binario de enteros, construido a base del patron implicito. */
    BinTree<int> BT_mosaico;
    
    /** @brief Añade en preorden los enteros positivos que forman el patron implicito (con marca -1).
     
        \pre <em>cierto</em>.
        \post Utilizando recursividad se obtiene el arbol binario con los enteros positivos que forman el patron implicito (con marca -1) en preorden. 
    */
    static void leer_patron(BinTree<int>& BT_patron); 
    
    
    /** @brief Añade el mensaje pasado por parametro explicito a un BinTree ordenado por niveles.
     
        \pre Existe el mensaje pasado por parametro y el BinTree <em>BinTree_mensaje</em> esta inicializado.
        \post Utilizando recursividad se obtiene el arbol binario con el mensaje parametro ordenado por niveles. 
    */
    static void llenar_BinTree_mensaje(string& msj, int i, BinTree<char>& BinTree_mensaje);
    
    
    /** @brief Se obtiene un arbol de enteros no negativos, con la misma forma que el arbol que contiene el mensaje, construido a base de replicar el patron implicito total o parcialmente cuantas veces sea necesario.
     
        \pre El BinTree <em>BT_msj</em> esta inicializado con el mensaje seleccionado.
        \post Utilizando recursividad se llena el arbol binario con enteros a base de replicar el patron total o parcialmente. 
    */
    void crear_mosaico(const BinTree<char>& BT_msj, BinTree<int>& BT_mosaico, BinTree<int> BT_ptr_aux);
    
    
    /** @brief Se obtiene un string del tamaño del bloque introducido con el mensaje total o parcialmente codificado/decodificado (depende del mensaje).
     
        \pre El BinTree <em>BT_msj</em> contiene el mensaje codificado/decodificado ordenado por niveles (bfs).
        \post Devuelve un string con el mensaje total o parcialmente codificado/decodificado extraido del BinTree <em>BT_msj</em>. 
    */
    static string llenar_string_bloque(BinTree<char>& BT_msj); 
        
    
    /** @brief Se suman los valores de cada uno de los nodos del BinTree <em>BT_mosaico</em> con su nodo correspondiente del BinTree <em>BT_msj</em> para asi codificar el mensaje segun el patron implicito.
     
        \pre El BinTree <em>BT_msj</em> contiene el mensaje a codificar y el BinTree <em>BT_mosaico</em> contiene los valores del patron a sumar para codificar.
        \post Utilizando recursividad se suman los valores de cada uno de los nodos del BinTree <em>BT_mosaico</em> con su nodo correspondiente del BinTree <em>BT_msj</em> obteniendo de esta manera el mensaje codificado en el BinTree <em>BT_msj</em>. 
    */
    static void sumar_mosaico(BinTree<char>& BT_msj, const BinTree<int>& BT_mosaico);  
    
        
    /** @brief Se restan los valores de cada uno de los nodos del BinTree <em>BT_mosaico</em> con su nodo correspondiente del BinTree <em>BT_msj</em> para asi decodificar el mensaje segun el patron implicito.
     
        \pre El BinTree <em>BT_msj</em> contiene el mensaje a decodificar y el BinTree <em>BT_mosaico</em> contiene los valores del patron a restar para decodificar.
        \post Utilizando recursividad se restan los valores de cada uno de los nodos del BinTree <em>BT_mosaico</em> con su nodo correspondiente del BinTree <em>BT_msj</em> obteniendo de esta manera el mensaje decodificado en el BinTree <em>BT_msj</em>. 
    */
    static void restar_mosaico(BinTree<char>& BT_msj, BinTree<int> BT_mosaico); 
    
    
    
    /** @brief Escribe por el canal estandar de salida los enteros no negativos que forman el patron.
     
        \pre El arbol binario del patron implicito esta inicializado.
        \post Se escribe el identificador del patron implicito y utilizando recursividad se imprimen los enteros no negativos que forman al mismo.
    */
    static void escribir_patron(const BinTree<int>& BT_patron); 
    
public:
    
    //Constructoras
    
    /** @brief Creadora por defecto.
     
        Se ejecuta automáticamente al declarar un Patron.
        \pre <em>cierto</em>.
        \post El resultado es una estructura de un patron vacío.
    */
    
    Patron();
    
    
    //Modificadoras
    
     /** @brief Añade los parametros como el identificador <em>idp</em> del patron y la secuencia que formara el arbol binario con el patron.
     
        \pre La clase <em>Patron</em> está inicializada.
        \post Se obtiene el patron con los siguientes parametros ya inicializados: identificador <em>idp</em> y el arbol binario con el patron correspondiente a la entrada.
    */
    void rellenar_parametros(int& i);
    
    
    /** @brief Codifica el mensaje que tiene como parametro.
     
        \pre <em>cierto</em>.
        \post Imprime el mensaje que tiene como parametro explicito codificado por el metodo de sustitucion utilizando el patron implicito. El mensaje se divide en bloques de tamaño <em>b</em>.
    */
    void codificar(string& mensaje, int& b);
    
    
    /** @brief Decodifica el mensaje que tiene como parametro.
     
        \pre <em>cierto</em>.
        \post Imprime el mensaje que tiene como parametro explicito decodificado por el metodo de sustitucion utilizando la patron implicito. Este tendra siempre la misma longitud que el mensaje codificado. 
    */
    void decodificar(string& mensaje_codificado, int& b);
    
    
    //Escritura de un mensaje.
    
    /** @brief Escribe el identificador del patron implicito y su patron correspondiente.
     
        \pre <em>cierto</em>.
        \post Se imprime el identificador del patron implicito y su patron correspondiente.
    */
    void escribir()const;
    
};
#endif
