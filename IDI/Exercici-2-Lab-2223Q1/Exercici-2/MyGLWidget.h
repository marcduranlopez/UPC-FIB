#include "LL2GLWidget.h"

#include "model.h"

class MyGLWidget : public LL2GLWidget {
  Q_OBJECT

  public:
    MyGLWidget(QWidget *parent=0) : LL2GLWidget(parent) {}
    ~MyGLWidget();

  protected:
      virtual void initializeGL();
      
      virtual void keyPressEvent (QKeyEvent *event);
      virtual void mouseMoveEvent (QMouseEvent *event);
      
      virtual void iniCamera (); 
      
      virtual void RickTransform();
      virtual void MortyTransform();
      virtual void PortalTransform();
      
      virtual void viewTransform ();
      
      virtual void calculaCapsaModel (Model &p, float &escala, float alcadaDesitjada, glm::vec3 &CentreBase);
      
      float distancia, FOVini;
      float escalax, escalaPortal;
      float rotateRick, rotatePortal;

  private:

    int printOglError(const char file[], int line, const char func[]);
    
};
