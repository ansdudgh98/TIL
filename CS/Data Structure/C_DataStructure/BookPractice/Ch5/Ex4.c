//
// Created by 문영호 on 2021/09/27.
//
#include <stdlib.h>
#include <stdio.h>
#define MAX_QUEUE_SIZE 5

typedef int element;
typedef struct {
    element data[MAX_QUEUE_SIZE];
    int front,rear;
} DequeueType;

void error(char *message){
    fprintf(stderr,"%s\n",message);
    exit(1);
}

void init_dequeue(DequeueType *q){
    q->front = q->rear = 0;
}

int is_empty(DequeueType *q){
    return (q->front == q->rear);
}

int is_full(DequeueType *q){
    return ((q->rear+1) % MAX_QUEUE_SIZE == q->front);
}

void deque_print(DequeueType *q){
    printf("DEQUE(front=%d rear=%d) = ",q->front,q->rear);
    if(!is_empty(q)){
        int i = q->front;
        do{
            i=(i+1) % (MAX_QUEUE_SIZE);
            printf("%d | ", q->data[i]);
            if(i==q->rear)
                break;
        } while (i != q->front);
    }
    printf("\n");
}

void add_rear(DequeueType *q,element item){
    if(is_full(q))
        error("큐는 포화상태입니다.");
    q->rear = (q->rear+1) % MAX_QUEUE_SIZE;
    q->data[q->rear] = item;
}

element delete_front(DequeueType *q){
    if(is_empty(q))
        error("큐가 공백상태입니다.");
    q->front = (q->front + 1) % MAX_QUEUE_SIZE;
    return q->data[q->front];
}

element get_front(DequeueType *q){
    if(is_empty(q))
        error("큐가 공백상태입니다.");
    return q->data[(q->front+1) % MAX_QUEUE_SIZE];
}

void add_front(DequeueType *q, element val){
    if(is_full(q))
        error("큐가 포화 상태 입니다.");
    q->data[q->front] = val;
    q->front = (q->front - 1 + MAX_QUEUE_SIZE) & MAX_QUEUE_SIZE;
}

element delete_rear(DequeueType *q){
    int prev = q->rear;
    if(is_empty(q))
        error("큐가 공백 상태 입니다.");
    q->rear = (q->rear -1 + MAX_QUEUE_SIZE) % MAX_QUEUE_SIZE;
    return q->data[prev];
}

element get_rear(DequeueType *q){
    if(is_empty(q))
        error("큐가 공백 상태 입니다.");
    return q->data[q->rear];
}

int main(void){
    DequeueType queue;

    init_dequeue(&queue);

    for(int i = 0; i<3 ;i++){
        add_front(&queue,i);
        deque_print(&queue);
    }

    for(int i = 0 ; i< 3 ; i++){
        delete_rear(&queue);
        deque_print(&queue);
    }
    return 0;


}

