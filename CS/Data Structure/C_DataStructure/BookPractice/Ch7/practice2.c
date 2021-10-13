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

void dinsert(DListNode *before,element data){
    DListNode *newnode = (DListNode *)malloc(sizeof(DListNode));
    newnode->data = data;
    newnode->llink=before;
    newnode->rlink=before->rlink;
    before->rlink->llink=newnode;
    before->rlink=newnode;
}

DListNode *search(DListNode *head, element data){
    DListNode *s = head;
    for(s=head->llink;s!=head;s=s->llink){
        if(s->data == data) return s;
    }
    return NULL;
}

int main(void){
    int searchnum;
    DListNode* head = (DListNode *) malloc(sizeof(DListNode));
    init(head);
    dinsert(head,3);
    dinsert(head,1);
    dinsert(head,5);
    printf("입력 데이터 출력:\n");
    print_dlist(head);
    printf("탐색할 값:");
    scanf("%d",&searchnum);
    if(search(head,searchnum)!=NULL)
        printf("값이 리스트 안에 있습니다.");
    else
        printf("값이 존재하지 않습니다.");


    return 0;
}


