#include "MyLabel.h"

//Constructor

MyLabel::MyLabel(QWidget *parent) 
    : QLabel(parent) {
    //Inicicalitazacio d'atributs si cal
}

//Implementacio slots

void MyLabel::truncarLabel(int n) {
    
    //Implementacio de truncarLabel
    QString str = text();
    str.truncate(n);
    setText(str); //heredat de QLabel
}
