#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <pthread.h>

#define NUMBER_OF_DINNING_ROOM 3
#define NUMBER_OF_GUEST 20

int dining_room[3];
int empty_dining_room_count = NUMBER_OF_DINNING_ROOM;

void *guest(void *arg){
	int guest_number = *(int *)arg;
	int selected_dining_room = -1;

	while(empty_dining_room_count==0);
	empty_dining_room_count--;
	for(int j=0;j<NUMBER_OF_DINNING_ROOM;j++){
		if(dining_room[j] == -1)
			selected_dining_room = j;
			break;
	}

	dining_room[selected_dining_room] = guest_number;
	printf("Guest %d is using dining room %d\n",guest_number,selected_dining_room);
	sleep(0.5);
	printf("Guset %d is done eating in dining room %d\n",guest_number,selected_dining_room);
	dining_room[selected_dining_room] = -1;
	empty_dining_room_count++;
	return arg;	
	}
int main(){
 	pthread_t guest_tid[NUMBER_OF_GUEST];

	int guest_number[NUMBER_OF_GUEST];

	for(int i=0;i<NUMBER_OF_GUEST;i++){
	int ret;
	guest_number[i] = i;
	ret = pthread_create(&guest_tid[i],NULL,guest,&guest_number[i]);
	if(ret != 0)
		perror("Pthread error");
	}
	
	for(int i=0;i<NUMBER_OF_GUEST;i++)
		pthread_join(guest_tid[i],NULL);
	return 0;
}

