#include <pwd.h>
#include "stdio.h"
#include "stdlib.h"
#include "unistd.h"
#include "errno.h"

int main(int argc,char *argv[]){
    struct passwd * result;
    char buf[256];

    if(argc != 2 ){
        fprintf(stderr,"Usage = %s username\n",argv[0]);
        exit(EXIT_FAILURE);
    }
    result = getpwnam(argv[1]);

    if(result==NULL){
        perror("getpwam_r");
        exit(EXIT_FAILURE);
    }

    printf("Name : %s UID :%d\n",argv[1],result->pw_uid);
    exit(EXIT_SUCCESS);
}