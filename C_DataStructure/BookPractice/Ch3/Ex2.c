//
// Created by 문영호 on 2021/09/21.
//

#include <stdio.h>
#define Max(a,b) (((a)>(b))?(a):(b))
#define Max_DEGREE 101

typedef struct {
    int degree;
    float coef[Max_DEGREE];
}polynoimal;

polynoimal poly_add1(polynoimal A,polynoimal B){
    polynoimal C;

    int Apos = 0, Bpos = 0 ,Cpos=0;

    int degree_a = A.degree;
    int degree_b = B.degree;
    C.degree = Max(A.degree,B.degree);

    while (Apos<=A.degree && Bpos <=B.degree){
        if(degree_a>degree_b){
            C.coef[Cpos++] = A.coef[Apos++];
            degree_a--;
        } else if(degree_a == degree_b){
            C.coef[Cpos++] = A.coef[Apos++] + B.coef[Bpos++];
            degree_a --;
            degree_b--;
        }
        else {
            C.coef[Cpos++] = B.coef[Bpos++];
            degree_b--;
        }
        return C;

    }
}

void print_poly(polynoimal p){
    for(int i=p.degree;i>0;i--){
        printf("%3.1fx^%d +",p.coef[p.degree-i],i);
    }
    printf("%3.1f\n",p.coef[p.degree]);
}

int main(void){
    polynoimal a = {5,{3,6,0,0,0,10}};
    polynoimal b = {4,{7,0,5,0,1}};
    polynoimal c ;

    print_poly(a);
    print_poly(b);
    c = poly_add1(a,b);
    printf("-------------------------------------------\n");
    print_poly(c);
    return 0;

}

