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
    //virtual void mouseReleaseEvent (QMouseEvent *event);
    virtual void mouseMoveEvent (QMouseEvent *e);


    virtual void carregaShaders();
    virtual void creaBuffers (std::string model_a_pintar);
    
    
    void modelTransform1 ();
    void modelTransform2 ();
    void modelTransform3 ();
    void modelTransformTerra ();
    
    void projectTransform();
    void viewTransform ();
    void ini_camera();
    
    void calculaCapsaModel ();
    void calculaCapsaEscena ();
    
    void calculCentreEscnea ();
    void calculRadiEscena ();

    //uniform project matrix
    GLuint projLoc, viewLoc, VAO, VAO_Terra;
    
    // Internal vars
    float escala, rotate, FOV, FOVini, FOVmin, FOVmax, raw, Znear, Zfar;
    float radi, distancia, scale, girTheta, girPsi, x_ant, y_ant;
    
    
    glm::vec3 OBS, VRP, UP, centreEscena;
    glm::vec3 escenaMinima, escenaMaxima, centreBaseModel;
    
   Model model;

  private:
    int printOglError(const char file[], int line, const char func[]);
    
    // Interacció amb widgets
    int width, height;
    
    // r,g,b terra
    float r,g,b;
    
    std::string model_actual;
    
  public slots:
    void psiAngle (int angle);
    void thetaAngle (int angle);
    void fovAngle (int angle);
    
    void pintaPatricio();
    void pintaLegoman();
    
    void actualitzaR(int value);
    void actualitzaG(int value);
    void actualitzaB(int value);
    
    signals:
    void setPsi(int);
    void setTheta(int);
};
