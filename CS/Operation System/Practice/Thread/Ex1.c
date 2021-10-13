#include <stdio.h>
#include <pthread.h>

void *start_routine(void * message){
	printf("NEW Thread : %s\n",(const char *)message);
	return message;
}

int main(){
	pthread_t tid1,tid2;
	const char *message1 = "Hello World 1";
	const char *message2 = "Hello World 2";
	
	int ret;
	ret = pthread_create(&tid1,NULL,start_routine,(void *)message1);
	if(ret != 0 )
		perror("Pthread error");
		
	ret = pthread_create(&tid2,NULL,start_routine,(void *)message2);
	if(ret != 0 )
		perror("Pthread error");

	pthread_join(tid1,NULL);
	pthread_join(tid2,NULL);

	return 0;

}
