#include <stdio.h>
#include <stdlib.h>
#define MAX_QUEUE_SIZE 10

typedef int element;

typedef struct
{
   element data[MAX_QUEUE_SIZE];
   int front;
   int rear;
} DequeType;

void error(char *message)
{
   fprintf(stderr, "%s\n", message);
   exit(1);
}

void init(DequeType *q)
{
   q->front = q->rear = 0;
}

int is_empty(DequeType *q)
{
   return (q->front == q->rear);
}

int is_full(DequeType *q)
{
   return ((q->rear + 1) % MAX_QUEUE_SIZE == q->front);
}

void deque_print(DequeType *q)
{
   printf("원형 덱 홀수 - 짝수 = ");
   if(!is_empty(q)) {
      int i = q->front;
      do{
         i=(i+1) % (MAX_QUEUE_SIZE);
         printf("%d  ", q->data[i]);
         if(i == q->rear)
            break;
      } while (i != q->front);
   }
   printf("\n");
}

void add_rear(DequeType *q, element item)
{
   if (is_full(q))
      error("큐가 포화상태입니다.\n");

   q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
   q->data[q->rear] = item;
}

element get_front(DequeType *q)
{
   if (is_empty(q))
      error("큐가 공백상태입니다.\n");
   return q->data[(q->front -1 + MAX_QUEUE_SIZE) % MAX_QUEUE_SIZE];
}

void add_front(DequeType *q, element val)
{
   if (is_full(q))
      error("큐가 포화상태입니다.\n");

   q->data[q->front] = val;   
   q->front = (q->front - 1 + MAX_QUEUE_SIZE) % MAX_QUEUE_SIZE;
}

element delete_front(DequeType *q)
{
   if (is_empty(q))
      error("큐가 공백상태입니다.\n");
   q->front = (q->front + 1) % MAX_QUEUE_SIZE;
   return q->data[q->front];
}

element delete_rear(DequeType *q)
{
   int prev = q->rear;
   if (is_empty(q))
      error("큐가 공백상태입니다.\n");
   q->rear = (q->rear - 1 + MAX_QUEUE_SIZE) % MAX_QUEUE_SIZE;
   return q->data[prev];
}

element get_rear(DequeType *q)
{
   if (is_empty(q))
      error("큐가 공백상태입니다.\n");
   return q->data[q->rear];
}

int main()
{
   DequeType q;
   int element = 0;
   init(&q);
   for(int i =1; i<10;i++){
      if(i%2 ==0){
         add_rear(&q,i);
      }
      else{
         add_front(&q, i);
      }
   }
   deque_print(&q); 

   element = delete_front(&q); 
   printf("   delete_front() --> %d\n", element); 
   element = delete_rear(&q);
   printf("   delete_rear() --> %d\n", element); 
   element = delete_front(&q);
   printf("   delete_front() --> %d\n", element); 

   deque_print(&q); 
   return 0;
}