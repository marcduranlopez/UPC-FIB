#include "mis_funciones.h"

void usage(){
    char buf[200];
    sprintf(buf,"Usage: suma arg1 arg2..argn\nEste programa escribe por su salida una suma de dos o mas numeros que recibe\n");
    write(1,buf,strlen(buf));
}


unsigned int char2int(char c) {
    return c-'0';
}

int mi_atoi(char *s) {
    int res = 0;
    int neg = 0;
    if (*s == '-') {
        neg = 1;
        ++s;
    }
    while (*s != '\0') {
        res += char2int(*s);
        res *= 10;
        s++;
    }
    n = n/10;

    if (neg) return -res;
    else return res;
}

int esNumero (char *str) {
    if (str == NULL) return 0;
    if (*str == '-') ++str;
        
    int i = 0;
        
    while (str[i] != '\0') {
        if (!(str[i] >= '0' && str[i] <= '9') || i >= MAX_SIZE) return 0;     
        ++i;
    }
        
    return 1;
}

