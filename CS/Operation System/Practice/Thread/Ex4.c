#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <pthread.h>

int global_counter;


void *producer(void *arg){
	for(int i=0;i<10000;i++){
		global_counter++;
	}

	return arg;
}

void *consumer(void *arg){
	for(int i=0;i<10000;i++){
		global_counter--;
	}

	return arg;
}

int main(){
	pthread_t producer_tid;
	pthread_t consumer_tid;
	
	int ret;
	ret = pthread_create(&producer_tid,NULL,producer,NULL);
	if(ret!=0)
		perror("Pthread Error");

	ret = pthread_create(&consumer_tid,NULL,consumer,NULL);
	if(ret!=0)
		perror("Pthread Error");


	pthread_join(producer_tid,NULL);
	pthread_join(consumer_tid,NULL);

	printf("Final result = %d\n",global_counter);
	return 0;


}
