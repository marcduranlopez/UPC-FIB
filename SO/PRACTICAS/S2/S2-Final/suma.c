#include <string.h>
#include <stdio.h>
#include <unistd.h>

#include "mis_funciones.h"
  
int main (int argc, char *argv[]) {
    if (argc == 1) {
        usage();
        return 0;
    }
    
    int res = 0;
    char buf[80];
    for (int i = 1; i < argc; i++) {
      
        if (!esNumero (argv[i])) {
            sprintf (buf, "Error: el parámetro “%s” no es un número\n", argv[i]);
            write (1, buf, strlen (buf));
            return -1;
        }
      
        else res += mi_atoi(argv[i]);
        
    }
    sprintf buf, "La suma es %d\n", res);
    write (1, buf, strlen (buf));
    return 0;

}
