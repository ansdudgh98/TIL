/*
//
// Created by 문영호 on 2021/09/13.
//

#include<stdio.h>
//재귀 호출로 군수열의 합을 구하는 함수 원형 정의
int sig(int n);

int main()
{
    int n=4;
    int i, sum=0;

    //재귀 호출로 군수열의 합을 구하는 함수 호출
    for ( i=1; i<=n; i++ )
        sum = sum + sig(i);

    printf("n이 %d인 경우 군수열의 합 = %d\n", n, sum);

    getchar();

}

int sig(int n){
    if(n<=1) return n;
    else return n+sig(n-1);
}*/
