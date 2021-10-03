//
// Created by 문영호 on 2021/09/29.
//

#include <stdlib.h>
#include <string.h>
#include "stdio.h"

typedef int element;

typedef struct ListNode{
    element data;
    struct ListNode *link;
}ListNode;

ListNode* insert_first(ListNode *head,element value){
    ListNode *p = (ListNode *)malloc(sizeof (ListNode));
    p->data = value;
    p->link = head;
    head = p;
    return head;
}

void print_list(ListNode *head){
    for(ListNode *p= head;p!=NULL;p=p->link){
        printf("%d->",p->data);

    }
    printf("NULL\n");
}

int sum(ListNode *head){
    int result = 0;

    for(ListNode *p= head;p!=NULL;p=p->link){
        result += p->data;
    }

    return result;
}

int main(void){
    ListNode *head = NULL;
    element data;

    int input;
    printf("노드의 갯수:");
    scanf("%d",&input);

    for(int i=0;i<input;i++){
        int data;
        printf("노드 #%d의 데이터:",i+1);
        scanf("%d",&data);
        head = insert_first(head,data);
    }



    print_list(head);

    int result = sum(head);

    printf("연결리스트의 데이터 합:%d",result);

    return 0;


}
