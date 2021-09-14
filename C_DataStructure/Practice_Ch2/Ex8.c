#include<stdio.h>
#include<string.h>
//재귀 호출 원형 정의
int gcd(int m, int n);
int main()
{
    int n=12, m=18;
    printf("%d  %d의 최대 공약수 : %d \n ",
           n, m, gcd(n, m));

    getchar();
}


int gcd(int m,int n){
    if(n == 0){
        return m;
    }else{
        return gcd(n, m%n);
    }

}
