//
//  Ex1.c
//  C_Data_structure
//
//  Created by 문영호 on 2021/09/13.
//



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
