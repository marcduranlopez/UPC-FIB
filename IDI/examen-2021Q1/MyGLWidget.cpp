// MyGLWidget.cpp
#include "MyGLWidget.h"
#include <iostream>
#include <stdio.h>

#define printOpenGLError() printOglError(__FILE__, __LINE__)
#define CHECK() printOglError(__FILE__, __LINE__,__FUNCTION__)
#define DEBUG() std::cout << __FILE__ << " " << __LINE__ << " " << __FUNCTION__ << std::endl;

int MyGLWidget::printOglError(const char file[], int line, const char func[]) 
{
    GLenum glErr;
    int    retCode = 0;

    glErr = glGetError();
    const char * error = 0;
    switch (glErr)
    {
        case 0x0500:
            error = "GL_INVALID_ENUM";
            break;
        case 0x501:
            error = "GL_INVALID_VALUE";
            break;
        case 0x502: 
            error = "GL_INVALID_OPERATION";
            break;
        case 0x503:
            error = "GL_STACK_OVERFLOW";
            break;
        case 0x504:
            error = "GL_STACK_UNDERFLOW";
            break;
        case 0x505:
            error = "GL_OUT_OF_MEMORY";
            break;
        default:
            error = "unknown error!";
    }
    if (glErr != GL_NO_ERROR)
    {
        printf("glError in file %s @ line %d: %s function: %s\n",
                             file, line, error, func);
        retCode = 1;
    }
    return retCode;
}

MyGLWidget::~MyGLWidget() {
}

void MyGLWidget::initializeGL ()
{
  // Cal inicialitzar l'ús de les funcions d'OpenGL
  initializeOpenGLFunctions();  

  glClearColor(0.5, 0.7, 1.0, 1.0); // defineix color de fons (d'esborrat)
  glEnable(GL_DEPTH_TEST);
  carregaShaders();
  iniEscena ();
  iniCamera ();
  
  posPat = 0.0;
  cubs = true;
  rot = 0.0;
  groc = false;
}

