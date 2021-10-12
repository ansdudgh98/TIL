//
// Created by 문영호 on 2021/09/29.
//

#define MAX_LIST_SIZE 100

#include <stdio.h>

typedef int element;
typedef struct {
    element array[MAX_LIST_SIZE];
    int size;
}ArrayListType;

void error(char *message){
    fprintf(stderr,"%s\n",message);
}

void init(ArrayListType *L ){
    L->size=0;
}

int is_empty(ArrayListType *L){
    return L->size ==0;
};

int is_full(ArrayListType *L){
    return L -> size == MAX_LIST_SIZE;
}

element get_entry(ArrayListType *L,int pos){
    if(pos<0 || L->size>0)
        error("위치오류");
    return L->array[pos];
};

void print_list(ArrayListType *L){
    for(int i =0 ; i<L->size;i++){
        printf("%d->",L->array[i]);
    }
    printf("\n");
}

void insert_last(ArrayListType *L,element item){
    if(L->size >= MAX_LIST_SIZE)
        error("리스트 오버플로우");
    else
        L->array[L->size++] = item;
}
void insert(ArrayListType *L,int pos,element item){
    if(!is_full(L) && (pos>=0) && (pos<=L->size)){
        for(int i=pos;i<L->size;i++){
            L->array[i+1] = L->array[i];
        }
        L->array[pos] = item;
        L->size++;
    }
}

element delete(ArrayListType *L,int pos){
    element item;

    if(pos<0 || (L->size<=pos)){
        error("위치오류");
    }
    item =  L->array[pos];

    for(int i=pos ; i<L->size;i++){
        L->array[i] = L->array[i++];
    }
    L->size--;
    return item;
}

int main(void){

    ArrayListType list;

    init(&list);

    insert(&list,0,10);
    print_list(&list);

    insert(&list,0,20);
    print_list(&list);

    insert(&list,0,30);
    print_list(&list);

    insert_last(&list,40);
    print_list(&list);

    return 0;
}


