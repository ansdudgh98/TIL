#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	pid_t pid = getpid();
	pid_t ppid = getppid();
	printf("My pid = %d\n",pid);
	printf("My parent's pid = %d\n",ppid);
	
}
