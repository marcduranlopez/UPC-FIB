#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>
#include <signal.h>
#include <unistd.h>
#include <fcntl.h>


void usage(){
	char b[128];
	sprintf(b,"usage : Se requiere un parametro N de entrada --> ./aleatorios N\n");
	write(1,b,strlen(b));
	exit(EXIT_FAILURE);
}

void error_y_exit(char *s, int error) {
	perror(s);
	exit(error);
}

int main(int argc,char *argv[])
{
	if(argc != 2) usage();
    int n = atoi(argv[1]);
    
    int fd = open("salida.bin", O_RDWR | O_TRUNC | O_CREAT , S_IRUSR | S_IWUSR | S_IRGRP);
    if(fd == -1) error_y_exit("Error en el open", 1);
    
    for (int i = 1; i <= n; ++i) {
        int pf[2];
        if(pipe(pf) == -1) error_y_exit("Error en la creacion del pipe\n",1);
		int ret = fork();
		char s[50];
		switch (ret) {
			case 0:
                close(pf[0]);
                dup2(pf[1], 57);
                close(pf[1]);
                execlp("./aleatorios", "./aleatorios", "100", (char*)0);
				error_y_exit("error en el execlp", 1);
				break;
			case -1:
				sprintf(s,"Ha fallado el fork del proceso: %d\n", getpid());
				error_y_exit(s, 1);
				break;
			default:
                close(pf[1]);
                
                dup2(pf[0], 57);
                int num;
                while(read(pf[0], &num, sizeof(int))>0){
//                     sprintf(s, "%d", num);
//                     write(1, s, strlen(s));
                    write(fd, &num, sizeof(int));
                }
                close(pf[0]);
				waitpid(-1, NULL, 0);
				break;
		}
	}
	
	int size = lseek(fd, 0, SEEK_END);
    int m = (size/2)/4;
    lseek(fd, m, SEEK_SET);
    int aux;
    read(fd, &aux, sizeof(int));
    close(fd);
    
    char buff[256];
    sprintf(buff, "La mitad la ocupa la posición %d que contiene el numero %d\n", m, aux);
    write(1, buff, strlen(buff));
}
