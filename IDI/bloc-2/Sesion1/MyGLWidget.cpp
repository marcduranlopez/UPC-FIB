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

void MyGLWidget::initializeGL () {
    BL2GLWidget::initializeGL();
    glEnable(GL_DEPTH_TEST); // NOMES UN COP! En paintGL() molt incorrecte
    ini_camera();
    
    rotate = 0.0f;
    escala = 1.0f;

}

void MyGLWidget::paintGL () 
{
    //glViewport (0, 0, width(), height()); // No caldria perquè Qt la fa de forma automàtica amb aquests paràmetres
    
    // Esborrem el frame-buffer
    glClear (GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    // Carreguem la transformació de model
    modelTransformHomer ();
  
    glBindVertexArray(VAO_HomerProves);
    glDrawArrays(GL_TRIANGLES, 0, HomerProves.faces().size()*3);

    modelTransformTerra (); // Carreguem la transformació de model
  
    glBindVertexArray(VAO_Terra);
    glDrawArrays(GL_TRIANGLES, 0, 6);
    glBindVertexArray (0);
}

void MyGLWidget::keyPressEvent(QKeyEvent* event) 
{
    makeCurrent();
    switch (event->key()) {
        case Qt::Key_S: { // escalar a més gran
            escala += 0.05;
            break;
        }
        case Qt::Key_D: { // escalar a més petit
            escala -= 0.05;
            break;
        }
        case Qt::Key_R: {
            rotate += float(M_PI)/4.0f;
            break;
        }
        default: event->ignore(); break;
    }
  update();
}

void MyGLWidget::ini_camera ()
{
    FOV = float(M_PI)/2.0f;
    raw = 1.0f;
    Znear = 0.4f;
    Zfar = 3.0f;
    projectTransform();
    
    OBS = glm::vec3(0,0,1);
    VRP = glm::vec3(0,0,0);
    UP = glm::vec3(0,1,0);
    viewTransform ();
}

void MyGLWidget::modelTransformHomer () 
{
  // Matriu de transformació de model
  glm::mat4 transform (1.0f);
  transform = glm::rotate(transform, rotate, glm::vec3(0.0, 1.0, 0.0));
  transform = glm::scale(transform, glm::vec3(escala));
  glUniformMatrix4fv(transLoc, 1, GL_FALSE, &transform[0][0]);
}

void MyGLWidget::modelTransformTerra () 
{
  // Matriu de transformació de model
  glm::mat4 transform (1.0f);
  transform = glm::scale(transform, glm::vec3(escala));
  glUniformMatrix4fv(transLoc, 1, GL_FALSE, &transform[0][0]);
}

void MyGLWidget::projectTransform ()
{
    glm::mat4 Proj = glm::perspective (FOV, raw, Znear, Zfar);
    glUniformMatrix4fv(projLoc, 1, GL_FALSE, &Proj[0][0]);

}

void MyGLWidget::viewTransform ()
{
    glm::mat4 View = glm::lookAt (OBS, VRP, UP);
    glUniformMatrix4fv(viewLoc, 1, GL_FALSE, &View[0][0]);

}

void MyGLWidget::creaBuffers () 
{
    // HomerProves
    HomerProves.load("../../models/HomerProves.obj");
    
    // Creació del Vertex Array Object per pintar
    glGenVertexArrays(1, &VAO_HomerProves);
    glBindVertexArray(VAO_HomerProves);
    
    GLuint VBO_HomerProvesPos;
    glGenBuffers(1, &VBO_HomerProvesPos);
    glBindBuffer(GL_ARRAY_BUFFER, VBO_HomerProvesPos);
    glBufferData(GL_ARRAY_BUFFER, sizeof(GLfloat)*HomerProves.faces().size()*3*3, HomerProves.VBO_vertices(), GL_STATIC_DRAW);
    glVertexAttribPointer(vertexLoc, 3, GL_FLOAT, GL_FALSE, 0, 0);
    glEnableVertexAttribArray(vertexLoc);
  
    GLuint VBO_HomerProvesCol;
    glGenBuffers(1, &VBO_HomerProvesCol);
    glBindBuffer(GL_ARRAY_BUFFER, VBO_HomerProvesCol);
    glBufferData(GL_ARRAY_BUFFER,sizeof(GLfloat)*HomerProves.faces().size()*3*3, HomerProves.VBO_matdiff(), GL_STATIC_DRAW);

    // Activem l'atribut colorLoc
    glVertexAttribPointer(colorLoc, 3, GL_FLOAT, GL_FALSE, 0, 0);
    glEnableVertexAttribArray(colorLoc);

    glBindVertexArray (0);
    
    
    
    //Terra
    glm::vec3 posicio[6] = {
	glm::vec3(1.0, -1.0, 1.0),
	glm::vec3(1.0, -1.0, -1.0),
	glm::vec3(-1.0, -1.0, -1.0),
	
	glm::vec3(1.0, -1.0, 1.0),
	glm::vec3(-1.0, -1.0, -1.0),
	glm::vec3(-1.0, -1.0, 1.0)
  }; 
   
    glm::vec3 color[6] = {
	glm::vec3(1,0,0),
	glm::vec3(0,0,1),
	glm::vec3(0,1,0),
	
	glm::vec3(1,0,0),
	glm::vec3(0,1,0),
	glm::vec3(0,0,1),
  };
  
  glGenVertexArrays(1, &VAO_Terra);
  glBindVertexArray(VAO_Terra);
  
  GLuint VBO_TerraPos;
  glGenBuffers(1, &VBO_TerraPos);
  glBindBuffer(GL_ARRAY_BUFFER, VBO_TerraPos);
  glBufferData(GL_ARRAY_BUFFER, sizeof(posicio), posicio, GL_STATIC_DRAW);
  
  // Activem l'atribut vertexLoc
  glVertexAttribPointer(vertexLoc, 3, GL_FLOAT, GL_FALSE, 0, 0);
  glEnableVertexAttribArray(vertexLoc);
  
  GLuint VBO_TerraCol;
  glGenBuffers(1, &VBO_TerraCol);
  glBindBuffer(GL_ARRAY_BUFFER, VBO_TerraCol);
  glBufferData(GL_ARRAY_BUFFER, sizeof(color), color, GL_STATIC_DRAW);

  // Activem l'atribut colorLoc
  glVertexAttribPointer(colorLoc, 3, GL_FLOAT, GL_FALSE, 0, 0);
  glEnableVertexAttribArray(colorLoc);
  
  
  glBindVertexArray (0);
}

void MyGLWidget::carregaShaders()
{
    BL2GLWidget::carregaShaders();
    projLoc = glGetUniformLocation(program->programId(), "proj");
    viewLoc = glGetUniformLocation(program->programId(), "view");
}



MyGLWidget::~MyGLWidget() {
}


