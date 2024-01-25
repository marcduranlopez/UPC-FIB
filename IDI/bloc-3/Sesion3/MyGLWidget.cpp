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
  creaBuffersPatricio();
  creaBuffersTerraIParet();
  
  glm::vec3 posFocus1 = glm::vec3(0, -0.5, 0);
  glUniform3fv(posFocusLoc1, 1, &posFocus1[0]);
  
  glm::vec3 posFocus2 = glm::vec3(0, -0.5, 0);
  glUniform3fv(posFocusLoc2, 1, &posFocus2[0]);
  
  
  glm::vec3 colFocus1 = glm::vec3(0.8, 0.8, 0.8);
  glUniform3fv(colFocusLoc1, 1, &colFocus1[0]);
  
  glm::vec3 colFocus2 = glm::vec3(0.8, 0.8, 0.8);
  glUniform3fv(colFocusLoc2, 1, &colFocus2[0]);
  
  mourePatr = glm::vec3(0., 0, 0.);
  
  posFocusX = 0.0;
  posFocusZ = 0.0;
  
  
  iniEscena();
  iniCamera();

  focusCam = 1;
  BackFaceCul = true;
  encendre1 = true;
  encendre2 = true;
}

void MyGLWidget::paintGL () 
{
  // En cas de voler canviar els paràmetres del viewport, descomenteu la crida següent i
  // useu els paràmetres que considereu (els que hi ha són els de per defecte)
  // glViewport (0, 0, ample, alt);
  
  // Esborrem el frame-buffer i el depth-buffer
  glClear (GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

  // Activem el VAO per a pintar el terra 
  glBindVertexArray (VAO_Terra);

  modelTransformTerra ();
  // pintem el terra
  glDrawArrays(GL_TRIANGLES, 0, 12);

  // Activem el VAO per a pintar el Patricio
  glBindVertexArray (VAO_Patr);

  modelTransformPatricio ();
  // Pintem el Patricio
  glDrawArrays(GL_TRIANGLES, 0, patr.faces().size()*3);
  
  glBindVertexArray(0);
}


void MyGLWidget::modelTransformPatricio ()
{
  glm::mat4 TG(1.f);  // Matriu de transformació
  TG = glm::translate(TG, glm::vec3(mourePatr.x, mourePatr.y, mourePatr.z));
  TG = glm::scale(TG, glm::vec3(escala, escala, escala));
  TG = glm::translate(TG, -centrePatr);
  
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
  projLoc = glGetUniformLocation (program->programId(), "proj");
  viewLoc = glGetUniformLocation (program->programId(), "view");
  
  posFocusLoc1 = glGetUniformLocation (program->programId(), "posFocus1");
  posFocusLoc2 = glGetUniformLocation (program->programId(), "posFocus2");
  
  colFocusLoc1 = glGetUniformLocation (program->programId(), "colFocus1");
  colFocusLoc2 = glGetUniformLocation (program->programId(), "colFocus2");
  
  FocusCamLoc = glGetUniformLocation (program->programId(), "focusCam");
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

void MyGLWidget::keyPressEvent(QKeyEvent* event) 
{
  makeCurrent();
  switch (event->key()) {
    case Qt::Key_O: { // canvia òptica entre perspectiva i axonomètrica
      perspectiva = !perspectiva;
      projectTransform ();
      break;
    }
    case Qt::Key_K: {
		if(posFocusX>= -2) {
			posFocusX -= 0.2;
            
			glm::vec3 posFocus1 = glm::vec3(posFocusX, 0.5, posFocusZ);
			glUniform3fv(posFocusLoc1, 1, &posFocus1[0]);
            
            glm::vec3 posFocus2 = glm::vec3(posFocusX, 0.5, posFocusZ);
			glUniform3fv(posFocusLoc2, 1, &posFocus2[0]);
		}
		break;
	}
	case Qt::Key_L: {
		if(posFocusX <= 2) {
			posFocusX += 0.2;
            
			glm::vec3 posFocus1 = glm::vec3(posFocusX, 0.5, posFocusZ);
			glUniform3fv(posFocusLoc1, 1, &posFocus1[0]);
            
            glm::vec3 posFocus2 = glm::vec3(posFocusX, 0.5, posFocusZ);
			glUniform3fv(posFocusLoc2, 1, &posFocus2[0]);
		}
		break;
	}
	/*
	case Qt::Key_F: {
		if(focusCam) {
            focusCam = 0;
        }
        else {
            focusCam = 1;
        }
			glUniform1i(FocusCamLoc, focusCam);
            break;
    }
    */
    case Qt::Key_Q: {
		escala += 0.02;
		break;
	}
	
	case Qt::Key_W: {
		escala -= 0.02;
		break;
	}
	
	case Qt::Key_Left: {
		mourePatr.x -= 0.2;
		posFocusX -= 0.2;
        
		glm::vec3 posFocus1 = glm::vec3(posFocusX, 0.5, posFocusZ);
        glUniform3fv(posFocusLoc1, 1, &posFocus1[0]);
            
        glm::vec3 posFocus2 = glm::vec3(posFocusX, 0.5, posFocusZ);
        glUniform3fv(posFocusLoc2, 1, &posFocus2[0]);
		break;
	}
	
	case Qt::Key_Right: {
		mourePatr.x += 0.2;
		posFocusX += 0.2;
        
		glm::vec3 posFocus1 = glm::vec3(posFocusX, 0.5, posFocusZ);
        glUniform3fv(posFocusLoc1, 1, &posFocus1[0]);
            
        glm::vec3 posFocus2 = glm::vec3(posFocusX, 0.5, posFocusZ);
        glUniform3fv(posFocusLoc2, 1, &posFocus2[0]);
		break;
	}
	
	case Qt::Key_Down: {
		mourePatr.z += 0.2;
		posFocusZ += 0.2;
        
		glm::vec3 posFocus1 = glm::vec3(posFocusX, 0.5, posFocusZ);
        glUniform3fv(posFocusLoc1, 1, &posFocus1[0]);
            
        glm::vec3 posFocus2 = glm::vec3(posFocusX, 0.5, posFocusZ);
        glUniform3fv(posFocusLoc2, 1, &posFocus2[0]);
		break;
	}
	
	case Qt::Key_Up: {
		mourePatr.z -= 0.2;
		posFocusZ -= 0.2;
        
		glm::vec3 posFocus1 = glm::vec3(posFocusX, 0.5, posFocusZ);
        glUniform3fv(posFocusLoc1, 1, &posFocus1[0]);
            
        glm::vec3 posFocus2 = glm::vec3(posFocusX, 0.5, posFocusZ);
        glUniform3fv(posFocusLoc2, 1, &posFocus2[0]);
		break;
	}
	
	case Qt::Key_B: {
		BackFaceCul = !BackFaceCul;
		
        if (BackFaceCul) glEnable(GL_CULL_FACE);
		else glDisable(GL_CULL_FACE);
		
        break;
	}
	
	case Qt::Key_1: {
		encendre1 = !encendre1; 
		if(encendre1) {
			glm::vec3 colFocus1 = glm::vec3(0.8, 0.8, 0.8);
			glUniform3fv(colFocusLoc1, 1, &colFocus1[0]);
		}
		else {
			glm::vec3 colFocus1 = glm::vec3(0, 0, 0);
			glUniform3fv(colFocusLoc1, 1, &colFocus1[0]);
		}
		break;
    }
    
    case Qt::Key_2: {
		encendre2 = !encendre2; 
		if(encendre2) {
			glm::vec3 colFocus2 = glm::vec3(0.8, 0.8, 0.8);
			glUniform3fv(colFocusLoc2, 1, &colFocus2[0]);
		}
		else {
			glm::vec3 colFocus2 = glm::vec3(0, 0, 0);
			glUniform3fv(colFocusLoc2, 1, &colFocus2[0]);
		}
		break;
    }
    default: event->ignore(); break;
  }
  update();
}

void MyGLWidget::calculaCapsaModel ()
{
  // Càlcul capsa contenidora i valors transformacions inicials
  float minx, miny, minz, maxx, maxy, maxz;
  minx = maxx = patr.vertices()[0];
  miny = maxy = patr.vertices()[1];
  minz = maxz = patr.vertices()[2];
  for (unsigned int i = 3; i < patr.vertices().size(); i+=3)
  {
    if (patr.vertices()[i+0] < minx)
      minx = patr.vertices()[i+0];
    if (patr.vertices()[i+0] > maxx)
      maxx = patr.vertices()[i+0];
    if (patr.vertices()[i+1] < miny)
      miny = patr.vertices()[i+1];
    if (patr.vertices()[i+1] > maxy)
      maxy = patr.vertices()[i+1];
    if (patr.vertices()[i+2] < minz)
      minz = patr.vertices()[i+2];
    if (patr.vertices()[i+2] > maxz)
      maxz = patr.vertices()[i+2];
  }
  escala = 0.3/(maxy-miny);
  centrePatr[0] = (minx+maxx)/2.0; centrePatr[1] = (miny+maxy)/2.0; centrePatr[2] = (minz+maxz)/2.0;
}
