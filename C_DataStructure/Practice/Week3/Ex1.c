//
// Created
// by 문영호 on 2021/09/23.
//


#include <stdio.h>
#include <string.h>

char* reverse(char *s)
{
    char* tmpstr = *s;
    printf("%s",tmpstr);
    int lenstr = strlen(*s);
    for(int i=0,j=strlen-1;i<lenstr,j>0;i++,j--){
        *(tmpstr + i) = *(s + j);
    }
    return *tmpstr;

}
int main()
{
    char* str1 = "apple";
    //문자열을 뒤집는 함수를 호출한다.
    char* str2 = reverse(str1);

    printf(" 원본 %s \n", str1);
    printf(" 역순 %s \n", str2);

    getchar();
}