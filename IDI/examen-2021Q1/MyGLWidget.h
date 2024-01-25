#include "ExamGLWidget.h"

class MyGLWidget:public ExamGLWidget
{
  Q_OBJECT

  public:
    MyGLWidget(QWidget *parent=0) : ExamGLWidget(parent) {}
    ~MyGLWidget();
    
  protected:
    virtual void paintGL ();
    virtual void initializeGL ( );
    virtual void keyPressEvent(QKeyEvent* event);
    
    virtual void modelTransformCub1 (float escala, float angle);
    void modelTransformCub2 (float escala, float angle);
    void modelTransformCub3 (float escala, float angle);
    
    virtual void calculaCapsaModel (Model &p, float &escala, glm::vec3 &centreBase);
    
    virtual void modelTransformPatricio ();
    virtual void projectTransform ();
    virtual void viewTransform ();
    
    float posPat;
    bool cubs; // true es veuen els cubs fals es veu el patricio.
    float rot;
    bool groc;
    
public slots:
    void setCamPlanta();
    void setCamPerspectiva();
    
    void patricioCub1();
    void patricioCub2();
    void patricioCub3();

  private:
    int printOglError(const char file[], int line, const char func[]);
};
