#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>
#include <signal.h>
#include <unistd.h>

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
    int numeros [1048576];
    srand(getpid());
    for(int i = 0; i < n; ++i){
        int num = rand() % 1048576;
        while(numeros[num] == 1) num = rand() % 1048576;
        numeros[num] = 1;
        char buff[256];
//          sprintf(buff, "%d\n", num);
//          write(1, buff, strlen(buff));
        write(57, &num, sizeof(int));
    }
}
