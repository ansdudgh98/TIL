//
// Created by 문영호 on 2021/09/29.
//

#include <stdlib.h>
#include <string.h>
#include "stdio.h"

typedef struct {
    char name[100];
    int sugarcontent;
}fruit;


typedef struct ListNode{
    fruit data;
    struct ListNode *link;
}ListNode;

ListNode* insert_first(ListNode *head,fruit data){
    ListNode *p = (ListNode *)malloc(sizeof (ListNode));
    p->data = data;
    p->link = head;
    head = p;
    return head;
}

void print_list(ListNode *head){
    for(ListNode *p= head;p!=NULL;p=p->link){
        printf("%s(%d)->",p->data.name,p->data.sugarcontent);
    }
    printf("NULL\n");
}

fruit MAX_SugarContent(ListNode *head){

    fruit MAX_fruit;
    strcpy(MAX_fruit.name,head->data.name);
    MAX_fruit.sugarcontent = head->data.sugarcontent;

    for(ListNode *p= head;p!=NULL;p=p->link){
        if(MAX_fruit.sugarcontent < p->data.sugarcontent) {
            MAX_fruit.sugarcontent = p->data.sugarcontent;
            strcpy(MAX_fruit.name,p->data.name);
        }
    }

    return MAX_fruit;

}


int main(void){
    ListNode *head = NULL;
    fruit data;

    strcpy(data.name,"APPLE");
    data.sugarcontent=10;
    head = insert_first(head,data);
    print_list(head);

    strcpy(data.name,"KIWI");
    data.sugarcontent=14;
    head = insert_first(head,data);
    print_list(head);

    strcpy(data.name,"BANANA");
    data.sugarcontent=16;
    head = insert_first(head,data);
    print_list(head);

    strcpy(data.name,"ORANGE");
    data.sugarcontent=8;
    head = insert_first(head,data);
    print_list(head);

    strcpy(data.name,"GRAPE");
    data.sugarcontent=15;
    head = insert_first(head,data);
    print_list(head);

    fruit MAX_data;
    MAX_data = MAX_SugarContent(head);
    printf("현재 최대값을 가진 과일은 %s이며 표준 당도는 %d입니다.",MAX_data.name,MAX_data.sugarcontent);

    return 0;


}
