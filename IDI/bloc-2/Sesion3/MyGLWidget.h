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
    // resizeGL - És cridat quan canvia la mida del widget
    virtual void resizeGL (int width, int height);
    virtual void keyPressEvent (QKeyEvent *event);
    
    virtual void mouseMoveEvent (QMouseEvent *e);


    virtual void carregaShaders();
    virtual void creaBuffers ();
    
    
    void modelTransformPatricio1 ();
    void modelTransformPatricio2 ();
    void modelTransformPatricio3 ();
    void modelTransformTerra ();
    
    void projectTransform();
    void viewTransform ();
    void ini_camera();
    
    void calculaCapsaModel ();
    void calculaCapsaEscena ();
    
    void calculCentreEscnea ();
    void calculRadiEscena ();

    //uniform project matrix
    GLuint projLoc, viewLoc, VAO_Patricio, VAO_Terra;
    
    // Internal vars
    float escala, rotate, FOV, FOVini, FOVmin, FOVmax, raw, Znear, Zfar;
    float radi, distancia, scale, girTheta, girPsi, x_ant, y_ant;
    
    
    glm::vec3 OBS, VRP, UP, centreEscena;
    glm::vec3 escenaMinima, escenaMaxima, centreBasePatricio;
    
   Model Patricio;

  private:
    int printOglError(const char file[], int line, const char func[]);
    
};
