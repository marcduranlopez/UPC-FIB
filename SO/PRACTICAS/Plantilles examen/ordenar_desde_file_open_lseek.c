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
	sprintf(b,"usage : esperado ./numeros para-ordenar.txt\n");
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
    
    int fd1 = open(argv[1], O_RDWR);
    if(fd1 == -1) error_y_exit("Error en el open", 1);
    
    int fd2 = open(argv[1], O_RDWR);
    if(fd2 == -1) error_y_exit("Error en el open", 1);

    int ord = 0;
    while(!ord){
        ord = 1;
        int n = lseek(fd1, 0, SEEK_END);
        char a, b;
        /*
         
         A CADA ITERACIO CAL ESTAR SEGURS D'ON ES FA EL WRITE I ON EL READ, JA QUE AMBDUES OPERACIONS MOUEN EL PUNTER I POR INDUIR A ERRORS
         
         */
        int i = 0;
        while(i < n-2){
            lseek(fd1, i, SEEK_SET);
            lseek(fd2, i+1, SEEK_SET);
            read(fd1, &a, 1);
            read(fd2, &b, 1);
            int x = (int) a - 48;
            int y = (int) b - 48;
            // CANVIANT LA CONDICIO DEL IF ORDENA ASCENDENTMENT O DESCENDENTMENT
            if(y < x){
                lseek(fd1, i, SEEK_SET);
                lseek(fd2, i+1, SEEK_SET);
                write(fd1, &b, 1);
                write(fd2, &a, 1);
                ord = 0;
            }
            ++i;
        }
        if(ord) write(1, "ja esta ordenat\n", 16); 
    }
}
