// (c) FIBerHub, https://fiberhub.tk

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>

#include <sys/types.h>
#include <sys/wait.h>

void error_y_exit(char *msg,int exit_status) {
    perror(msg);
    exit(exit_status);
}

/* Ejecuta el comando ps -u username mediante la llamada al sistema execlp */
/* Devuelve: el código de error en el caso de que no se haya podido mutar */

int main(int argc,char *argv[])
{
	char buffer[80];
	for (int i = 1; i <= 4; ++i) {
		int pid=fork();
		if (pid == -1){ /* Se ha producido un error */
				error_y_exit("Error en el fork", 1);
			//default: /* (pid !=0) && (pid !=-1) */
				/* Escribe aqui el codigo del padre */
		} else if (pid == 0){ /* Escribe aqui el codigo del proceso hijo */ 
				if (i == 1) execlp("./listaParametros", "./listaParametros", "a", "b", (char*)NULL);
				else if (i == 2) execlp("./listaParametros", "./listaParametros", (char*)NULL);
				else if (i == 3) execlp("./listaParametros", "./listaParametros", "25", "4", (char*)NULL);
				else execlp("./listaParametros", "./listaParametros", "1024", "hola", "adios", (char*)NULL);
				exit(0);
		}
	}
	while ((waitpid(-1, NULL, 0)) > 0);
}
