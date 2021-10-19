#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>

int my_system(const char *cmd){
	int status;
	pid_t pid;
	pid = fork();
	if(pid == -1)
		return -1;
	else if(pid ==0){
		char *argv[4] = {"bash","-c",cmd,NULL};
		execv("/bin/bash",argv);
		exit(-1);	
	}
	if(waitpid (pid,&status,0) == -1)
		return -1;

	else if(WIFEXITED(status))
		return WEXITSTATUS(status);
	return -1;
}

int main(int args,char *argv[])
{
	my_system(argv[1]);	

}
