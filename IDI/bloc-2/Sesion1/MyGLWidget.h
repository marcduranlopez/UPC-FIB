// MyGLWidget.h
#include "BL2GLWidget.h"
#include "../../Model/model.h"

class MyGLWidget : public BL2GLWidget {
  Q_OBJECT

  public:
    MyGLWidget(QWidget *parent=0) : BL2GLWidget(parent) {}
    ~MyGLWidget();

  protected:

    // initializeGL - Aqui incluim les inicialitzacions del contexte grafic.
    virtual void initializeGL ();
    virtual void paintGL ();
    virtual void keyPressEvent (QKeyEvent *event);


    virtual void carregaShaders();
    virtual void creaBuffers ();
    
    
    void modelTransformHomer ();
    void modelTransformTerra ();
    
    void projectTransform ();
    void viewTransform ();
    void ini_camera();

    //uniform project matrix
    GLuint projLoc, viewLoc, VAO_HomerProves, VAO_Terra;
    
    // Internal vars
    float escala, rotate, FOV, raw, Znear, Zfar;
    glm::vec3 OBS, VRP, UP;
    
    Model HomerProves;

  private:
    int printOglError(const char file[], int line, const char func[]);
    
};
