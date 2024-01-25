// (c) FIBerHub, https://fiberhub.tk

#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <string.h>

int contador = 0;

void trata(int s)
{
    if (s == SIGALRM) contador += 1;
    if (s == SIGUSR1) contador = 0;
    else if (s == SIGUSR2) {
        char buf[80];
        sprintf(buf, "Valor contador: %d\n", contador);
        write(1, buf, strlen(buf));
    }
}



int main(int argc,char *argv[])
{
    sigset_t mask;

    sigemptyset(&mask);
    sigaddset(&mask, SIGALRM);
    sigaddset(&mask, SIGUSR1);
    sigaddset(&mask, SIGUSR2);
	sigprocmask(SIG_BLOCK, &mask, NULL);


    struct sigaction sa;
    sa.sa_handler = &trata;
    sa.sa_flags = SA_RESTART;
    sigfillset(&sa.sa_mask);


    sigaction(SIGALRM, &sa, NULL);
    sigaction(SIGUSR1, &sa, NULL);
    sigaction(SIGUSR2, &sa, NULL);
    while (1) {
        alarm(1);
        sigfillset(&mask);
        sigdelset(&mask, SIGALRM);
        sigdelset(&mask, SIGUSR1);
        sigdelset(&mask, SIGUSR2);
        sigdelset(&mask, SIGINT);
        sigsuspend(&mask);
    }
    return 0;
}
