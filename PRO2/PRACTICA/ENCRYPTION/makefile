OPCIONS = -D_JUDGE_ -D_GLIBCXX_DEBUG -O2 -Wall -Wextra -Werror -Wno-sign-compare -std=c++11


program.exe: program.o Cjt_mensajes.o Cjt_rejillas.o Cjt_patrones.o Mensaje.o Rejilla.o Patron.o 
	g++ -o program.exe *.o 

program.o: program.cc Cjt_mensajes.hh Cjt_rejillas.hh Cjt_patrones.hh
	g++ -c program.cc $(OPCIONS) 

Cjt_mensajes.o: Cjt_mensajes.cc Cjt_mensajes.hh Mensaje.hh
	g++ -c Cjt_mensajes.cc $(OPCIONS) 

Cjt_rejillas.o: Cjt_rejillas.cc Cjt_rejillas.hh Rejilla.hh Cjt_mensajes.hh
	g++ -c Cjt_rejillas.cc $(OPCIONS) 

Cjt_patrones.o: Cjt_patrones.cc Cjt_patrones.hh Patron.hh
	g++ -c Cjt_patrones.cc $(OPCIONS) 

Mensaje.o: Mensaje.cc Mensaje.hh
	g++ -c Mensaje.cc $(OPCIONS)

Rejilla.o: Rejilla.cc Rejilla.hh
	g++ -c Rejilla.cc $(OPCIONS)

Patron.o: Patron.cc Patron.hh
	g++ -c Patron.cc $(OPCIONS)

clean:
	rm -f *.o
	rm -f *.exe

practica.tar: makefile html.zip jp_marc.duran.lopez.zip program.cc Cjt_mensajes.hh Cjt_mensajes.cc Cjt_rejillas.hh Cjt_rejillas.cc Cjt_patrones.hh Cjt_patrones.cc
	tar -cvf practica.tar makefile html.zip jp_marc.duran.lopez.zip program.cc Cjt_mensajes.hh Cjt_mensajes.cc Cjt_rejillas.hh Cjt_rejillas.cc Cjt_patrones.hh Cjt_patrones.cc Mensaje.hh Mensaje.cc Rejilla.hh Rejilla.cc Patron.hh Patron.cc 
