//
// Created by 문영호 on 2021/10/03.
//

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


void print_list(ListNode *head){
    for(ListNode *p= head;p!=NULL;p=p->link){
        printf("%d->",p->data);

    }
    printf("NULL\n");
}

ListNode* insert_first(ListNode *head,element value){
    ListNode *p = (ListNode *)malloc(sizeof (ListNode));
    p->data = value;
    p->link = head;
    head = p;
    return head;
}


void select_delete(ListNode *head,element x){

   ListNode *p = head;
   ListNode *d = head;
   d = d->link;
   while(!d==NULL){
       if((d->data)==x){
           p->link = d->link;
           free(d);
           break;
       }
       p = d;
       d=d->link;
   }

    }




int main(void){
    ListNode *head = NULL;
    element data;
    ListNode *deleteelement=NULL;
    int input;
    printf("노드의 갯수:");
    scanf("%d",&input);

    for(int i=0;i<input;i++){
        int data;
        printf("노드 #%d의 데이터:",i);
        scanf("%d",&data);
        head = insert_first(head,data);
    }
    print_list(head);

    printf("삭제할 값을 입력하세요:");
    scanf("%d",&input);

    select_delete(head,input);
    print_list(head);



    return 0;


}
