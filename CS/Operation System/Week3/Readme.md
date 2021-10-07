# 4장 쓰레드
-----------

◻Thread
- CPU 활용의 기본적인 단위
- 쓰레드는 코드 섹션,데이터 섹션,파일과 신호와 같은 자원의 같은 프로세스의 소유중 다른 쓰레드
를 공유한다.

-Motivation 
- 대부분의 현대 애플리케이션은 멀티쓰레드를 쓴다.
- 앱의 멀티 태스킹은 여러개의 쓰레드로 나누어 실행 되어질수있다.(Update display,Fetch Data,Spell Checking,Answer a network request)
- 프로세스 생성은 쓰레드가 가볍운 생성 동안에도 무겁다.
- 요청이 만들어졌을때 프로세스를 생성하는 것 보단 서버는 서비스를 위한 쓰레드를 만든다.
- 커널은 일반적으로 멀티 쓰레딩이다.

-Benefits
- 반응성 : 만약 프로세스의 일부분이 blocked되었을때,특히 유저 인터페이스같은 것이 실행을 지속하는것을 허락할수있다.
- Resource Sharing : 쓰레드는 프로세스의 자원을 쉽게 사용할수있다,shared memory나 message passing보다
- Economy : 프로세스 생성보다 비용이 덜드며 쓰레스 스위칭은 Context 스위칭 보다 오버헤드가 적다.
- Scalability: 프로세스는 멀티코어 구조의 장점을 가져올수있다.

◻Multicore programming

-Multicore or Multiprocessor Systems
- 각각의 코어는 OS로부터 분리된 CPU부터 나타난다.
- 멀티쓰레드 프로그래밍은 멀티코어에서 더욱 효율적이고 동시적을 제공한다.
- 하나의 시스템의 병행 수행은 동시에 하나이상의 task를 시행할수있다.
- 병행성은 하나이상의 task의 progress의 과정을 지원한다.

-Multicore Challenges
- Identifying tasks
- Balance
- Data splitting
- Data dependency
- Testing and debugging

◻Types of Parallelism

-Data parallelism
- 멀티코어 사이의 같은 데이터의 subset들을 분배한다.

-Task paralleism
- 코어 사이의 쓰레드 분배, 고유한 연산을 수행하는 쓰레드 간

◻User Thread /Kernel Thread

-User Thread
- 유저 레벨 쓰레드 라이브러리에서 관리되어진다.
- POSIX Pthreads,windows threads,java threads

-Kernel thread
- 커널에 의해 지원된다.
- windws,Linux,Mac os x,ios,android

◻Multithreading Models

-Many-to-One
- 많은 유저 레벨 쓰레드는 하나의 커널 쓰레드에서 mapped된다.
- 하나의 쓰레드의 blocking이 여러 쓰레드의 block을 유바하낟.
- 멀티 쓰레드는 멀티코어 시스템에서 병렬로 수행이 안되어진. 오직 하나만 한 타임떄에 커널에 있을수 있기 때문에
- 몇몇 시스템이 최근에는 이 모델을 사용한다.
- Solaris Green Threads,GNU portable Threads

-One-to-One
- 각각의 유저레벨 쓰레드가 커널 쓰레드에 map된다.
- 하나의 유저레벨 쓰레드의 생성은 하나의 커널쓰레드를 생성한다.
- Many-to-one보다 동시에 더 실행된다.
- 때떄로 제약 되어진 프로세스당 쓰레드의 갯수는 overhead를 결정한다.
- Windows,Linux

-Many-to-Many
- 많은 유저 레벨 쓰레드는 많은 커널 쓰레드를 mapped하는 것을 허용한다.
- 충분한 숫자의 커널쓰레드의 생성에서은 OS에서 허락 되어 진다.
- windows는 ThreadFiber Package와 함께한다.
- 다른방면으로 매우 공통적인것이 없다.

-TWO-level-model
- Many-to-Many + One-to-One

◻︎Thread Libraries
- 프로그래머들은 생성/관리 쓰레드 API와 함께 제공한다.
- 라이브러리는 전적으로 유저 공간이다.
- 커널 - 레벨 라이브러리는 OS에서 제공 된다.
- POSIX pthread,windows,java

-Pthread
- 수행 되어지지않고 명시되어진다.
- 유저레벌 또는 커널레벨둘중하나에서 제공되어 진다.

-Java Thread
- JVM 에서 관리되어진다.
- 전형적으로 OS의 아래에서 제공되어져 사용되는 쓰레드 모델을 수행한다.

-Implicit Threading
- 쓰레드숫자로써의 인기의 성장이 증가하면서,프로그램의 정확성이 쓰레드 분명함과 함께 어려워 지고있다.
- 쓰레드의 생성과 관리는 컴파일러와 프로그래머의 런타임 라이브러리로써 수행된다.
-Thread pools,Fork-Join-Open MP,Grand Central Dispatch