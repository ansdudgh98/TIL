/*
//
// Created by 문영호 on 2021/09/13.
//

#include<stdio.h>
#include<string.h>
//재귀 호출로 문자열을 뒤집는 함수 원형 정의
void reverse(char str[ ], int size);
int main()
{
    reverse("flower", strlen("flower"));

    getchar();
}

void reverse(char str[ ], int size){
    if(*str == '\0') return;
    else{
        reverse(str+1,10);
        printf("%c",*str);
    }
}


*/
