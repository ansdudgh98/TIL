//
// Created by 문영호 on 2021/09/29.
//


//
// Created by 문영호 on 2021/09/29.
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

ListNode* insert_first(ListNode *head,element value){
    ListNode *p = (ListNode *)malloc(sizeof (ListNode));
    p->data = value;
    p->link = head;
    head = p;
    return head;
}

ListNode* insert(ListNode *head,ListNode *pre,element value){
    ListNode *p = (ListNode *) malloc(sizeof (ListNode));
    p->data=value;
    p->link = pre->link;
    pre->link = p;
    return head;
}

ListNode* delete_first(ListNode *head){
    ListNode *removed;
    if(head==NULL) return NULL;
    removed = head;
    head = removed->link;
    free(removed);
    return head;

}

ListNode delete(ListNode *head,ListNode *pre){
    ListNode *removed;
    removed = pre->link;
    pre->link = removed->link;
    free(removed);
    return *head;
}

void print_list(ListNode *head){
    for(ListNode *p= head;p!=NULL;p=p->link){
        printf("%d->",p->data);

    }
    printf("NULL\n");
}

ListNode* reverse(ListNode *head){
    ListNode *p,*q,*r;

    p = head;
    q = NULL;
    while(p!=NULL){
        r=q;
        q=p;
        p=p->link;
        q->link = r;
    }

}

int main(void){
    ListNode *head1 = NULL;
    ListNode *head2 = NULL;

    head1 = insert_first(head1,10);
    head1 = insert_first(head1,20);
    head1 = insert_first(head1,30);
    print_list(head1);

    head2 = reverse(head1);
    print_list(head2);

    return 0;


}

