#include "MyLabel.h"

//Constructor

MyLabel::MyLabel(QWidget *parent) 
    : QLabel(parent) {
    //Inicicalitazacio d'atributs si cal
}

//Implementacio slots

void MyLabel::notaParcial(int p) {
    notaP = (p*0.25);
    calculNotaFinal();
}
    
void MyLabel::notaLaboratori(int l) {
    notaL = (l+notaExtra)*0.25;
    if (notaL > 10*0.25) notaL = 10*0.25;
    calculNotaFinal();
}

void MyLabel::notaExamenFinal(int exFinal) {
    notaF = (exFinal*0.5);
    calculNotaFinal();
}

void MyLabel::calculNotaFinal() {
    notaFinal = (notaP+notaL+notaF);
    setNum(notaFinal);
    colorNota();
}

void MyLabel::colorNota() {
    
    if(notaFinal < 5) setStyleSheet("color: red;");
    else if(notaFinal > 5) setStyleSheet("color: green;");
    
}

void MyLabel:: entreguesLab() {
    int entregues = state1 + state2 + state3 + state4;
    notaL = notaL - notaExtra*0.25;
    notaExtra = 0;
    if (notaL >= 4.5*0.25) {
        if (entregues == 1) {
            notaExtra = 0.05;
        }
        if (entregues == 2) {
            notaExtra = 0.22;
        }
        if (entregues == 3) {
            notaExtra = 0.53;
        }
        if (entregues == 4) {
            notaExtra = 1;
        }
        notaLaboratori(notaL*4);
    }
}

void MyLabel::checkbox1(int state) {
    state1 = state;
    entreguesLab();
    
}

void MyLabel::checkbox2(int state) {
    state2 = state;
    entreguesLab();
    
}

void MyLabel::checkbox3(int state) {
    state3 = state;
    entreguesLab();
    
}

void MyLabel::checkbox4(int state) {
    state4 = state;
    entreguesLab();
    
}

void MyLabel::reset() {
    notaParcial(0);
    notaLaboratori(0);
    notaExamenFinal(0);
    
}
