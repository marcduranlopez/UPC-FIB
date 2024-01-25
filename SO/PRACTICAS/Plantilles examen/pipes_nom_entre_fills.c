#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>
#include <unistd.h>
#include <errno.h>

void usage(){
	char b[4096];
	sprintf(b,"usage : ./principal_np acepta varios numeros de parametros\n0: lectura stdin y escritura stdout\n1: lectura de fichero y escritura en stdout\n2: lectura de fichero1 y escritura en fichero2\n");
	write(1,b,strlen(b));
	exit(EXIT_FAILURE);
}

void error_y_exit(char *s, int error) {
	perror(s);
	exit(error);
}

int main(int argc,char *argv[])
{
    if(argc > 3) usage();
    int res;
    res = mknod("DemuxToCesar", S_IFIFO | 0600, 1);
    if (res == -1 && !EEXIST) error_y_exit("Error en crear la pipe", 1);
    res = mknod("DemuxToMirror", S_IFIFO | 0600, 1);
    if (res == -1 && !EEXIST) error_y_exit("Error en crear la pipe", 1);
    
    res = mknod("CesarToMux", S_IFIFO | 0600, 1);
    if (res == -1 && !EEXIST) error_y_exit("Error en crear la pipe", 1);
    res = mknod("MirrorToMux", S_IFIFO | 0600, 1);
    if (res == -1 && !EEXIST) error_y_exit("Error en crear la pipe", 1);
    
    char s[100];
    for(int i = 1; i <= 4; ++i){
        int pid;
        pid = fork();
        switch (pid) {
            case 0:
                
                if(i == 1){
                    int fd1, fd2;
                    fd1 = open("DemuxToCesar", O_WRONLY | O_CREAT , S_IRUSR | S_IWUSR);
                    if(fd1 == -1) error_y_exit("Error en creacion de la pipe DemuxToCesar", 1);
                    fd2 = open("DemuxToMirror", O_WRONLY | O_CREAT , S_IRUSR | S_IWUSR);
                    if(fd2 == -1) error_y_exit("Error en creacion de la pipe DemuxToMirror", 1);
                    
                    dup2(fd1, 20);
                    dup2(fd2, 21);
                    
                    close(fd1); close(fd2);
                    if(argc == 1){
//                         printf("Te un unic argument\n");
                        execlp("./demux_ok", "./demux_ok", NULL);
                    }
                    else{
                        int f = open(argv[1], O_RDONLY); 
                        if(f == -1) error_y_exit("error en el open", 1);
                        dup2(f, 0);
                        close(f);
//                         printf("Te dos o tres arguments\n");
                        execlp("./demux_ok", "./demux_ok",  NULL);
                    }
                    error_y_exit("error en el execlp", 1);
                }
                if(i == 2){
                    int fd1, fd2;
                    fd1 = open("DemuxToCesar", O_RDONLY | O_CREAT , S_IRUSR | S_IWUSR);
                    if(fd1 == -1) error_y_exit("Error en creacion de la pipe DemuxToCesar", 1);
                    fd2 = open("CesarToMux", O_WRONLY | O_CREAT , S_IRUSR | S_IWUSR);
                    if(fd2 == -1) error_y_exit("Error en creacion de la pipe DemuxToMirror", 1);
                    
                    dup2(fd1, 0);
                    dup2(fd2, 1);
                    
                    close(fd1); close(fd2);
                    //com no tenim entrada aqui no posem parametres d'entrada
                    execlp("./des", "./des", "cesar", NULL);
                    error_y_exit("error en el execlp", 1);
                }
                if(i == 3){
                    int fd1, fd2;
                    fd1 = open("DemuxToMirror", O_RDONLY | O_CREAT , S_IRUSR | S_IWUSR);
                    if(fd1 == -1) error_y_exit("Error en creacion de la pipe DemuxToCesar", 1);
                    fd2 = open("MirrorToMux", O_WRONLY | O_CREAT , S_IRUSR | S_IWUSR);
                    if(fd2 == -1) error_y_exit("Error en creacion de la pipe DemuxToMirror", 1);
                    
                    dup2(fd1, 0);
                    dup2(fd2, 1);
                    
                    close(fd1); close(fd2);
                    //com no tenim entrada aqui no posem parametres d'entrada
                    execlp("./des", "./des", "mirror", NULL);
                    error_y_exit("error en el execlp", 1);
                }
                if(i == 4){
                    int fd1, fd2;
                    fd1 = open("CesarToMux", O_RDONLY | O_CREAT , S_IRUSR | S_IWUSR);
                    if(fd1 == -1) error_y_exit("Error en creacion de la pipe DemuxToCesar", 1);
                    fd2 = open("MirrorToMux", O_RDONLY | O_CREAT , S_IRUSR | S_IWUSR);
                    if(fd2 == -1) error_y_exit("Error en creacion de la pipe DemuxToMirror", 1);
                    
                    dup2(fd1, 20);
                    dup2(fd2, 21);
                    
                    close(fd1); close(fd2);
                    //com no tenim entrada aqui no posem parametres d'entrada
                    if(argc == 3){
//                         printf("Te tres arguments\n");
                        int f = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR | S_IRGRP);
                        if(f == -1) error_y_exit("Error en el open", 1);
                        dup2(f, 1);
                        close(f);
                        execlp("./mux_ok", "./mux_ok", NULL);
                    }
                    else{
//                         printf("Te un o dos arguments\n");
                        execlp("./mux_ok", "./mux_ok", NULL);
                    }
                    error_y_exit("error en el execlp", 1);
                }
                
                break;
            case -1:
                
                sprintf(s,"Ha fallado el fork del proceso: %d\n", getpid());
                error_y_exit(s, 1);
                break;
            default:
                
                break;
        }
    }
    waitpid(-1, NULL, 0);
}
