#include <string.h>
#include <stdio.h>
#include <unistd.h>

int main(int argc,char *argv[]) {
    if (argc == 1) {
        usadge();
        return 0;
    }
    
    char buf[80];
        for (int i=0;i<argc;i++){
            if (i==0){
                sprintf(buf,"El argumento %d es %s (es el nombre del ejecutable)\n",i,argv[i]);
            }else{
                sprintf(buf,"El argumento %d es %s\n",i,argv[i]);
            }
            write(1,buf,strlen(buf));
        }
        return 0;
}
