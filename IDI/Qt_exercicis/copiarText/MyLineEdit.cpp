#include "MyLineEdit.h"

//Constructor

MyLineEdit::MyLineEdit(QWidget *parent) 
    : QLineEdit(parent) {
    connect (this, SIGNAL(returnPressed()),this,SLOT(tractaReturn()));
    
    //Inicicalitazacio d'atributs si cal
    
}

//Implementacio slots

void MyLineEdit::tractaReturn() {

    //Implementacio de tractaReturn
    emit returnPressed(text());
}
