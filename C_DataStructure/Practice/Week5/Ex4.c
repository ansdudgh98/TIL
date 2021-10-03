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

/*ListNode delete(ListNode *head,ListNode *pre){
    ListNode *removed;
    removed = pre->link;
    pre->link = removed->link;
    free(removed);
    return *head;
}*/

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

void delete_first(ListNode *head){
    ListNode *removed = head->link;
    head ->link = removed->link;
    free(removed);
}

ListNode* select_delete(ListNode *head,element x){
    ListNode *p = head;
    ListNode *d = NULL;
    while(!p==NULL){
        if(p->data == x) {
           head->link = p->link;

            return p;
        }
        p= p->link;
    }

    return NULL;
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

    deleteelement = select_delete(head,input);
    print_list(deleteelement);
    print_list(head);



    return 0;


}
