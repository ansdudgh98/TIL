# CPU Scheduling

------

-CPU Scheduling
- 멀티 프로그래밍의 기초
- CPU 프로세스 사이에 Switching으로 인해 OS는 컴퓨터를 더욱 생산성있게 만들수있다.

-Process scheduling vs Thread Scheduling
- 현대의 OS에서는 커널레벨 쓰레드는 스케줄링의 단위이다.
- Process scheduling과 Thread Scheduling은 교체 할수있다.

-Basic Concepts
- 멀티 프로그래밍과 함께 CPU의 이용률을 최대화 한다.
- 하나의 코어만 그 시간에 실행될수있다.

-CPU-I/O burst cycle
- 프로세스 실행은 CPU execution 과 I/O wait의 사이클에 의해 실행된다.

-CPU burst
- 프로세스가 프로세스를 사용한 총 시간

-I/O burst
- 프로세스가 I/O를 위해 대기한 총 시간

-프로세스들은 CPU burst와 I/O burst 사이를 번갈아 사용한다.

-Clock pulse 

- 주기적인 하락과 상승을 가진 전기적 신호

-Clock Cycle

- 펄스의 총양의 단위
- 대개적으로 높은 클럭 사이클 타임은 빠른 CPU를 의미한다.

-clock cycle time(sec) = 1/Clock frequency(HZ)

-CPU Scheduler
- CPU가 idle이 된 떄에는,OS는 레디큐에서 준비가 된 프로세스들을 선택한다.

-프로세스가 수행될시 CPU 스케줄링을 결정할수있다.
- running state -> waiting state
- running state -> ready state
- running state -> ready state


-선점 스케줄링
- 프로세스는 실행중간에 빼앗 길 수도 있다.
- 가상의 모든 현대 운영체제(윈도우,맥,리눅스,유닉스)는 선점 스케줄링 알고리즘을 사용한다.

-비선점 스케줄링
- 프로세스는 CPU가 풀리기 전까지 가져갈수없다.
- CPU가 프로세스에 할당의 되어지면,프로세스는 CPU를 terminating에 의해 풀리기 전이나 watiting state로 바뀌기 전까지 유지한다.

-디스패처
- 디스패처 모둘은 CPU스케줄러에 의해 선택되는 프로세서로 CPU의 제어건을 준다. 이것은 아래와 같은 항목을 포함한다.
- Switching Context
- Switching to user mode
  - Jumping to the proper location

◻Dispatch latency
- 하나의 프로세스를 멈추거나 다른것의 재생을 시작하는 디스패처를 가져가는 동안의 시간이다.

-스케줄링의 기준

◻ CPU utilization

- 가능한 CPU를 바쁘게 유지한다.

◻ Throughput

- 프로세들의 실행이 안롸되는 단위시간

◻ Turnaround time

- 하나의 프로세스가 규칙적으로 실행되는 시간

◻ Waiting time

- 하나의 프로세스가 레디큐에서 기다리는 시간 

◻ Response time

- 응답이 처음 요청이 생성되어지고 나서 제출될때 까지 걸리는 시간

-우리는 오직 CPU burst와 평균 대기시간만 고려한다.

-Scheduling Algorithm

◻ First-Come, First-served(FCFS)

◻Shortest-Job-First(SJF)

- 프로서스간의 연관된 다음 CPU Burst의 길이
- SJF 는 프로세스에게 설정되어진 최소 평균 대기시간이 최우선을 준다.
- 어떻게 다음 CPU burst의 길이를 우리는 결정할까?
  - 유저에게 믈어보거나,평가한다.

-Prediction of Next CPU Burst

- 프로세스는 이전의 CPU Bursts에 근거하여 다음 CPU Burst를 예측한다.

-Shortest Remaing Time Frist

- SJF의 선점 버전이다.
- 프로세스가 레디큐에 도착하였을 때,스케줄링은 SJF를 사용하여 다시 한다.

-Round Robin(RR)

- 타임 슬라이스와 함께 하는 FCFS의 선점버전
- 각각의 프로세스는 작은 CPU 시간 단위를 얻는다.(time quantum q)
  - 시간이 지난 후 , 프로세스는 선점되어지고 레디큐의 끝에 추가가 되어진다.
  - q는 보통 10~100밀리세컨드를 가진다.
  
