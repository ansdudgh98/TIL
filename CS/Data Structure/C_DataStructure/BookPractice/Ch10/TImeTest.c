#include <stdio.h>

#include <time.h>
#include <limits.h>



void bubble_sort(int arr[], int count)    // 매개변수로 정렬할 배열과 요소의 개수를 받음
{
    int temp;

    for (int i = 0; i < count; i++)    // 요소의 개수만큼 반복
    {
        for (int j = 0; j < count - 1; j++)   // 요소의 개수 - 1만큼 반복
        {
            if (arr[j] > arr[j + 1])          // 현재 요소의 값과 다음 요소의 값을 비교하여
            {                                 // 큰 값을
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;            // 다음 요소로 보냄
            }
        }
    }
}

int main()
{
    int testnum = 30000;
    clock_t start1,  end1;
    float res1;
    int numArr[testnum];

    start1 = clock();

    for(int i=testnum;i>0;i--){
        numArr[i] = i ;
    }

    bubble_sort(numArr, sizeof(numArr) / sizeof(int));    // 거품 정렬 함수 호출

    for (int i = 0; i < testnum; i++)
    {

    }
    printf("정렬 완료");

    printf("\n");

    end1 = clock();

    res1 = (float)(end1 - start1)/CLOCKS_PER_SEC;

    printf("%f",res1);

    printf("\n");

    return 0;
}