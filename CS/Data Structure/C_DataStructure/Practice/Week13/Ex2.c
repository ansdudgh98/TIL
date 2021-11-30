#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <strings.h>

#define NAME_SIZE 255
#define MAX_SIZE 10
#define SWAP(x, y, t) ( (t)=(x), (x)=(y), (y)=(t) )
typedef struct {  // 레코드 정의 구조체
    int key;
    char name[NAME_SIZE];
} record;

int n;

// 삽입정렬
void insertion_sort(record r[], int n)
{
    int i, j, key;
    char name[255];
    for (i = 0; i<n; i++) {
        key = r[i].key;
        strcpy(name,r[i].name);
        for (j = i - 1; j >= 0 && r[j].key>key; j--){
            r[j+1].key = r[j].key; /* 레코드의 오른쪽 이동 */
            strcpy(r[j+1].name,r[j].name);
        }
        r[j + 1].key = key;
        strcpy(r[j+1].name,name);
    }
}

int main(void)
{
    int i;
    record r[10];
    n = MAX_SIZE;
    srand(time(NULL));
    strcpy(r[0].name,"김0");
    strcpy(r[1].name,"김1");
    strcpy(r[2].name,"김2");
    strcpy(r[3].name,"김3");
    strcpy(r[4].name,"김4");
    strcpy(r[5].name,"김5");
    strcpy(r[6].name,"김6");
    strcpy(r[7].name,"김7");
    strcpy(r[8].name,"김8");
    strcpy(r[9].name,"김9");

    insertion_sort(r, n); // 선택정렬 호출

    for (i = 0; i<n; i++)      	// 난수 생성 및 출력
        r[i].key = rand() % 100; // 난수 발생 범위 0~99

    for (i = 0; i<n; i++) {
        printf("%d ", r[i].key);
        printf("%s \n", r[i].name);
    }
    printf("\n");
    return 0;
}
