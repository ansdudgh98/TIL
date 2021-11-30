#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ELEMENT 200
typedef struct {
    int key;
} element;
typedef struct {
    element heap[MAX_ELEMENT];
    int heap_size;
} HeapType;

HeapType* create()
{
    return (HeapType*)malloc(sizeof(HeapType));
}

void init(HeapType* h)
{
    h->heap_size = 0;
}

void insert_max_heap(HeapType* h, element item)
{
    int i;
    i = ++(h->heap_size);

    while ((i != 1) && (item.key > h->heap[i / 2].key)) {
        h->heap[i] = h->heap[i / 2];
        i /= 2;
    }
    h->heap[i] = item;
}

element delete_max_heap(HeapType* h)
{
    int parent, child;
    element item, temp;

    item = h->heap[1];
    temp = h->heap[(h->heap_size)--];
    parent = 1;
    child = 2;
    while (child <= h->heap_size) {
        if ((child < h->heap_size) &&
            (h->heap[child].key) < h->heap[child + 1].key)
            child++;
        if (temp.key >= h->heap[child].key) break;
        h->heap[parent] = h->heap[child];
        parent = child;
        child *= 2;
    }
    h->heap[parent] = temp;
    return item;
}

void heap_sort(element a[], int n)
{
    int i;
    HeapType* h;

    h = create();
    init(h);
    for (i = 0; i<n; i++) {
        insert_max_heap(h, a[i]);
    }
    for (i = (n - 1); i >= 0; i--) {
        a[i] = delete_max_heap(h);
    }
    free(h);
}

void random_graph(int Vtx,int Eedhe){

}

int main(void){

    element list[6];

    list[0].key=90;
    strcpy(list[0].bukkit,"좋은 회사 입사하기");

    list[1].key=50;
    strcpy(list[1].bukkit,"세계여행가기");

    list[2].key=70;
    strcpy(list[2].bukkit,"스타트업 창업하기");

    list[3].key=100;
    strcpy(list[3].bukkit,"집사기");

    list[4].key=10;
    strcpy(list[4].bukkit,"책 출간하기");

    list[5].key=40;
    strcpy(list[5].bukkit,"행복하기");

    heap_sort(list,6);

    for(int i=0;i<6;i++){
        printf("%d번째 우선순위는 %d이고 버킷리스트는 %s입니다.\n",i,list[i].key,list[i].bukkit);
    }
    return 0;
    }