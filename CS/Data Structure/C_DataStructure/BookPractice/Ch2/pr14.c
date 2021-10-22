//
// Created by 문영호 on 2021/10/22.
//

#include "stdio.h"

double cal(int n);

int main(){
    double result = cal(10);
    printf("%f",result);

}

double cal(int n){
    if (n==1) return 1;
    else return cal(n-1) + 1/n;
}

