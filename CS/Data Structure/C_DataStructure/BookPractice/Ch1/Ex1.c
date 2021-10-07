//
// Created by 문영호 on 2021/09/16.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void){
    clock_t start,stop;
    double duration;
    start = clock();

    for(int i = 0 ;i<100000000;i++){

    }

    stop = clock();
    duration = (double)(stop-start);
    printf("수행시간은 %f초입니다.\n",duration);
    return 0;

}