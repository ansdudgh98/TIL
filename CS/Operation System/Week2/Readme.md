# 운영체제 3장 정리(Process)

-----

◻︎Process
- 실행중인 프로그램
- 프로세스는 순차적인 방식안에서 진행되어야 한다.

◻︎Program Vs Process

-Process
- 프로세스는 메모리 안에서 활동하는 개체이다.
- 프로세스는 상태를 가지고있다.

-Program
- 프로그램 디스크에 저장되는 수동적인 개체이다(실행가능한 파일)
- 프로그램은 실행되어지는 파일이 메모리 안으로 로드되어질때 프로세스가 된다.
- 하나의 프로그램은 여러개의 프로세스가 될수있다
- Like Class vs Instance

◻︎Job vs Task vs Process
- jobs는 배치 시스템에서 실행되어진다.
- Tasks는 시간 분할 시스템에서 실행된다.
- 프로세스는 현대 컴퓨터 시스템에서 실행되어지는 단위이다.
- 우리는 모두 프로세스라고 부를수있다.

◻︎ MultiProcessing vs MultiTasking
-멀티 프로세싱은 두개이상의 CPU에서 작동하는 거싱고 Multitasking은 CPU가 그들사이에서 바뀌면서 여러개의 프로세스를 실행시키는 것이다.
-Time Sharing

◻︎Memory Layout
- 프로그램 코드는 text sction 에서 불러와진다.
- 스택은 일시적인 데이터를 포함하고있다(Function Parameters,return addresses,local variables)
- Data Section은 전역변수를 포함하고 있다.
- Heap은 실행되는 동안 동적으로 할당되어진다.

(Memory Layout)

![img.png](Image/img1.png)

◻︎Process State

-프로세스의 실행으로써 상태가 변한다.

-New
- 프로세스가 생성 되어지는중 

-Running

- 명령어가 실행 되는 중

-Waiting
- 프로세스가 이벤트가 발생한 동안 기다리는것 중

-Ready
- 프로세스가 하나의 프로세서에 등록되어지는 것을 기다리는 중

-Terminated
- 프로세스의 실행이 종료되어 진 것 

![img.png](Image/img2.png)

◻︎ Process Control Block(PCB)

-Process Control Block(or task control block)
- 정보는 프로세스 간에 연관되어있다.

-Contents of PCB

1.Process State
- Running,Waitiing,-etc

2.Program Counter
- Location of intruction to next execute

3.CPU registers
- Contents of all process-centric registers

4.CPU scheduling information
- Priorites,scheduling queue pointers

5.Memory-management information
- Memory allocated to the proces
 
6.Accounting information
- CPU used,clock time elapsed since start,time,limits

7.I/O status information
- I/O Devices allocated to process list of open files

![img.png](Image/img3.png)

◻︎Threads
- 거의 프로세스는 실행된 싱글 스레드를 가진다.
- Multiple Program은 프로세스 당 대응한다.

◻Process Scheduling
- 시분할의 목적은 각 프로그램들이 실행되는 동안 사용자가 상호 작용할 수 있도록 프로세스들 사이에서 
CPU 코어를 빈번하게 교체하는 것이다.
- Process scheduler는 실행가능한 여러 프로세스 중에서 하나의 프로세스를 선택한다.

◻Characteristics of processes
-I/O-bound process
- Spends more of its time doing I/O
-CPU-bound process
- Generates I/O requests infrequncy

◻Scheduling Queues
-Ready Queue
- 프로세스가 시스템에 들어가게 되면 준비큐에 들어가서 준비 상태가 되어 CPU코어에서 실행되기를 기다린다.
- 일반적으로 연결 리스트(linked list)에 저장된다.

-Wait Queue
- I/O 완료와 같은 특정 이벤트가 발생하기를 기다리는 프로세스는 대기 큐(wait Queue)에 삽입된다.

◻Process lifeCycle

-새로운 프로세스는 ready queue에 처음에 놓여진다.
-프로세스는 실행이 되기 위해 선택 되거나 혹은 dispatch될때까지 기다린다.
-CPU코어가 할당되고 실행 상태가 되면 ,여러 이벤트 중 하나가 발생 될 수 있다.

