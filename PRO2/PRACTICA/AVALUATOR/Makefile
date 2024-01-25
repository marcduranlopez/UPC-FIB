OPCIONS = -D_JUDGE_ -D_GLIBCXX_DEBUG -O2 -Wall -Wextra -Werror -Wno-sign-compare -std=c++11


program.exe: program.o conj_problemas.o conj_sesiones.o conj_cursos.o conj_usuarios.o Problema.o Sesion.o Curso.o Usuario.o
	g++ -o program.exe *.o 

conj_problemas.o: conj_problemas.cc conj_problemas.hh Problema.hh
	g++ -c conj_problemas.cc $(OPCIONS) 

conj_sesiones.o: conj_sesiones.cc conj_sesiones.hh Sesion.hh
	g++ -c conj_sesiones.cc $(OPCIONS) 

conj_cursos.o: conj_cursos.cc conj_cursos.hh Curso.hh conj_sesiones.hh conj_problemas.hh
	g++ -c conj_cursos.cc $(OPCIONS) 

conj_usuarios.o: conj_usuarios.cc conj_usuarios.hh conj_cursos.hh Usuario.hh
	g++ -c conj_usuarios.cc $(OPCIONS)

Problema.o: Problema.cc Problema.hh
	g++ -c Problema.cc $(OPCIONS)

Sesion.o: Sesion.cc Sesion.hh
	g++ -c Sesion.cc $(OPCIONS)

Curso.o: Curso.cc Curso.hh conj_sesiones.hh conj_problemas.hh
	g++ -c Curso.cc $(OPCIONS)

Usuario.o: Usuario.cc Usuario.hh Problema.hh conj_cursos.hh conj_sesiones.hh Curso.hh
	g++ -c Usuario.cc $(OPCIONS)

program.o: program.cc conj_problemas.hh conj_sesiones.hh conj_cursos.hh conj_usuarios.hh
	g++ -c program.cc $(OPCIONS) 

clean:
	rm -f *.o
	rm -f *.exe

practica.tar: Makefile Doxyfile program.cc conj_problemas.hh conj_problemas.cc conj_sesiones.hh conj_sesiones.cc conj_cursos.hh conj_cursos.cc conj_usuarios.hh conj_usuarios.cc
	tar -cvf practica.tar Makefile Doxyfile program.cc conj_problemas.hh conj_problemas.cc conj_sesiones.hh conj_sesiones.cc conj_cursos.hh conj_cursos.cc conj_usuarios.hh conj_usuarios.cc Problema.hh Problema.cc Sesion.hh Sesion.cc Curso.hh Curso.cc Usuario.hh Usuario.cc html.zip
