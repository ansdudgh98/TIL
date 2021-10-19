#include <unistd.h>
#include <stdlib.h>
int main(){
	char *const args[] = {"example2",NULL,NULL};
	int ret;

	ret = execv("hello1",args);
	if(ret==-1)
		perror("Error:execv");
	
}
