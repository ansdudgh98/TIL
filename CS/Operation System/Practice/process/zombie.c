#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	pid_t ret;
	char buf;

	ret=fork();

	if(ret>0){
		printf("I'm the parent.\n");
		sleep(3);
	}
	else if(!ret){
		printf("I'm the child\n");
		ret = fork();
		if(!ret){
			sleep(0.5);
			execl("/bin/ps","ps",NULL);
		}
		printf("END of the Child.\n");
	}

}
