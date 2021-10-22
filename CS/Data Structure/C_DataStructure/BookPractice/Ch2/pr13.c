//
// Created by 문영호 on 2021/10/22.
//
#include "stdio.h"

int sum(int n);

int main(){
    int n = 10;
    int result = sum(10);
    printf("%d",result);
}

int sum(int n){
    if(n==1) return 1;
    else return n+(sum(n-1));
}

