#include <stdio.h>
#include <string.h>
#include "stdlib.h"

int main(){
    char string[100];
    printf("input:");
    scanf("%s",string);

    char *token = strtok(string," ");
    //char *token1 = strtok(string," ");
    while(token !=NULL){
        printf("%s\n",token);
        token = strtok(NULL," ");
    }

}