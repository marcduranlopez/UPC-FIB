TEMPLATE    = app
QT         += opengl 
CONFIG     += qt

INCLUDEPATH +=  /usr/include/glm
INCLUDEPATH +=  ../../Model

FORMS += MyForm.ui

HEADERS += MyForm.h BL2GLWidget.h MyGLWidget.h MyLabel.h

SOURCES += main.cpp MyForm.cpp \
        BL2GLWidget.cpp MyGLWidget.cpp MyLabel.cpp

SOURCES += ../../Model/model.cpp
