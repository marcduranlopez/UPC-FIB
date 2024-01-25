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
	sprintf(b,"usage : ./mux N 20< test_fd20 21< test_fd21\n");
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
    char *buff1;
    char *buff2;
    buff1 = malloc(n);
    buff2 = malloc(n);
    
    char *buff3;
    buff3 = sbrk(2*n);
    int x, y;
    while( ((x = read(20, buff1, n)) > 0)  ){
        y = read(21, buff2, n);
        int k = 0;
        for(int i = 0; i < x; ++i){
            buff3[k] = buff1[i];
            k += 2;
        }
        k = 1;
        for(int i = 0; i < x; ++i){
            buff3[k] = buff2[i];
            k += 2;
        }
        write(1, buff3, x+y);
        //IMPORTANT POSAR X + Y JA QUE SI NO A VEGADES ESCRIU MES DEL NECESSARI
    }
    
    
    
    sbrk(-2*n);
    free(buff2);
    free(buff1);
}

