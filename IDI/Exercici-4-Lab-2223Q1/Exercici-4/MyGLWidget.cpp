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
  glEnable(GL_CULL_FACE);
  
  carregaShaders();
  iniFocus();
  
  rotate = float(M_PI/2.0);
  fantasmaLuzApagada = 0.0;
  movFantasma = 0.0;
  
  creaBuffersMorty();
  creaBuffersFantasma();
  creaBuffersTerraIParets();
  
  iniEscena();
  iniCamera();
  
  encendreEscena = true;
  encendreModel = true;
}


void MyGLWidget::iniFocus()
{

  glm::vec3 posFocus1 = glm::vec3(0, 6, 0);
  glUniform3fv(posFocusLoc1, 1, &posFocus1[0]);
  
  glm::vec3 posFocus2 = glm::vec3(0, 6, 10);
  glUniform3fv(posFocusLoc2, 1, &posFocus2[0]);
  
  glm::vec3 posFocus3 = glm::vec3(10, 6, 0);
  glUniform3fv(posFocusLoc3, 1, &posFocus3[0]);
  
  glm::vec3 posFocus4 = glm::vec3(10, 6, 10);
  glUniform3fv(posFocusLoc4, 1, &posFocus4[0]);
  
  glm::vec3 posFocusLinterna = glm::vec3(5, 0.5, 5);
  glUniform3fv(posFocusLocLinterna, 1, &posFocusLinterna[0]);
  
  
  glm::vec3 colFocus1 = glm::vec3(0.7, 0, 0.7);
  glUniform3fv(colFocusLoc1, 1, &colFocus1[0]);
  
  glm::vec3 colFocus2 = glm::vec3(0.9, 0.9, 0);
  glUniform3fv(colFocusLoc2, 1, &colFocus2[0]);
    
}


void MyGLWidget::modelTransformMorty ()
{
  TG_morty = glm::translate(glm::mat4(1.f), glm::vec3(5,0,5));
  TG_morty = glm::rotate(TG_morty, rotate ,glm::vec3(0.f, 1.f, 0.f));
  TG_morty = glm::scale(TG_morty, glm::vec3(escalaMorty, escalaMorty, escalaMorty));
  TG_morty = glm::translate(TG_morty, -centreBaseMorty);
  
  glUniformMatrix4fv (transLoc, 1, GL_FALSE, &TG_morty[0][0]);
}


void MyGLWidget::modelTransformFantasma ()
{
  glm::mat4 TG;
  TG = glm::translate(glm::mat4(1.f), glm::vec3(1,0.5,5));
  TG = glm::translate(TG, glm::vec3(movFantasma,0,0));
  TG = glm::rotate(TG, float(glm::radians(90.0)),glm::vec3(0.f, 1.f, 0.f));
  TG = glm::scale(TG, glm::vec3(fantasmaLuzApagada, fantasmaLuzApagada, fantasmaLuzApagada));
  TG = glm::translate(TG, -centreBaseFantasma);
  
  glUniformMatrix4fv (transLoc, 1, GL_FALSE, &TG[0][0]);
}


void MyGLWidget::carregaShaders()
{
  // Creem els shaders per al fragment shader i el vertex shader
  QOpenGLShader fs (QOpenGLShader::Fragment, this);
  QOpenGLShader vs (QOpenGLShader::Vertex, this);
  // Carreguem el codi dels fitxers i els compilem
  fs.compileSourceFile("shaders/basicLlumShader.frag");
  vs.compileSourceFile("shaders/basicLlumShader.vert");
  // Creem el program
  program = new QOpenGLShaderProgram(this);
  // Li afegim els shaders corresponents
  program->addShader(&fs);
  program->addShader(&vs);
  // Linkem el program
  program->link();
  // Indiquem que aquest és el program que volem usar
  program->bind();

  // Obtenim identificador per a l'atribut “vertex” del vertex shader
  vertexLoc = glGetAttribLocation (program->programId(), "vertex");
  // Obtenim identificador per a l'atribut “normal” del vertex shader
  normalLoc = glGetAttribLocation (program->programId(), "normal");
  // Obtenim identificador per a l'atribut “matamb” del vertex shader
  matambLoc = glGetAttribLocation (program->programId(), "matamb");
  // Obtenim identificador per a l'atribut “matdiff” del vertex shader
  matdiffLoc = glGetAttribLocation (program->programId(), "matdiff");
  // Obtenim identificador per a l'atribut “matspec” del vertex shader
  matspecLoc = glGetAttribLocation (program->programId(), "matspec");
  // Obtenim identificador per a l'atribut “matshin” del vertex shader
  matshinLoc = glGetAttribLocation (program->programId(), "matshin");

  // Demanem identificadors per als uniforms del vertex shader
  transLoc = glGetUniformLocation (program->programId(), "TG");
  projLoc = glGetUniformLocation (program->programId(), "Proj");
  viewLoc = glGetUniformLocation (program->programId(), "View");
  
  posFocusLoc1 = glGetUniformLocation (program->programId(), "posFocus1");
  posFocusLoc2 = glGetUniformLocation (program->programId(), "posFocus2");
  posFocusLoc3 = glGetUniformLocation (program->programId(), "posFocus3");
  posFocusLoc4 = glGetUniformLocation (program->programId(), "posFocus4");
  
  posFocusLocLinterna = glGetUniformLocation (program->programId(), "posFocusLinterna");
  
  colFocusLoc1 = glGetUniformLocation (program->programId(), "colFocus1");
  colFocusLoc2 = glGetUniformLocation (program->programId(), "colFocus2");
}


