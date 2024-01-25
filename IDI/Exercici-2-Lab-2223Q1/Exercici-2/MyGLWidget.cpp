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


void MyGLWidget::initializeGL ()
{
  // Cal inicialitzar l'ús de les funcions d'OpenGL
  initializeOpenGLFunctions();  
  glEnable(GL_DEPTH_TEST);
  
  rotateRick = float(M_PI);
  
  glClearColor(0.5, 0.7, 1.0, 1.0); // defineix color de fons (d'esborrat)
  carregaShaders();
  creaBuffersModels();
  creaBuffersTerra();
  
  escalaPortal = escalaModels[PORTAL];
  rotatePortal = float(M_PI);
  
  iniEscena();
  iniCamera();
}


void MyGLWidget::iniCamera()
{
  distancia = radiEscena*2;
  
  //obs = glm::vec3(0, 2, 5);
  //vrp = glm::vec3(0, 1, 0);
  //up = glm::vec3(0, 1, 0);
  
  distancia = radiEscena * 2.0;
  znear = distancia - radiEscena;
  zfar = distancia + radiEscena;
  FOVini = 2.0 * asin(radiEscena / distancia);
  fov = FOVini;
  ra = 1.0f;
  
  factorAngleX = float(M_PI/4);
  factorAngleY = 0.0;
  
  viewTransform();
}


void MyGLWidget::RickTransform ()
{
  glm::mat4 TG(1.0f);  
  TG = glm::translate(TG, glm::vec3(-2.5, 0, 0));
  TG = glm::scale(TG, glm::vec3(escalaModels[RICK]));
  TG = glm::rotate(TG, rotateRick, glm::vec3(0.0, 1.0, 0.0));
  TG = glm::translate(TG, -centreBaseModels[RICK]);
  glUniformMatrix4fv(transLoc, 1, GL_FALSE, &TG[0][0]);
}


void MyGLWidget::MortyTransform ()
{
  glm::mat4 TG(1.0f);
  TG = glm::translate(TG, posMorty);
  TG = glm::scale(TG, glm::vec3(escalaModels[MORTY]));
  TG = glm::rotate(TG, angleMorty, glm::vec3(0.0, 1.0, 0.0));
  TG = glm::translate(TG, -centreBaseModels[MORTY]);
  TGMorty = TG;
  glUniformMatrix4fv(transLoc, 1, GL_FALSE, &TG[0][0]);
}


void MyGLWidget::PortalTransform ()
{
  glm::mat4 TG(1.0f);
  TG = glm::translate(TG, glm::vec3(-2.5,0,0));
  TG = glm::rotate(TG, rotatePortal+float(M_PI), glm::vec3(0.0, 1.0, 0.0));
  TG = glm::scale(TG, glm::vec3(escalaPortal/4,escalaPortal,escalaPortal));
  TG = glm::translate(TG, glm::vec3(0,0,-3.0));
  TG = glm::translate(TG, -centreBaseModels[PORTAL]);
  glUniformMatrix4fv(transLoc, 1, GL_FALSE, &TG[0][0]);
}


void MyGLWidget::viewTransform ()
{
    glm::mat4 View(1.0);
    View = glm::translate(View, glm::vec3(0., 0., -distancia));
    View = glm::rotate(View, factorAngleX, glm::vec3(1., 0., 0.));
    View = glm::rotate(View, factorAngleY, glm::vec3(0., 1., 0.));
    View = glm::translate(View, -centreEscena);
    glUniformMatrix4fv (viewLoc, 1, GL_FALSE, &View[0][0]);

}


void MyGLWidget::keyPressEvent(QKeyEvent* event) 
{
  makeCurrent();
  switch (event->key()) {
    case Qt::Key_Up: { 
    	posMorty +=  glm::vec3(sin(angleMorty),0.0,cos(angleMorty))*glm::vec3(0.1);
        break;
    }
    
    case Qt::Key_Down: {
        posMorty -= glm::vec3(sin(angleMorty),0.0,cos(angleMorty))*glm::vec3(0.1);
        break;
    }
    
    case Qt::Key_Left: { 
    	angleMorty += float(M_PI)/4.0f;    	
        break;
    }
    
    case Qt::Key_Right: {
        angleMorty -= float(M_PI)/4.0f;
        break;
    }
    
    case Qt::Key_Q: { 
    	rotateRick += float(M_PI)/4.0f;
        break;
    }
    
    case Qt::Key_E: { 
    	rotateRick -= float(M_PI)/4.0f;
        break;
    }
    
    case Qt::Key_P: { 
    	if ((escalaPortal != escalaModels[RICK])) {
            escalaPortal = escalaModels[RICK];
            rotatePortal = rotateRick;
        }
        else escalaPortal = 0.0;
        break;
    }
    
    default: event->ignore(); break;
  }
  update();
}


void MyGLWidget::mouseMoveEvent(QMouseEvent *e) {
    makeCurrent();
    
    if (e->buttons() == Qt::LeftButton) {
        if(e->x() > xClick) factorAngleY -= 0.03;
        else if(e->x() < xClick) factorAngleY += 0.03;
    
        if(e->y() > yClick) factorAngleX += 0.03;
        else if(e->y() < yClick) factorAngleX -= 0.03;
    
    
        xClick = e->x();
        yClick = e->y();
        viewTransform();
    }

    update();
}


void MyGLWidget::calculaCapsaModel (Model &p, float &escala, float alcadaDesitjada, glm::vec3 &centreBase)
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
  escala = alcadaDesitjada/(maxy-miny);
  escalax = escala/4;
  centreBase[0] = (minx+maxx)/2.0; centreBase[1] = miny; centreBase[2] = (minz+maxz)/2.0;
    
}


MyGLWidget::~MyGLWidget()
{

}

