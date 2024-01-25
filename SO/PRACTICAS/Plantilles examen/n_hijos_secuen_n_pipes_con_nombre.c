#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <string.h>
#include <signal.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>

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
    
    int fd2 = open("salida.bin", O_RDWR | O_TRUNC | O_CREAT , S_IRUSR | S_IWUSR | S_IRGRP);
    if(fd2 == -1) error_y_exit("Error en el open", 1);
    
    int res = mknod("pipe", S_IFIFO | 0666, 1);
    //MOLT IMPORTANT EL MKNOD, EL 1 DEL FINAL SERA IGNORAT
	if (res == -1 && !EEXIST) error_y_exit("Error en crear la pipe", 1);
    
    int fd, fd3;
    for (int i = 1; i <= n; ++i) {
		int ret = fork();
		char s[50];
		switch (ret) {
			case 0:
                
                fd = open("pipe", O_WRONLY | O_CREAT , S_IRUSR | S_IWUSR);
                if(fd == -1) error_y_exit("Error en creacion de la pipe WR", 1);
                
                dup2(fd, 57);
                close(fd);
                execlp("./aleatorios", "./aleatorios", "100", (char*)0);
				error_y_exit("error en el execlp", 1);
				break;
			case -1:
				sprintf(s,"Ha fallado el fork del proceso: %d\n", getpid());
				error_y_exit(s, 1);
				break;
			default:
                
                fd3 = open("pipe", O_RDONLY | O_CREAT, S_IRUSR | S_IWUSR);
                if(fd3 == -1) error_y_exit("Error en creacion de la pipe", 1);

                dup2(fd3, 57);
                int num;
                while(read(fd3, &num, sizeof(int))>0){
//                       sprintf(s, "%d", num);
//                       write(1, s, strlen(s));
                    write(fd2, &num, sizeof(int));
                }
                close(fd3);
				waitpid(-1, NULL, 0);
				break;
		}
	}
	
	int size = lseek(fd2, 0, SEEK_END);
    int m = (size/2)/4;
    lseek(fd2, m, SEEK_SET);
    int aux;
    read(fd2, &aux, sizeof(int));
    close(fd2);
    
    char buff[256];
    sprintf(buff, "size: %d, La mitad la ocupa la posición %d que contiene el numero %d\n", size, m, aux);
    write(1, buff, strlen(buff));
}
