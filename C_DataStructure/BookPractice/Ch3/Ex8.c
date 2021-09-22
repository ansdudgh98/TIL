//
// Created by 문영호 on 2021/09/22.
//
#include <stdio.h>
#include <stdlib.h>
#include <malloc/malloc.h>

#define Size 10

int main(void){
    int *p;

    p= (int *) malloc(Size * sizeof(int));
    if(p==NULL){
        fprintf(stderr,"메모리가 부족해서 할당할 수 없습니다.");
        exit(1);
    }
    for(int i=0;i<Size;i++)
        p[i] = i;

    for (int i=0;i<Size;i++){
        printf("%d",p[i]);
    }

    free(p);

    return 0;

}
