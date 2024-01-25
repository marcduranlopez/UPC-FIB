#include <stdio.h>
#include <string.h>
#include <unistd.h>

#define MAX_SIZE 8

    //Escribe en pantalla como funciona el programa.
    void usage();
    
    //Convierte un char a int teniendo como pre que el char que se introduce es un número.
    unsigned int char2int(char c);
    
    //Convierte una cadena de chars a int aceptando que se introduce una cadena de chars.
    int mi_atoi(char *s);
    
    //Comprueba que la cadena de carácteres introducida como parámetro es un número.
    int esNumero (char *str);