- 만약 n이 프로세스 안의 레디큐에 있으면
  - 각각의 프로세스는 대부분의 첫번째의 단위시간 덩어리의 CPU 시간을 1/n을 가진다. 
  - 프로세스는 (n-1)q 시간만큼보다 기다려주지 않는다.  

- q is large -> FCFS
- q is small -> context switiching overhead is high


-Priority Scheduling

- CPU는 가장 높은 우선 순위와 함께 프로세스에 할당 되어진다.
  - 우선 순위 숫자(INTEGER)는 프로세스들 간에 할당 된다.
  - 보통은 작은 숫자 = 높은 우선 순위
  - SJF는 우선순의 스케줄링의 특별한 버전이다.

-Priority 

- 내부 정보(시간제한,메모리 요구,열리는 파일)
- 외부 정보(프로세스의 중요도,비용,정책)

-Starvation

- 무기한 블로킹
- 우선순위 스케줄링은 유한한 대기동안 몇몇의 낮은 우선순위 프로세스들은 떠날수있다.

-Aging
- 기아의 문제 해결책
- 점진적으로 프로세스의 우선순위를 높여주는 것이다.

-Combing RR and Priority Scheduling
- 높은 순위의 프로세스를 실행한다.
- RR을 사용한 같은순위와 함께 프로세스를 실행한다.

-Multilevel Queue
- 레디큐는 멀티규로 구성되어있다.
- 우선순위 스케줄링에서 각각의 우선순위는 분리된 규를 가진다.

-Multilevel Feedback Queue

- 프로세스는 여러 큐 사이에서 움직인다.
- 멀티레벨 피드백 큐 스케줄러는 아래와 같은 파라미터에 의해 정의돤다.
- 몇개의 큐
  - 각각의 큐의 스케줄링 알고리즘
  - 프로세스가 업그레이드 될때 결정되는 방식
  - 프로세스가 강등될때 결정되는 방식
  - 프로세스의 큐가 프로세스에 필요한 서비스에 들어갈 때 결정되는 방식
- Aging은 멀티레벨 feedback queue를 사용하여 수행 되어질수있다.

-Multiple-Processor Scheduling
- MultiCore CPus
- MultiThreaded cores
- NUMA systems
- Heterogeneous multiprocessing

-Approaches to Multiple-Processor Scheduling
- 공유 데이터를 사용하는 두개의 프로세서의 경우
  - Symmetric multiprocessing(SMP)는 각가 프로세스가 자신이 스케줄링 된다.
  - 모든 쓰레드는 공통의 레디큐에(common ready queue)서 수행된다.
  - 각각의 프로세스는 자신 개인의 쓰레드 큐를 가지게 된다.(per core run queues)
  
-Simulaneous Multithreading(SMT)
- 캐쉬는 스케줄링을 위해 고려되어져야만 한다.
- 하드웨어 쓰레드가 소개되어진다(HyperThreading in Intel)

-Heterogeneous MultiProcessing
- 같은 명령어 셋이지만,클럭스피드나 파워가 각각 다르다.
- 중요코어에서 등록된 task에 의해 파워 소비 관리를 더욱 더 좋게 해준다 특정하게 요구되는 태스크에 의해서

-Real Time CPU Scheduling
- Real-Time CPU Scheduling
  - soft real-time Systems
    -치명적인 real-time tasks들은 높은 우선순위를 가지나,이 task가 언제 수행되어질지는 보장되어지지않는다.
  
  - Hard real-time systems
    -Task는 무조건 데드라인에 의해 수행되어야만한다.
- Event Latency
  - 이벤트 발생과,서비스간 사이의 시간


-Types of latencies
- 인터럽트 latency
  - 인터럽트가 시작되는 과정에서 부터 인터럽트 서비스되는 시간까지의 도착시간  
- Dispatch latency
  - 스케줄되고난뒤 종료되고 현재의 프로세스가 종료되고 CPU와 또다른 것을 바꾸는 시간

-Priority-based Scheduling
 - 리얼타임 스케줄링에서 스케줄러는 우선순위를 지원해야만 하고,우선순위를 기반으로한 스케줄링을 해야한다.
 - 하드타임 리얼 시스템에서는 데드라인에서 만나게 되는 능력을 무조건 제공한다.
 - Rate Monotonic Scheduling
 - Missed Deadlines With Rate Monotonic Scheduling
 - Earlist Deadline First Scheduling(EDF)



