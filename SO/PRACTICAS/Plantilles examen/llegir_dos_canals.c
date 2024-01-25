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
	sprintf(b,"usage : ./mux 20< test_fd20 21< test_fd21\n");
	write(1,b,strlen(b));
	exit(EXIT_FAILURE);
}

void error_y_exit(char *s, int error) {
	perror(s);
	exit(error);
}

int main(int argc,char *argv[])
{
    if(argc != 1) usage();
    
    char a, b;
    while( (read(20, &a, 1) > 0) && (read(21, &b, 1) > 0) ){
        write(1, &a, 1);
        write(1, &b, 1);
    }
}

