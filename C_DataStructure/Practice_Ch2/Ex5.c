//
// Created by 문영호 on 2021/09/13.
//

#include<stdio.h>
//재귀 호출로 별을 삼각형 모양으로 출력하는 함수 원형 정의
void star(int n);
int main()
{ㅜㄴ
    int n=5;
    //재귀 호출로 별을 삼각형 모양으로 출력하는 함수 호출
    star(5);

    getchar();
}
void draw(int n){

    printf("*");

    if(n<=0){
        return;
    }
    else
        draw(n-1);
}

void star(int n){

    if(n<0) {
        printf("end");
        return;
    }
    else{
        draw(n);
        printf("\n");
        star(n-1);
}
}

