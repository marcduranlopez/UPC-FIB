#include <stdio.h>
#include <string.h>
#include <unistd.h>

#include <sys/wait.h>
#include <signal.h>

#include <string.h>

#define MAX_SIZE 8 (numero de cifras)

--------------------------------------------------------------------------------------

void usage(){
	char buf[110];
	sprintf(buf,"Usage: suma arg1 arg2..argn\nEste programa escribe por su salida una suma de dos o mas numeros que recibe\n");
	write(1,buf,strlen(buf));
}
------------------------------------------------------------------------------------

unsigned int char2int(char c) {
	return c-'0';
}
------------------------------------------------------------------------------------
if (argc != 2) error_y_exit("Error, debes especificar al menos un parametro", -1);

void error_y_exit(char *msg,int exit_status){
	perror(msg);
	exit(exit_status);
}

-------------------------------------------------------------------------------------
all: listaParametros punteros words

listaParametros: listaParametros.c
	gcc -o listaParametros listaParametros.c
punteros:
	gcc -o punteros punteros.c
words:
	gcc -o words words.c

clean:
	rm listaParametros
	rm punteros
	rm words
	
---------------------------------------------------------------------------------------
	
	
all: suma (concatenando un .h)
suma: suma.c mis_funciones.c mis_funciones.h
	gcc -c mis_funciones.c -o mis_funciones.o
	gcc -o suma suma.c mis_funciones.o
clean:
	rm suma
	rm mis_funciones.o
	
------------------------------------------------------------------------------------
int mani(int argc, cahr *argv[]) {
    char buf[80];
    
    for(int i=0; i<argc; ++i) {
        sprintf(buf,"El argumento %d es %s\n",i,argv[i]);
        write(1,buf,strlen(buf));
    }
    return 0;
}

--------------------------------------------------------------------------------------


int segundos=0;
/* FUNCION DE ATENCION AL SIGNAL SIGALRM */
void funcion_alarma(int s)
{
    char buff[256];
    segundos=segundos+10;
    sprintf(buff, "ALARMA pid=%d: %d segundos\n",getpid(),segundos);
    write(1, buff, strlen(buff)); 
}
int main (int argc,char * argv[])
{
    struct sigaction sa;
    sigset_t mask;

    sigemptyset(&mask);
    sigaddset(&mask, SIGALRM);
    sigprocmask(SIG_BLOCK,&mask, NULL);

    /* REPROGRAMAMOS EL SIGNAL SIGALRM */
    sa.sa_handler = &funcion_alarma;
    sa.sa_flags = SA_RESTART; 
    sigfillset(&sa.sa_mask); 

    if (sigaction(SIGALRM, &sa, NULL) < 0) error_y_exit("sigaction", 1);

    while (segundos<100)
    {
	alarm(10); 	/* Programamos la alarma para dentro de 10 segundos */
		  	/* Nos bloqueamos a esperar que nos llegue un evento */
	sigfillset(&mask);
        sigdelset(&mask, SIGALRM);
	sigdelset(&mask, SIGINT);
        sigsuspend(&mask);
    }
    exit(1);

--------------------------------------------------------------------------------------

void trata_hijo(int s) {
	int pid, exit_code;
	char buff[256];	
	while ((pid = waitpid(-1, &exit_code, WNOHANG)) > 0) {
		if (WIFEXITED(exit_code)) {
			int statcode = WEXITSTATUS(exit_code);
			sprintf(buff,"Termina el proceso %d com exit code %d\n",pid, statcode);
		}
		else {
			int signcode = WTERMSIG(exit_code);
			sprintf(buff,"Han matado al proceso %d antes de acabar alarm por el signal %d\n",pid, signcode);
		}
		write(1, buff, strlen(buff)); 
		hijos--;
		++contador;
	}
}

----------------------------------------------------------------------------------

    struct sigaction sa1;
    sa1.sa_handler = SIG_DFL;
    sa1.sa_flags = SA_RESETHAND;
    sigfillset(&sa1.sa_mask);

    sigaction(SIGALRM, &sa1, NULL);
    sigaction(SIGUSR1, &sa1, NULL);
    sigaction(SIGUSR2, &sa1, NULL);
