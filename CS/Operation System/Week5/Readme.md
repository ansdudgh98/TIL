#Synchronization

-------

-Data Inconsistency

- Cooperation Process
  - 다른 프로세스(데이터와 코드를 공유할수있는)에 의해 영향을 주거나 영향을 받을수있다.
  - 공유데이터에 동시에 접근하는 것은 데이터 불일치를 초래할수있다.,
  - 데이터 일관성을 유지하는 것은 협력 프로세스의 순차적인 실행이 보장되는 기법이 요구된다.

-Race Condition
- 몇몇의 프로세스들은 경쟁적으로 같은 데이터를 접근할수 있고 그리고 실행의 결과는 
발생되어지는 접근 규칙적인 순서에 의존한다.
- Synchronization이 필요하다.
  - race condition에 반대하는 것을 보호하기위해,오직 하나의 프로세스가 동시에 공유데이터를 수정할수있다.
- 멀티코어 시스템에서 중요함이 증가한다.
  - 멀티쓰레드 앱은 다른 프로세스 코어에서 병렬적으로 수행이된다.
- OS는 많은 커널모드 프로세스들이 실행되기때문에 몇몇의 경쟁상태를 받아야한다.

-Producer-Consumer
- Producer은 정보를 생산하고
- Consumer은 정볼르 소비한다.

-Bounded-buffer
- 고정된 버퍼 사이즈가 있다.
- 생산자는 모든 버퍼가 꽉 채워졌을떄는 기다려야만 한다.
- 소비자는 만약 소비하는 버퍼가 없을 경우 기다린다.

-Critical Section
- 프로세스가 공유데이터에 접근하거나 수정하는 코드 segment이다.
- 각각의 프로세스는 코드의  critical section segment를 가지고있다,.
  - 프로세스가 공통의 변수를 바꿀때,테이블을 업그레이드 할때,파일을 수정할때
  - 하나의 프로세스가 critical section에 들어 갈때, 다른 것은 critical section안에 있을수없다.
- Critical section문제는 이것을 해결하는 프로토콜에 의해 디자인 된다.
- 각각의 프로세스는 entry section안에서 critical section에 들어가도 되는지 권한을 물어보고
,exit section으로 들어가게 되면 그때 remainder Section이다.

-Requirements for criticla section problem
- nonzero Speed에서 각각의 프로세스의 실행을 추정한다.
- n processes에서 상대적인 속도에 관한 추정이 없다.(No assumption concerning relative speed of the n processes )

- Mutual exclusion
  - 만약 P(i) 프로세스가 critical section에서 실행되고있을때,그때 다른 프로세스 들은 그들의 critical section안에서 실행이 되어질수 없다.

- Progress
  - 만약 프로세스가 critical section안에서 실행이 되어지지않고, critical section에 들어가고 싶어하는 것이 존재할때 ,다음에 critical section에 들어갈 프로세스를 선택하는것은 
무기한으로 연장할수없다.
  - deadlock과 livelock을 피한다.
  
-Bounding waiting
- bound는 다른 프로세스들이 프로세스가 criticla section에 들어가는 요청을 만들고 난 후와 이 요청이 보장 되어지기 전에 그들의 critical sction으로 들어가는 것을 허락하기 위한 일정 시간을 존재하게 해야만 한다. 
- starvation probloem을 회피하기 위해서

-Solution to Criticla Section Problem
- Single core environment
  - 공유데이터가 수정되어지는 동안 인터럽트의 발생을 방어한다.

- Multicore environment
  - Nonpreemtive kernel
    - 커널모드,block,CPU의 자발적인 양보가 존재할때까지 실행한다.
    - 근본적으로 커널보드안에서의 race contions의 자유이다,.
  
  - Preemptive Kernel
    - 커널모드에서 실행이 되고있을 때 프로세스의 선점을 허락한다.

-Peterson's Solution
- 문제를 해결하기 위한 서술의 좋은 알고리즘 이다.

-Out-of-order Execution
- Instruction 수행순서를 CPU에서 내부적으로 변경
- 준비된 명령어를 먼저 수행하여 전체 프로그램의 실행시간을 단축
- 순서를 바꾸어도 문제가 없는지를 판단하는 복잡한 로직이 필요함

-Synchronication Hardware
- 세개의 하드웨어 명령어들은 동기화를 도와주기 위해 제공된다.
- Memory Barriers,Hardware instructions,Atomic Variables

-Memory Barrier
- Memory barrier 명령어는 모든 load 그리고 저장되는 명령어는 다음의 load 그리고 저장 되어지는 연산이 수행 되어지기 전에 완료가 되어지는 것을 보장한다.
- 결국,명령어는 다시 수행되어졌고,memory barrier은 저장연상이 메모리 안에서 완료되는 것하고 그리고 다른 프로세스들이미래에 load되거나 저장 되어진 연산이 수행되기 전에 보여질수있도록 보장한다.

-Atomic Instructions
- Special Hardware instructions that allos us to either test-and-set the content
of a word,or to swap the contents of two words atomically(uninterruptedly)
- test-and-set
  - 메모리 공간에 1을 쓰고 single atomic으로써 오래된 값을 반환한다.
  - bounded waiting problem을 해결할수없다.
- compare-and-swap
  - passed parameter value에 원래 값을 반환한다.
  - new_value 파라미터의 value를 설정하지만, 오직 value == excepted
    - 스왑은 이 컨디션 아래에서만 발생한다.
    - 원자적으로 실행 되어진다.

-Atomic Variables
- atomic(uninterruptiable)이 Integer나 Boolean과 같은 기초적인 데이터 타입에 업데이트 된것이 제공된다.
- 결국 amtomi variable은 atomic업데이트를 제공한다. 그들은 모든 순환동안 race condition을 전체저긍로 해결할수없다.

-Mutex(Mutual exclusion) Locks
- 이전의 해결책은 애플리케이션 프로그래머들의 접근이 불가능하고 더 복잡하게 만들었다.
- OS 디자이너는 critical section problem을 해결하기 위한 소프트웨어 도구를  빌드하였다.
- Simplest in mutext lock
  - Boolean 변수는 lock이 가능한지 아닌지를 나타낸다.
- 그러나 해결책은 busy wating을 요구한다.
  - 이 lock은 그래서 spinlock 이라고  불리어진다.

-semaphores

- 프로세스가 그들의 활동을  동기화하는 더 세련된 방법(뮤텍스 보다) 방법을 제공한다.
- Semaphore S(integer variable)
- 두개의 분리 불가능한 원자 연산을 통해서만 접근이 가능하다. wait()과 그리고 signal()


-Types of semaphores
- Counting semaphore
  - 정수 밸류는 제한되지않은 영역을 넘지않게 조절할수있다.

- Binary Semaphore
  - 정수 밸류는 0과 1사이에서 조절된다.
  - 뮤텍스 락과 같다.

- 카운팅 세마포어 S는 바이너리 세마포어를 사용하는 세마포어를 수행할수있다.