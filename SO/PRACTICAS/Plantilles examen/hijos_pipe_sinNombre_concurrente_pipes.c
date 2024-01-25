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
	sprintf(b,"usage : esperado ./cuenta_lineas parametro1(fichero de texto) parametro2(palabra a buscar)\n");
	write(1,b,strlen(b));
	exit(EXIT_FAILURE);
}

void error_y_exit(char *s, int error) {
	perror(s);
	exit(error);
}

int main(int argc,char *argv[])
{
	if(argc != 3) usage();
    int pipe1[2];
    int pipe2[2];
    int res = pipe(pipe1);
    if(res == -1) error_y_exit("Error en la creacion del pipe\n",1);
    res = pipe(pipe2);
    if(res == -1) error_y_exit("Error en la creacion del pipe\n",1);
    
    char c[1];
    char buff[4096];
    
    for (int i = 1; i <= 3; ++i) {
		int ret = fork();
		char s[50];
		switch (ret) {
			case 0:
				if(i == 1){ //hijo 1 muta a cat
                    close(pipe1[0]);close(pipe2[0]);close(pipe2[1]);
                    dup2(pipe1[1], 1);
                    close(pipe1[1]);
                    char par1[100];
                    sprintf(par1, "%s", argv[1]);
                    execlp("cat", "cat", par1, (char*)0);
                    error_y_exit("Error en el execlp a cat", 1);
                }
                else if(i == 2){ //hijo 2 muta a grep
                    close(pipe1[1]);close(pipe2[0]);
                    
                    dup2(pipe1[0], 0);
                    dup2(pipe2[1], 1);
                    
                    char par2[100];
                    sprintf(par2, "%s", argv[2]);
                    execlp("grep", "grep",par2, (char*)0);
                    close(pipe1[0]);
                    close(pipe2[1]);
                    error_y_exit("Error en el execlp a grep", 1);
                }
                else if (i == 3){ //hijo 3 muta a wc -l
                    close(pipe1[0]);close(pipe1[1]);close(pipe2[1]);
                    dup2(pipe2[0], 0);
                    close(pipe2[0]);
                    execlp("wc", "wc","-l", (char*)0);
                    error_y_exit("Error en el execlp a wc", 1);
                }
                else exit(0);
				break;
			case -1:
				sprintf(s,"Ha fallado el fork del proceso: %d\n", getpid());
				error_y_exit(s, 1);
				break;
			default:
                
				break;
		}
	}
	//important fer el close dels canals al final(el pare), si els tanquem abans els seguents fills no podran accedir als canals de la pipe
	close(pipe1[0]);close(pipe1[1]);close(pipe2[0]);close(pipe2[1]);
	while(waitpid(-1,NULL,0) > 0);
    
}
