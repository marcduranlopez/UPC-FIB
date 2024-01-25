#include "Rejilla.hh"
#include <algorithm>
using namespace std;


Rejilla::Rejilla() {
    idr = ' ';
    dim = ' ';
    tam = ' ';
}


void Rejilla::rellenar_parametros(int i, int dimension, vector < pair<int,int> >& vec_rejilla) {
    idr = i;
    dim = dimension;
    tam = vec_rejilla.size();
    posiciones = vec_rejilla; //Vector de posiciones de la rejilla con identificador idr.
}


typedef vector< vector<int> > Matriz_int;
typedef vector< vector<char> > Matriz_char; 
 
Matriz_int Rejilla::rotar_90(Matriz& mat) {
    int n = mat.size();
    Matriz_int temp(n,vector<int>(n));
    
    int t = 0;
    for(int i = n-1; i >= 0; --i) {
        for(int j = 0; j < n; ++j) {
            temp[t][j] = mat[j][i];
        }
            t++;
    }
    return temp;
}
    

vector< pair<int,int> > Rejilla::girar_rejilla(vector < pair<int,int> >& pos) {
    Matriz_int mat(dim,vector<int>(dim,0));
    vector < pair<int,int> > new_pos;
    
   for (int i=0; i< pos.size(); ++i) { 
       mat[pos[i].first-1][pos[i].second-1] = 1;
   }
   mat = rotar_90(mat);
   int n = mat.size();
   for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (mat[i][j] == 1) {
                new_pos.push_back(make_pair(i+1,j+1));
            }
        }
    }
    return new_pos;
}
        

void Rejilla::crear_plantilla() { 
    vector < pair<int,int> > aux = posiciones;
    Matriz_int val(dim,vector<int>(dim,0));
    
    for (int i=0; i< 4; ++i) {
        sort(aux.begin(), aux.end());
        Plantilla.push_back(aux);
        aux = girar_rejilla(aux);           //Se gira la rejilla 90º
    
    }
}


void Rejilla::codificar(string& mensaje) {
    int n = mensaje.length();
    int cont = 0;                           //contador de bloques
    int tam_b = dim*dim;                    //tamaño total del bloque
    
    cout << '"';                            //comillas iniciales de la salida del mensaje
    
    while ((cont*tam_b) < n) {              //Comprobacion de si hay que llenar otro bloque o no.
        Matriz_char mensaje_cod(dim,vector<char>(dim,' '));           //Matriz donde se aplica el mensaje con la rejilla implicita.
    
        int b = 0;                           // bloque de caracteres (hasta dim^2)
        for (int i=0; i<4; ++i) {
            for (int j=0; j< tam and (b + (cont*tam_b) != n); ++j) {
                mensaje_cod[Plantilla[i][j].first-1][Plantilla[i][j].second-1] = mensaje[b + (cont*tam_b)];   //Se llena la matriz con el mensaje siguiendo la rejilla.
                ++b;
            }
        }
        for (int i=0; i<dim; ++i) {
            for (int j=0; j<dim; ++j) {
                cout << mensaje_cod[i][j];    //Se saca la matriz con un bloque del mensaje codificado.
            }
        }
        ++cont;
    }
    cout << '"';                            //comillas finales de la salida del mensaje
    cout << endl;
}
   
   
void Rejilla::decodificar(string& mensaje_codificado) {
    int n = mensaje_codificado.length();
    int posicion = 0;
    string mensaje_final;
    
    while (posicion < n) {
        Matriz_char mensaje_cod(dim,vector<char>(dim));
        Matriz_char mensaje_decodificado;
        
        for (int i=0; i<dim; ++i) {         // Se llena toda la matriz con el mensaje codificado.
            for (int j=0; j<dim; ++j) {
                mensaje_cod[i][j] = mensaje_codificado[posicion];
                ++posicion;
            }
        }
        
        for (int i=0; i<4; ++i) {
            for (int j=0; j< tam; ++j) {
                mensaje_final += mensaje_cod[Plantilla[i][j].first-1][Plantilla[i][j].second-1];
                
                }
            }
        }
        cout << '"' << mensaje_final << '"' << endl;    //Se saca la matriz con un bloque del mensaje decodificado.
}
        
        
bool Rejilla::validacion() {
    Matriz_int val(dim,vector<int>(dim,0));
    
    for (int i=0; i<4; ++i) {
        for (int j=0; j< tam; ++j) {
            if ((val[Plantilla[i][j].first-1][Plantilla[i][j].second-1]) != 0) return false;
            else val[Plantilla[i][j].first-1][Plantilla[i][j].second-1] = 1;
        }
    }
    return true;
}


bool Rejilla::mensaje_valido(string& mensaje_valido)const {
    int n = mensaje_valido.length();
    if ( n % (dim*dim) == 0) return true;
    else return false;
}


void Rejilla::escribir()const {
    
    cout << "Rejilla " << idr << ':'<< endl;
    cout << dim << ' ' << tam << endl;
 
    for (int i=0; i< 4; ++i) {
        for (int j=0; j< tam; ++j) {
            if (j == 0) {
                cout << '(' << Plantilla[i][j].first << ',' << Plantilla[i][j].second << ')';
            }
            else 
                cout << ' ' << '(' << Plantilla[i][j].first << ',' << Plantilla[i][j].second << ')';
        }
        cout << endl;
    }
}
     
