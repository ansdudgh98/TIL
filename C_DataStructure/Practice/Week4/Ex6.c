//
// Created by 문영호 on 2021/09/27.
//

#include <stdio.h>
#include <stdlib.h>

#define MAX_QUEUE_SIZE 10

typedef int element;
typedef struct {
    element data[MAX_QUEUE_SIZE];
    int front, rear;
} QueueType;

void error(char *message){
    fprintf(stderr,"%s\n",message);
    exit(1);
}

void init_queue(QueueType *q){
    q->front = q->rear = 0;
}

int is_empty(QueueType *q){
    return (q->front == q->rear);
}

int is_full(QueueType *q){
    return ((q->rear+1) %MAX_QUEUE_SIZE==q->front);
}

void dequeue_print(QueueType *q,int count){
    printf("원형큐 deenqueue %d회 [%d] = ",count-1,(q->rear)-(q->front));
    if(!is_empty(q)){
        int i = q->front;
        do{
            i=(i+1) % MAX_QUEUE_SIZE;
            printf("%d ", q->data[i]);
            if(i==q->rear)
                break;
        } while (i != q->front);
    }
    printf("\n");
}

void queue_print(QueueType *q){
    printf("원형큐 enqueue %d회 [%d] = ",MAX_QUEUE_SIZE-1,q->rear);
    if(!is_empty(q)){
        int i = q->front;
        do{
            i=(i+1) % MAX_QUEUE_SIZE;
            printf("%d ", q->data[i]);
            if(i==q->rear)
                break;
        } while (i != q->front);
    }
    printf("\n");
}

void enqueue(QueueType *q,element item){
    if(is_full(q))
        error("큐가 포화상태입니다.");
    q->rear = (q->rear+1) % MAX_QUEUE_SIZE;
    q->data[q->rear] = item;
}

element dequeue(QueueType *q){
    if (is_empty(q))
        error("큐가 공백상태입니다.");
    q->front = (q->front + 1) % MAX_QUEUE_SIZE;
    return q->data[q->front];
}

element peek(QueueType *q){
    if(is_empty(q)){
        error("큐가 공백상태입니다.");
    }
    return q->data[q->front];
}

int main(void){
    QueueType queue;
    int i  =  0 ;
    int z ;
    int element;
    init_queue(&queue);
    while (!is_full(&queue)){
        i++;
        enqueue(&queue,i);
    }
    queue_print(&queue);

    for(z = 0 ;z < 3;z++){
        int element = dequeue(&queue);
        printf("dequeue() —> %d\n", element);
    }

    dequeue_print(&queue,z+1);
    return 0 ;


}