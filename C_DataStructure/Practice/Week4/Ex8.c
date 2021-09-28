//
// Created by 문영호 on 2021/09/27.
//

//
// Created by 문영호 on 2021/09/27.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>


#define MAX_QUEUE_SIZE 5

typedef struct{
    int id;
    int arrival_time;
    int service_time;
}element;

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

void queue_print(QueueType *q){
    printf("QUEUE(front=%d rear=%d) = ", q->front,q->rear);
    if(!is_empty(q)){
        int i = q->front;
        do{
            i=(i+1)% MAX_QUEUE_SIZE;
            printf("%d | ", q->data[i]);
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
    QueueType manqueue;
    QueueType womanqueue;
    element time;
    init_queue(&manqueue);
    init_queue(&womanqueue);
    int usertime;
    double divtime;
    int counttime = 0;
    int waittime;
    printf("시뮬레이션 할 최대 시간(예:20)=");
    scanf("%d",&usertime);
    printf("단위시간에 도착하는 고객 수(예:0.3)=");
    scanf("%d",&divtime);
    while(counttime<=usertime){
        printf("[ %d]",counttime);
        sleep(10);

        counttime++;
    }

    return 0;
}