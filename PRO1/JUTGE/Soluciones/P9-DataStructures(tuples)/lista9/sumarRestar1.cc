#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

struct Temps {
         int hora, minut, segon;
     };


void un_segon(const Temps& t, Temps& t1, Temps& t2) {
    if (t.segon == 59) {
        t1.segon = 0;
        if (t.minut == 59) {
            t1.minut = 0;
            if (t.hora == 23) {
                t1.hora = 0;
            } else t1.hora = t.hora+1;
        } else   {
            t1.minut = t.minut+1;
            t1.hora = t.hora;
        }
    } else   {
        t1.segon = t.segon+1;
        t1.minut = t.minut;
        t1.hora = t.hora;
    }
    cout << t1.hora << " " << t1.minut << " " << t1.segon << endl;


    if (t.segon == 0) {
        t2.segon = 59;
        if (t.minut == 0) {
            t2.minut = 59;
            if (t.hora == 0) {
                t2.hora = 23;
            } else t2.hora = t.hora-1;
        } else   {
            t2.minut = t.minut-1;
            t2.hora = t.hora;
        }
    } else   {
        t2.segon = t.segon-1;
        t2.minut = t.minut;
        t2.hora = t.hora;
    }
    cout << t2.hora << " " << t2.minut << " " << t2.segon << endl;
}
    
int main() {
    Temps t, t1, t2; 
    int hora, minut, segon;
    while (cin >> hora) {
        cin >> minut >> segon;
        t.hora = hora;
        t.minut = minut;
        t.segon = segon;
        
        un_segon (t, t1, t2);
    }
}

