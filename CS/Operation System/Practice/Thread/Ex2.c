#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <pthread.h>

void *start_routine(void * thread_order){
	printf("New Thread (pid:%d,tid%ld):Thread order %d \n",getpid(),pthread_self(),*(int *)thread_order);
	return thread_order;
}

int main(){
	pthread_t tid[10];
	int thread_order[10] = {0,};

	for(int i=0;i<10;i++){
	int ret;
	thread_order[i]=i;
	ret = pthread_create(&tid[i],NULL,start_routine,&thread_order[i]);
	if(ret!=0){
		perror("Pthread error");	
	}
	}

	for(int i=0;i<10;i++){
		pthread_join(tid[i],NULL);
	}

	return 0;
	
}
