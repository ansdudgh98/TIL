#include <stdlib.h>
#include <time.h>
#include "stdio.h"

int main(){

    int playernum;
    int trade;
    srand(time(NULL));
    printf("플레이어 수를 입력 해 주세요:");
    scanf("%d",&playernum);
    while((playernum<=15&&playernum>=5)!=1){
        printf("플레이어 수를 5~15사이로 입력해주세요.");
        scanf("%d",&playernum);
    }
    printf("트레이드 수를 입력 해 주세요:");
    scanf("%d",&trade);
    while((trade<=playernum&&trade>=1)!=1){
        printf("트레이드 수를 1 ~ %d 사이로 입력해주세요.",playernum);
        scanf("%d",&trade);
    }


    int myteam[playernum];
    int rivalteam[playernum];
    double beforeavg ;
    double afteravg;

    for(int i=0;i<playernum;i++){
        myteam[i]= rand() % (100-70) + 70;
        rivalteam[i]= rand() % (100-70) + 70;
    }

    printf("%d명 %d번의 기회\n",playernum,trade);
    printf("우리팀 선수 전적:");
    int sum=0;
    for(int i=0;i<playernum;i++){
        printf(" %d ",myteam[i]);
        sum += myteam[i];
    }
    beforeavg = sum / playernum;
    printf("\n");
    printf("상대팀 선수 전적:");
    for(int i=0;i<playernum;i++){
        printf(" %d ",rivalteam[i]);
    }
    printf("\n");
    printf("====트레이드 진행=====");
    printf("\n");
    for(int i=0;i<trade;i++){
        int randint=rand()%playernum;
        int temp = myteam[randint];
        myteam[randint]=rivalteam[randint];
        rivalteam[randint]=temp;
    }
    printf("\n");
    printf("교환후 성적:");
    sum=0;
    for(int i=0;i<playernum;i++){
        printf(" %d ",myteam[i]);
        sum += myteam[i];
    }
    afteravg = sum/playernum;
    printf("\n");
    printf("성적 평균 변화: %lf --- > %lf",beforeavg,afteravg);

    printf("\n");
}