#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
	pid_t pid;
	pid = fork();

	if(pid<0){
		fprintf(stderr,"Fork Failed");
		return 1;
	}
	else if(pid==0){
		execlp("/bin/ls","ls",NULL);
		printf("Child Procss exec");	
}
	else{
		wait(NULL);
		printf("parent's wait");
		printf("Child Complete");
	}
	return 0;
}
