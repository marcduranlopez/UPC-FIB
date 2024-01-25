#include <QLabel>

class MyLabel : public QLabel
{
  Q_OBJECT

  public:
    MyLabel (QWidget *parent);
    
    double notaFinal;
    double notaP, notaL, notaF;
    void calculNotaFinal();
    
    bool state1, state2, state3, state4;
    double notaExtra = 0;
    
    void colorNota();
    void entreguesLab();
    
  public slots:
    void notaParcial(int p);
    void notaLaboratori(int l);
    void notaExamenFinal(int exFinal);
    
    void checkbox1(int state);
    void checkbox2(int state);
    void checkbox3(int state);
    void checkbox4(int state);
  
    void reset();
};