-During exection
- 프로세스가 I/O요청을 공표한 다음 I/O대기 큐에 놓일 수 있다.
- 프로세느는 새 자식 프로세스를 만든 다음 자식의 종료를 기다리는 동안 대기큐에 놓일 수 있다.
- 인터럽트 또는 타임 슬라이스가 만료되어 프로세스가 코어에서 강제로 제거되어 준비큐로 돌아갈수있다.

◻CPU Scheduler
- 레디큐안에 있는 프로세스 사이에서 선택한다.
- I/O-bound-processes와 CPU-bound processes 사이에서 균형을 이룬다.
- 적어도 100밀리세컨드안에는 실행이 된다.

◻Context Swtiching
- CPU는 하나의 프로세스에서 다른 프로세스로 멀티태스킹을 위해 바꾼다.
- CPU가 다른 프로세스로 바뀔때 시스템은 아래를 수행해야한다.
- 1.기존의 프로세스의 상태를 저장하고
- 2.새로운 프로세스의 상태를 불러온다.
- Context Swiching은 pure overhead이다.
- 응답시간과 최종결과 사이의 trade-off이다.
- 시스템은 스위칭 되는 동안 사용을 할 수 없다.

◻Context
- 프로세스의 상태이다.
- 프로그램 카운터,레지스터를 포함한다.


### Operations on Processes
- 프로세스는 동시에 실행 될수있고
- 프로세스는 동적으로 실행 되어야 하고
- 프로세스는 동적으로 삭제 되어야 한다.
- 시스템은 프로세스의 삭제와 생성의 방법을 제공해야 한다.

◻Process Creation
- 하나의 프로세스는 다른 프로세스들을 생성한다.
- 부모 프로세스는 프로세스를 생성하고 자식 프로세스는 부모프로세스에 의해 생성 되어진다.
- 프로세스들의 트리를 형성한다.
- 일반적으로는 프로세스는 process identifier(pid)에 의해서 확인되어지고 관리 되어진다.

-Excution Options
- 부모와 자식은 동시에 실행된다.
- 부모는 자식이 삭제 될 때 까지 기다린다.

-Address Space
- 자식은 부모에서 복제된다.
- 자식은 주소공간을 불러와 프로그램을 가진다.(Child has a program loaded into it)

◻Process creation system calls(UNIX)
- fork()는 새로운 프로세스를 생성한다.
- exec()는 하나의 새로운 프로그램과 함께 프로세스의 메모리 공간을 대체한다.
- 부모 프로세스는 대기하고있는 자식프로세스를 삭제하기 위해 wait()함수를 부른다.

◻init&systemd

-init
- 전통적인 UNIX 시스템은 모든 프로세스들의의 root로써 process init을 확인한다.

-systemd
- 리눅스 시스템은 최근에 init을 systemd로 대체되어지고있다.

◻Process Termination
- 프로세스는 

◻Abort
- 부모는 abort()시스템 콜을 사용하여 실행 되어지고있는 자식 프로세스를 제거되어질수있다.
- 자식이 할당된 자원을 초과하는경우,Task가 이미 사용되어진 자식을 요청한경우,
부모가 이미 존재하고,운영체제가 만약 부모 프로세스가 제거 된 경우 자식의 지속을 허용하지 않는 것에 이유가 있다.

◻Waiting for the termination of the parent

- 부모 프로세스는 wait()시스템콜이 상요 되어진 자식프로세스의 제거를 이미 기다리고있다.
- 그 요청은 상태 정보와 제거되어지는 process의 pid를 반환한다.
- pid = wait(&status);
- 만약 부모프로세스가 wait을 기다리고 있지 않다면 프로세는 좀비이다.
- 만약 부모 프로세스가 wait()의 적용 없이 제거되어진다면, 프로세스는 orphan이다.

◻Cascading termination
- 만약 부모가 제거 된 경우 자식의 존재를 허용하지 않는다.
- termiantion은 운영체제에 의해 초기화 되어진다.