void MyGLWidget::mouseMoveEvent(QMouseEvent *e)
{
  makeCurrent();
  // Aqui cal que es calculi i s'apliqui la rotacio o el zoom com s'escaigui...
  if (DoingInteractive == ROTATE)
  {
    // Fem la rotació
    angleY += (e->x() - xClick) * M_PI / ample;
    viewTransform ();
  }

  xClick = e->x();
  yClick = e->y();

  update ();
}

void MyGLWidget::keyPressEvent(QKeyEvent* event) {
  makeCurrent();
  switch (event->key()) {
    case Qt::Key_A: {
        rotate += float(M_PI)/4.0f;
        
        if (not encendreEscena and movFantasma <= 2.5) {
            if (fantasmaLuzApagada != 0.0) {
                movFantasma += 0.5;
            }
        }
        if (not encendreEscena) {
            if (uint(rotate) >= 0.7854 and uint(rotate) <= 2.3562) {
                fantasmaLuzApagada = 0.0;
            }
            else if (movFantasma >= 2.0) {
                    rotate = float(M_PI/2.0);
                    fantasmaLuzApagada = 0.0;
                    movFantasma = 0.0;
 
                    iniFocus();
                    encendreEscena = true;
                    encendreModel = true;
            }
            else fantasmaLuzApagada = escalaFantasma; 
        }
        break;
	}
	
    case Qt::Key_D: {
        rotate -= float(M_PI)/4.0f;
        
        if (not encendreEscena and movFantasma <= 2.5) {
            if (fantasmaLuzApagada != 0.0) {
                movFantasma += 0.5;
            }
        }
        if (not encendreEscena) {
            if (uint(rotate) >= 0.7854 and uint(rotate) <= 2.3562) {
                fantasmaLuzApagada = 0.0;
            }
            else if (movFantasma >= 2.0) {
                    rotate = float(M_PI/2.0);
                    fantasmaLuzApagada = 0.0;
                    movFantasma = 0.0;
                    
                    iniFocus();
                    encendreEscena = true;
                    encendreModel = true;
            }
            else fantasmaLuzApagada = escalaFantasma; 
        }
        break;
	}
	
	case Qt::Key_E: {
		encendreEscena = !encendreEscena; 
		if(encendreEscena) {
			glm::vec3 colFocus1 = glm::vec3(0.7, 0, 0.7);
			glUniform3fv(colFocusLoc1, 1, &colFocus1[0]);
            
            fantasmaLuzApagada = 0.0;
            modelTransformFantasma();
            
		}
		else {
			glm::vec3 colFocus1 = glm::vec3(0, 0, 0);
			glUniform3fv(colFocusLoc1, 1, &colFocus1[0]);
            
            fantasmaLuzApagada = escalaFantasma;
            modelTransformFantasma();
		}
		break;
    }
    
    case Qt::Key_M: {
		encendreModel = !encendreModel; 
		if(encendreModel) {
			glm::vec3 colFocus2 = glm::vec3(0.9, 0.9, 0);
			glUniform3fv(colFocusLoc2, 1, &colFocus2[0]);
		}
		else {
			glm::vec3 colFocus2 = glm::vec3(0, 0, 0);
			glUniform3fv(colFocusLoc2, 1, &colFocus2[0]);
		}
		break;
    }
    
  default: LL4GLWidget::keyPressEvent(event); break;
  }
  update();
}