void MyGLWidget::paintGL ()   // Mètode que has de modificar
{
// En cas de voler canviar els paràmetres del viewport, descomenteu la crida següent i
// useu els paràmetres que considereu (els que hi ha són els de per defecte)
//  glViewport (0, 0, ample, alt);
  
  // Esborrem el frame-buffer i el depth-buffer
  glClear (GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

  // Pintem el terra
  glBindVertexArray (VAO_Terra);
  modelTransformTerra ();
  glDrawArrays(GL_TRIANGLE_STRIP, 0, 4);

  if (not cubs) {
    // Pintem el Patricio
    glBindVertexArray (VAO_Patr);
    modelTransformPatricio ();
    glDrawArrays(GL_TRIANGLES, 0, patr.faces().size()*3);
      
}
else {
    // Pintem el cub
    glBindVertexArray(VAO_Cub);
    modelTransformCub1 (4.0, 0.0);
    glDrawArrays(GL_TRIANGLES, 0, 36);
  
    modelTransformCub2 (5.0, float(2*M_PI/3));
    glDrawArrays(GL_TRIANGLES, 0, 36);
  
    modelTransformCub3 (6.0, float(-2*M_PI/3));
    glDrawArrays(GL_TRIANGLES, 0, 36);
}
  
  glBindVertexArray(0);
}

void MyGLWidget::modelTransformCub1 (float escala, float angle) 
{
  TG = glm::mat4(1.f);
  TG = glm::rotate(TG, angle+rot, glm::vec3 (0, 1, 0));
  TG = glm::translate(TG, glm::vec3 (5, 0, 0));
  TG = glm::scale(TG, glm::vec3 (escala, escala, escala));
  glUniformMatrix4fv (transLoc, 1, GL_FALSE, &TG[0][0]);
}

void MyGLWidget::modelTransformCub2 (float escala, float angle) 
{
  TG = glm::mat4(1.f);
  TG = glm::rotate(TG, angle+rot, glm::vec3 (0, 1, 0));
  TG = glm::translate(TG, glm::vec3 (5, 0, 0));
  TG = glm::scale(TG, glm::vec3 (escala, escala, escala));
  glUniformMatrix4fv (transLoc, 1, GL_FALSE, &TG[0][0]);
}

void MyGLWidget::modelTransformCub3 (float escala, float angle) 
{
  TG = glm::mat4(1.f);
  TG = glm::rotate(TG, angle+rot, glm::vec3 (0, 1, 0));
  TG = glm::translate(TG, glm::vec3 (5, 0, 0));
  TG = glm::scale(TG, glm::vec3 (escala, escala, escala));
  glUniformMatrix4fv (transLoc, 1, GL_FALSE, &TG[0][0]);
}

void MyGLWidget::modelTransformPatricio ()    // Mètode que has de modificar
{
  TG = glm::mat4(1.f);
  TG = glm::rotate(TG, posPat+rot, glm::vec3 (0, 1, 0));
  TG = glm::translate(TG, glm::vec3 (5, 0, 0));
  TG = glm::rotate(TG, float(-M_PI/2), glm::vec3 (1, 0, 0));
  TG = glm::scale(TG, glm::vec3 (2*escala, 2*escala, 2*escala));
  TG = glm::translate(TG, -centreBasePat);
  
  glUniformMatrix4fv (transLoc, 1, GL_FALSE, &TG[0][0]);
}

void MyGLWidget::viewTransform ()    // Mètode que has de modificar
{
  if (!camPlanta)
    ExamGLWidget::viewTransform();
  else
  {
  View = glm::translate(glm::mat4(1.f), glm::vec3(0, 0, -2*radiEsc));
  View = glm::rotate(View, float(M_PI/2), glm::vec3(0, 0, 1));
  View = glm::rotate(View, float(M_PI/2), glm::vec3(1, 0, 0));
  View = glm::translate(View, -centreEsc);

  glUniformMatrix4fv (viewLoc, 1, GL_FALSE, &View[0][0]);
  }
}

void MyGLWidget::projectTransform ()
{
  if (!camPlanta)
    ExamGLWidget::projectTransform();
  else
  {
  glm::mat4 Proj;  // Matriu de projecció
  Proj = glm::ortho(-radiEsc, radiEsc, -radiEsc, radiEsc, zn, zf);

  glUniformMatrix4fv (projLoc, 1, GL_FALSE, &Proj[0][0]);
  }
}

void MyGLWidget::calculaCapsaModel (Model &p, float &escala, glm::vec3 &centreBase)
{
  // Càlcul capsa contenidora i valors transformacions inicials
  float minx, miny, minz, maxx, maxy, maxz;
  minx = maxx = p.vertices()[0];
  miny = maxy = p.vertices()[1];
  minz = maxz = p.vertices()[2];
  for (unsigned int i = 3; i < p.vertices().size(); i+=3)
  {
    if (p.vertices()[i+0] < minx)
      minx = p.vertices()[i+0];
    if (p.vertices()[i+0] > maxx)
      maxx = p.vertices()[i+0];
    if (p.vertices()[i+1] < miny)
      miny = p.vertices()[i+1];
    if (p.vertices()[i+1] > maxy)
      maxy = p.vertices()[i+1];
    if (p.vertices()[i+2] < minz)
      minz = p.vertices()[i+2];
    if (p.vertices()[i+2] > maxz)
      maxz = p.vertices()[i+2];
  }
  escala = 2.0/(maxy-miny);
  centreBase[0] = (minx+maxx)/2.0; centreBase[1] = miny; centreBase[2] = (minz+maxz)/2.0;
}

void MyGLWidget::keyPressEvent(QKeyEvent* event) {
  makeCurrent();
  switch (event->key()) {
  case Qt::Key_V: {
      makeCurrent();
      cubs = !cubs;
      update();
    break;
	}
  case Qt::Key_1: {
      patricioCub1();
    break;
	}
  case Qt::Key_2: {
      patricioCub2();
    break;
	}
  case Qt::Key_3: {
      patricioCub3();
    break;
	}
  case Qt::Key_F: {
      if (groc) {
        colFoc = glm::vec3(1,1,1);
        glUniform3fv (colfocusLoc, 1, &colFoc[0]);
        groc = false;
      }
      else {
        colFoc = glm::vec3(1,1,0);
        glUniform3fv (colfocusLoc, 1, &colFoc[0]);
        groc = true;
    }
    break;
	}
  case Qt::Key_C: {
      camPlanta = !camPlanta;
      if (camPlanta) {
          setCamPlanta();
    }
    else setCamPerspectiva();
    
    break;
	}
  case Qt::Key_Right: {
      makeCurrent();
      rot += float(2*M_PI/3);
      update();
    break;
	}
  case Qt::Key_Left: {
      makeCurrent();
      rot += float(-2*M_PI/3);
      update();
    break;
	}
  case Qt::Key_R: {
      makeCurrent();
      rot = 0.0;
      posPat = 0.0;
      cubs = true;
      
      camPlanta = false;
      viewTransform();
      projectTransform();
      
      colFoc = glm::vec3(1,1,1);
      glUniform3fv (colfocusLoc, 1, &colFoc[0]);
      groc = false;
      
      update();  
    break;
	}
  default: ExamGLWidget::keyPressEvent(event); break;
  }
  update();
}

void MyGLWidget::setCamPlanta() {
    makeCurrent();
    
    camPlanta = true;
    viewTransform();
    projectTransform();
    
    update();
}


void MyGLWidget::setCamPerspectiva() {
    makeCurrent();
    
    camPlanta = false;
    viewTransform();
    projectTransform();
    
    update();
}

void MyGLWidget::patricioCub1() {
    makeCurrent();
    
    posPat = 0.0;
    modelTransformPatricio();
    
    update();
}

void MyGLWidget::patricioCub2() {
    makeCurrent();
    
    posPat = float(2*M_PI/3);
    modelTransformPatricio();
    
    update();
}

void MyGLWidget::patricioCub3() {
    makeCurrent();
    
    posPat = float(-2*M_PI/3);
    modelTransformPatricio();
    
    update();
}
