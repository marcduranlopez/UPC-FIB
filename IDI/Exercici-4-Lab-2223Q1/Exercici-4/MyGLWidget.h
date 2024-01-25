// MyGLWidget.h
#include "LL4GLWidget.h"

class MyGLWidget : public LL4GLWidget {
  Q_OBJECT
  public:
    MyGLWidget(QWidget *parent=0) : LL4GLWidget(parent) {}
    ~MyGLWidget();
  protected:
    virtual void initializeGL();
    
    virtual void carregaShaders();
    void iniFocus();
    virtual void modelTransformMorty();
    virtual void modelTransformFantasma();
      
    virtual void mouseMoveEvent(QMouseEvent *e);
    virtual void keyPressEvent(QKeyEvent* event);
    
    GLuint posFocusLoc1, posFocusLoc2, posFocusLoc3, posFocusLoc4;
    GLuint posFocusLocLinterna;
    GLuint colFocusLoc1, colFocusLoc2;
    
    float rotate;
    float fantasmaLuzApagada, movFantasma;
    bool encendreEscena, encendreModel;
    
  private:
    int printOglError(const char file[], int line, const char func[]);
};
