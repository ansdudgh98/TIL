#include <stdlib.h>
#include "stdio.h"

typedef int element;
typedef struct DListNode{
    element data;
    struct DListNode* llink;
    struct DListNode* rlink;
}DListNode;

void init(DListNode* phead){
    phead->llink = phead;
    phead->rlink = phead;
}

void print_dlist(DListNode* phead){
    DListNode *p;
    for(p=phead->rlink;p!=phead;p=p->rlink){
        printf("<-| | %d | |-> ",p->data);
    }
    printf("\n");
}
void print_reserve_dlist(DListNode* phead){
    DListNode *p;
    for(p=phead->llink;p!=phead;p=p->llink){
        printf("<-| | %d | |-> ",p->data);
    }
    printf("\n");
}

void dinsert(DListNode *before,element data){
    DListNode *newnode = (DListNode *)malloc(sizeof(DListNode));
    newnode->data = data;
    newnode->llink=before;
    newnode->rlink=before->rlink;
    before->rlink->llink=newnode;
    before->rlink=newnode;
}

int main(void){
    int input,num;
    DListNode* head = (DListNode *) malloc(sizeof(DListNode));
    init(head);
    printf("노드의 개수:");
    scanf("%d",&input);
    for(int i=0;i<input;i++){
        printf("노드 #%d의 데이터를 입력하세요:",i);
        scanf("%d",&num);
        dinsert(head,num);
    }
    printf("입력 데이터 출력 \n");
    print_dlist(head);
    printf("역순 출력 \n");
    print_reserve_dlist(head);

    return 0;
}


