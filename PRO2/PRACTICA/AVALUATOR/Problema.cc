#include "Problema.hh"
using namespace std;


Problema::Problema() {
    problema = "";
    env_totales_problem = 0;
    env_exito_problem = 0;
}


Problema::Problema(string prob) {
    problema = prob;
    env_totales_problem = 0;
    env_exito_problem = 0;
}


void Problema::suma_envio() {
    ++env_totales_problem;
}


void Problema::suma_envio_exito() {
    ++env_exito_problem;
}


double Problema::ratio_p()const {
    return (double(env_totales_problem + 1)/ double(env_exito_problem + 1)); //ratio = ((t + 1)/(e + 1))
    
}


bool Problema::operator<(const Problema& a)const {
    double ratio1 = ratio_p();
    double ratio2 = a.ratio_p();
    if (ratio1 == ratio2) return problema < a.problema;
    return ratio1 < ratio2;
}


void Problema::escribir()const {
    
    cout << problema << "(" << env_totales_problem << "," << env_exito_problem << "," << ratio_p() << ")" << endl;
}
