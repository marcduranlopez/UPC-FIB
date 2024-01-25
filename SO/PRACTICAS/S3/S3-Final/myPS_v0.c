// (c) FIBerHub, https://fiberhub.tk

#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

void error_y_exit(char *msg,int exit_status){
	perror(msg);
	exit(exit_status);
}

int main(int argc, char *argv[]){

int pid = fork();

char buffer[80];

	if (argc != 2) error_y_exit("Error, debes especificar al menos un parametro", -1);
	if (pid == -1) error_y_exit("Error del proceso hijo", -1);

	sprintf(buffer, "Soy el proceso: %d\n", getpid());
	write(1,buffer,strlen(buffer));

	if (pid == 0){
		sprintf(buffer, "Parametros: %s\n",argv[1]);
		write(1,buffer,strlen(buffer));	
	}

	while(1);
}
