#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
#include <unistd.h>

void usage(){
	char b[128];
	sprintf(b,"usage : esperado ./numeros numeros.txt\n");
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
    
    int fd = open(argv[1], O_RDONLY);
    if(fd == -1) error_y_exit("Error en el open", 1);
    //hem de llegir d'aquest arxiu
    
    int fd2 = open("suma.txt", O_RDWR | O_TRUNC | O_CREAT , S_IRUSR | S_IWUSR);
    if(fd2 == -1) error_y_exit("Error en el open", 1);
    //volem escriure d'aquest arxiu
    
    int num;
    int suma = 0;
    while(read(fd, &num, sizeof(int) > 0)){
        suma = suma + num;
    }
    char buff[256];
    sprintf(buff, "%d\n", suma);
    write(1, buff, strlen(buff));
    write(fd2, buff, strlen(buff));
    
    close(fd);close(fd2);
}
