#include <iostream>
#include <ctime>
#define N 5 // 5 행
#define M 5 // 5 열
using namespace std;
bool check_tile(const int tile[][M]);
// tile이 전부 1인지
검사
void move_dir(int dir);
// 움직여야 하는 방향
으로 i, j 값을 변경
bool check_move(int tile[][M], int dir);
// tile 밖으로 움직이는지 안 움직이는지 확인
inline void move(int tile[][M]);
// tile을 1로 채움
void print(const int tile[][M]);
// tile 출력
int i = N / 2, j = M / 2;
// i : 행, j : 열 / 가
운데부터 시작하기 위해 선언과 동시에 초기화
int main(void) {
    int tile[N][M] = {
            0
    }
    ;
    // 배열 전부 0으로 초기화
    int count = 0, direction;
    // count : 횟수, direction : 이동하는
    방향
    bool check = false, possible;
    // check : tile이 모두 1인지 확인, possible :
    이동하는 방향으로 이동을 할 수 있나 없나 확인
    clock_t start_t, end_t;
    // start_t : 시작 시간, end_t : 종료
    시간
            srand((unsigned)time(NULL));
    tile[i][j] = 1;
    // tile 가운데 시작
    start_t = clock();
    // 시작 시간
    while (1) {
        direction = rand() % 8;
        // 0 ~ 7 랜덤
        possible = check_move(tile, direction);
        // tile 외로 나가는지 확인
        if (possible == true) // 이동할 수 있으면 {
            move_dir(direction);
        // 이동 하는 방향으로 i, j 값
        변경
                move(tile);
        // 이동
        count++;
        // 횟수 증가
        check = check_tile(tile);
        // tile 확인
        print(tile);
        // tile 출력
        cout << endl;
        // 배열을 보기 좋게
        줄바꿈해준다.
        if (check == true) // tile이 전부 1이면
            printf("%d",count);
            break;
        break;
    }
}
end_t = clock();
// 종료 시간
cout << count << "번만에 성공\n";
// 횟수 출력
cout << "수행시간 : " << double(end_t - start_t) / CLOCKS_PER_SEC << "초"
<< endl;
// long 형인 end_t - start_t를 double형으로 변환해주고
CLOCKS_PER_SEC(1000)로 나누어준다. // 만약에 형변환을 해주지 않으면 (정수 / 정수) 이기 때문에 정수가 출력이된다. 즉, 소수점 이하는 출력이 되지 않는다.
return 0;
}
bool check_tile(const int tile[][M]) // tile이 전부 1인지 검사 {
for (int i = 0; i < N; i++) // i는 0부터 시작이니 N-1 까지한다. {
for (int j = 0; j < M; j++) // j는 0부터 시작이니 M-1 까지한다. {
if (tile[i][j] == 0) // 반복 중 tile[i][j]가 하나라도 0이면
false {
return false;
}
}
}
return true;
//전부 1이면 true
}
bool check_move(int tile[][M], int dir) // tile 밖으로 움직이는지 안 움직이는지 확인 {
if (j == 0) // j가 0인 경우 {
if (dir == 5 || dir == 6 || dir == 7) return false;
// 왼쪽 방향으로는 가
지 못 한다.
} else if (j == M - 1) // j가 M-1(4)인 경우 {
if (dir == 1 || dir == 2 || dir == 3) return false;
// 오른쪽 방향으로는
가지 못 한다.
}
if (i == 0) // i가 0인 경우 {
if (dir == 0 || dir == 1 || dir == 7) return false;
// 윗쪽 방향으로는
가지 못 한다.
} else if (i == N - 1) // i가 N-1(4)인 경우 {
if (dir == 3 || dir == 4 || dir == 5) return false;
// 아래쪽 방향으로는
가지 못 한다.
}
return true;
// 위 상황이 아니면 갈 수 있다.
}
void move_dir(int dir) // 움직여야 하는 방향으로 i, j 값을 변경 {
switch (dir) // dir 가 {
case 0: // 0 인 경우 i의 값 -1
i--;
break;
case 1: // 1 인 경우 i의 값 -1, j 값 +1
i--;
j++;
break;
case 2: // 2 인 경우 j의 값 +1
j++;
break;
case 3: // 3 인 경우 i의 값 +1, j 값 +1
i++;
j++;
break;
case 4: // 4 인 경우 i의 값 +1
i++;
break;
case 5: // 5 인 경우 i의 값 +1, j 값 -1
i++;
j--;
break;
case 6: // 6 인 경우 j의 값 -1
j--;
break;
case 7: // 7 인 경우 i의 값 -1, j 값 -1
i--;
j--;
break;
}
}
inline void move(int tile[][M]) // tile을 1로 채움 {
tile[i][j] = 1;
// 이동된 i, j 위치의 tile 값을 1로 변경
}
void print(const int tile[][M]) // tile 출력 {
for (int i = 0; i < N; i++) // i는 0부터 시작이니 N-1 까지한다. {
for (int j = 0; j < M; j++) // j는 0부터 시작이니 M-1 까지한다. {
cout << tile[i][j] << " ";
// 출력을 해준다.
}
cout << endl;
}
}