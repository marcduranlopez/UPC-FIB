// MyGLWidget.h
#include "BL3GLWidget.h"

class MyGLWidget : public BL3GLWidget {
  Q_OBJECT

  public:
    MyGLWidget(QWidget *parent=0) : BL3GLWidget(parent) {}
    ~MyGLWidget();

  protected:
    virtual void mouseMoveEvent(QMouseEvent *e);
    virtual void keyPressEvent(QKeyEvent* event);
    
    virtual void initializeGL ( );
    virtual void paintGL ( );
    virtual void carregaShaders ();
    
    virtual void modelTransformPatricio ();
    virtual void calculaCapsaModel();
    
    GLuint posFocusLoc1, posFocusLoc2, colFocusLoc1, colFocusLoc2;
    GLuint FocusCamLoc;
    
    glm::vec3 mourePatr;
    
    float posFocusX, posFocusZ;
    
    int focusCam;
    bool BackFaceCul, encendre1, encendre2;

  private:
    int printOglError(const char file[], int line, const char func[]);
};

