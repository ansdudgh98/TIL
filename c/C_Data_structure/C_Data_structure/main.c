#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
    int a ;
    int b ;
    
   printf("a를 입력하세요: ");
    scanf("%d",&a);
    printf("b를 입력하세요 : ");
    scanf("%d",&b);
    printf("입력된 수 A는 %d B는 %d\n",a,b);
    
    int temp = a;
    a=b;
    b=temp;
   printf("교환된  수 A는 %d B는 %d\n",a,b);
    
    
    
    
    
    
}
