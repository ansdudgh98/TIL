/*
//
// Created by 문영호 on 2021/09/13.
//

#include<stdio.h>

int recursive(int n);

int main()
{
    int n=100;
    //재귀 호출로 1~100까지 출력하는 함수 호출
    recursive(n);

    getchar();


}


int recursive(int n){

    printf("%d\t",100-(n-1));
    if(n%10==1) printf("\n");
    if(n<=1) return 0;
    else return recursive(n-1);

}

*/