### Interproceess Communication
- 시스템 안에 있는 프로세스들은 비 독립적이거나 협력적이다.
- 협력하는 프로세스는 데이터를 공유하고 있는 다른 프로세스들 에게 영향을 주거나 영향을 받고있다.

-Two models of IPC
◻ Shared memory
- 커널에서 요구되는 것으로부터 의존하는 것이 없기 때문에 빠르다.
- 모든 접근은 메모리 접근 과정에서 다루어 진다.

◻ Message passing
- 시스템 안에 분포되어있는 것을 쉽게 수행할수있다.
- 전형적으로 시스템콜에 의해 수행 되어진다.
- 프로세스들은 공유변수들의 의존 없이 각각 함께 소통한다.
- IPC facility는 send(message)와 receive(message)를 제공한다.
- message의 사이즈는 사이즈는 고정적이거나 유동적일수도있다.
- P와 Q 프로세스는 그들이 필요하면 소통한다.(그들 사이에서 commucationlink를 설립하고 send/receive를 통해 교환한다.)

◻ Implimeation of Communication Link

-physical

- shared memory
- Hardware bus
- Network

-Logical

- Direct of indirect
- Synchronous or asynchronous
- Automatic or explicit buffering

◻ Direct Communication
- 프로세스들은 각각 서로 분명하게 소통하여야한다.
- Link들은 자동적으로 설립되어진다.
- 하나의 link는 분명히 한쌍의 communication process 쌍과 함께 연관 되어진다.
- Link는 단방향이어야하나 항상 양방향이어야한다.

◻ Indirect communication

- 메세지는 메세지 박스로부터 직접 가야되거나 직접 받아아한다.
- 각각의 메일박스는 고유 아이디를 가지고 있다.
- 프로세스는 그들이 메일박스를 공유하고 있을 경우에만 소통을 할수있다.

◻Properties of Communication link

- Link는 프로세스들이 공통된 mainbox를 공유하고 일때만 설립이 가능하다.
- 링크는 많은 프로세스들과 함께 연관되어져야한다.
- 프로세스의 각각의 쌍은 여러 커뮤니케이션 링크를 공유한다.
- 링크는 양방향이거나 단방향이다.

◻Synchronization

-Blocking(synchronous)
- Blocking sender은 메세지가 받아질때 까지 block한다.
- Blocking receiver은 메세지를 받아질떄까지 block 한다.

◻Non-blocking(asynchronous)
- Non-Blocking Sender은 메세지를 보내고 지속한다.
- Non-Blocking Receiver은 유효한 메세지나 null메세지를 받는다.

### IPC Systems
- POSIX shared memory
- Mach Message passing
- Windows advanced local procedure call(ALPC)
- pipe

◻Posix Shared Memory
- 프로세스는 처음 공유메모리 세그먼트를 생성한다
- 존재하는 세그먼트를 열어서 사용하게 되면
- object의 사이즈를 설정한다.
- 공유 메모리의 object의 파일 포인터의 메모리 맵의 mmap()을 사용한다
- 공유 메모리의 읽기 쓰기는 mmap()의 리턴의 포인터의 사용으로 끝난다.

◻Pipe
- 두 프로세스의 소통을 전달을 허용하는 전달자로써 행동한다.
- Oridinary Pipe는 생성되어진 프로세스외에는 접근 할수없다.
- 전형적으로 부모 프로세스는 pipe를 생성하고 만들어낸 자식프로세스와 소통하는 것에 사용할수있다.
- Named Pipe는 부모 자식의 관계 없이 생성할 수 있다.

◻Oridinary Pipe
- Oridinary Pipe는 표준적인 producer와 consumer 스타일로 소통이 허용된다.
- Oridinary Pipe는 단방향이다.
- 부모와 자식관계는 소통 프로세스 사이에 요구된다.
- 윈도우는 이것을 익명 파이프라고 한다.

◻Named pipe
- Orinary Pipe보단 더욱 강려갛다.
- 양방향 소통이다.
- 두 프로세스 사이는 Parent-Child 관계가 아니다.
- 몇몇의 프로세스 들은 소통을 위해 named pipe가 사용이 가능하다.
