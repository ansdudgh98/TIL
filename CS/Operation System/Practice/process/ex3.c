#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	pid_t ret;
	ret = fork();
	if(ret>0){
		printf("I'm the parent.\n");
		printf("(parent) return value = %d\n",ret);
		printf("(Parent) pid = %d\n",getpid());	
	}
	else if(!ret){
		printf("I'm the child.\n");
		printf("(Child) return value = %d\n",ret);
		printf("(Child) pid = %d\n",getpid());
	}
}
