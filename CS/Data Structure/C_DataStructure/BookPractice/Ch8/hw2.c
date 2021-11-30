#include <stdlib.h>
#include <strings.h>
#include "stdio.h"
#define MAX_SINGER_SIZE	 100
#define MAX_SONG_SIZE 200
typedef struct {
    char singer_name[MAX_SINGER_SIZE];
    char song[MAX_SONG_SIZE];
} element;

typedef struct TreeNode {
    element key;
    struct TreeNode *left, *right;
} TreeNode;

int compare(element e1, element e2)
{
    return strcmp(e1.song, e2.song);
}

void inorder_song(TreeNode *root,char *input){
    if(root!=NULL){
        inorder_song(root->left,input);
        if(strcmp(root->key.singer_name,input)==0){
            printf("%s",root->key.song);
        }
        printf("\n");
        inorder_song(root->right,input);
    }
}

void inorder_name(TreeNode *root,char *input){
    if(root!=NULL){
        inorder_name(root->left,input);
        if(strcmp(root->key.song,input)==0){
            printf("%s",root->key.singer_name);
        }
        printf("\n");
        inorder_name(root->right,input);
    }
}


void program_print(){
    printf("노래방 관리 프로그램\n");
    printf("\n");
    printf("1.노래 추가\n");
    printf("2.노래 검색\n");
    printf("0.종료\n");
    printf("메뉴 번호 선택>");
}

TreeNode * new_node(element item)
{
    TreeNode * temp = (TreeNode *)malloc(sizeof(TreeNode));
    temp->key = item;
    temp->left = temp->right = NULL;
    return temp;
}
TreeNode * insert_node(TreeNode * node, element key)
{
    if (node == NULL) return new_node(key);

    if (compare(key, node->key)<0)
        node->left = insert_node(node->left, key);
    else if (compare(key, node->key)>0)
        node->right = insert_node(node->right, key);

    return node;
}

void display(TreeNode * p)
{
    if (p != NULL) {
        printf("(");
        display(p->left);
        printf("%s:%s", p->key.song, p->key.singer_name);
        display(p->right);
        printf(")");
    }
}

int main(void){
    char command;

    element e;

    TreeNode * root = NULL;
    TreeNode * tmp;
    char re_command;

    do{
        char input[100];
        program_print();
        command = getchar();
        getchar();
        switch (command) {
            case '1':
                printf("가수 이름:");
                gets(e.singer_name);

                printf("노래이름:");
                gets(e.song);
                root= insert_node(root,e);
                break;
            case '2':
                printf("노래 검색");
                printf("\n");
                printf("\n");
                printf("1.가수이름으로 검색");
                printf("\n");
                printf("2.노래이름으로 검색");
                printf("\n");
                printf("0.이전 메뉴로 이동");
                printf("\n");
                printf("메뉴 번호 선택>");
                re_command = getchar();
                getchar();
                switch (re_command) {
                    case '1':
                        printf("가수이름:");
                        gets(input);
                        inorder_song(root,input);
                        break;
                    case '2':
                        printf("노래제목:");
                        gets(input);
                        inorder_name(root,input);
                        break;
                    case '0':
                        break;
                }
                break;

        }

    }while(command !='0' );
    display(root);
}