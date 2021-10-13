#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int main(){
	int status;
	pid_t ret;

	ret =fork();

	if(ret == 0){
		exit(6);
	}

	ret = wait(&status);
	printf("pid = %d,status = %d\n",ret,WEXITSTATUS(status));
}


