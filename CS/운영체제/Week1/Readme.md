# 운영체제 1장

-----------

### 운영체제란(Operation System)?
- 컴퓨터의 하드웨어를 관리하는 소프트웨어
- 응용프로그램 사용을 위한 기반을 제공하며 사용자와 하드웨어 사이의 중재자 역활을 수행함

### 운영체제의 목표(Operation System goals)

1.하드웨어와 소프트웨어 사이의 인터페이스

-유저 프로그램을 실행하고 그리고 유저의 문제를 더욱 쉽게 해결한다.

2.Library(including System calls)

-컴퓨터 시스템을 사용하기를 편리하게 만들어준다.

3.자원 관리자(Resource Manager)

-컴퓨터 하드웨어의 능률적인 사용을 방법을 제공

# 운영체제의 역활

1.하드웨어

-하드웨어는 중앙 처리장치(CPU),메모리 및 입출력(I/O)장치로 구성되어, 기본 계산용 자원을 제공함

2.응용프로그램

-사용자의 계산 문제를 해결하기 위해 이들 자원이 어떻게 사용될지를 정의

3.운영체제

-운영체제는 컴퓨터 시스템이 동작할때 하드웨어나 응용프로그램들과 같은 자원을 적절하게 사용할 수 있는 방법을
제시함

### 사용자 관점에서의 운영체제

- 사용의  용이성을 위해 설계 된다.
 
### 시스템 관점에서의 운영체제

- 컴퓨터 관점에서의 운영체제는 하드웨어와 가장 밀접하게 연관된 프로그램이며 따라서 운영체제를 자원 할당자(resource allocator)로 볼수 있다.

### 운영체제와 관련된 개념

1. 커널(Kernel)

- 컴퓨터가 작동되는 동안 항상 실행되는 프로그램

2. 시스템 프로그램(System Program)

- 운영체제와 관련되어 있지만 반드시 커널의 일부일 필요가 없는 시스템 프로그램

- <-> 시스템 작동과 관련되지 않은 모든 프로그램을 포함하는 응용프로그램
  
3. 미들 웨어(Middleware)
- 응용 프로그램 개발자에게 추가 서비스를 제공 하는 일련의 소프트웨어 프레임워크

- EX)Apple의 IOS, Google의 Android

### 운영체제의 기능

1.Process management(CPU scheduling)

- 실행중인 프로그램은 프로세스 이다.(A Process is a program in execution)

- 프로세스는 task를 수행하기 위해서는 자원이 필요하다.

- Process Management 는 사용자 프로세스와 시스템 프로세스의 생성,삭제,일시중지와 재수행을 관리한다.

- 프로세스의 동기화와 통신을 위한 기법을 제공한다.

2.Memory management

- 프로그램이 실행되기 위한 전체(혹은 부분의)프로그램의 명령어들은 메모리(memory)안에 있어야 한다.
- 프로그램이 필요로하는 전체(혹은 부분의) 데이터들은 메모리 안에 있어야 한다.
- Memory Management는 메모리안에 무엇이 있고 그리고 언제 수행되는지에 대해서 결정한다.(Memory management determines waht is in memory and when)
- Memory Management는 메모리의 어느부분이 현재 사용되고 있으며 어느 프로세스에 의해 사용되고 있는지에 대해서를 추적해야 한다.
- Memory Management는 필요에 따라 메모리 공간을 할당하고 회수해야 한다.
- Memory Management는 어떤 프로세스들을 메모리에 적재하고 제거해야 되는지를 결정한다.

3.File system

- File  System은 접근 방식,용량,데이터 전송 속도,접근 방법에 따른 분류 방식이 있다.
- 형식적인, 논리적인 storage의 정보를 보여준다.
- 파일은 항상 디렉토리 안에 조직화 되어있다.
- 대부분의 시스템에서는 누가 무엇에 접근이 가능한지에 대한 접근 권한을 결정한다.
- 운영체제는 파일과 디렉토리의 의 생성 및 제거,파일과 디렉토리를 조작하기 위한 권한,파일을 보조장치에 매핑,안정된 비휘발성 저장매체에 파일을 저장하는 역활을 수행합니다.

3-1.Mass Storage Managemanet

- Mounting and unmounting
- Free-Space management
- Storage Allocation
- Disk Scheduling
- partitioning
- Protection

4.I/O system
- 운영체제에서의 I/O System은 사용자에게 특정 하드웨어 장치의 특성을 숨기는 것이다.
- I/O System Management는 버퍼링,캐싱,스풀링을 포함한 메모리 관리 구성요소,일반적인 장치 드라이버 인터페이스,특정 하드웨어 장치들을 위한 드라이버로 구성되어 있다.

5.Device driver

6.Network system

7.Protection and Security

- Protection은 OS가 정의한 프로세스 혹은 유저의 자원의 접근 제어 방식에 대해서 프로그램 프로세스 또는 사용자들의 접근을 제어하는 기법이다.
- 유저가 결정한 모든 파일 프로세스에 대한 UserID,Group Id의 접근 제어를 한다.
- Security는 내부와 외부의 공격을 방어하는 것이다.

8.Virtualization
- Emulation은 소스 CPU의 유형 대상 CPU 유형과 다른 경우에 사용된다.
- 가상화는 다른 OS들을 시스탬의 운영체제에서 실행되게 해준다.

![img.png](Image/img2.png)

9.Dual-mode Operation
- 그 자신과 다른 시스템의 요소들을 보호가기 위하여 OS가 따르는 것이다.(Allows OS to protect itself and other system components)
- user mode와 kernel mode로 나뉜다.
- 하드웨어에 의해 user/kernel mode의 mode bit이 제공 된다.
- 몇몇의 명령어들은 privileged로써 디자인되어지며 kernel mode에서만 수행이 가능하다.

![img.png](Image/img.png)

### 컴퓨터 시스템의 구조(Computer System Organization)

1.Computer System Organization
- 하나이상의 CPU와 디바이스 구성요소는 공용메모리에 제공 되어지는 common bus를 통하여 연결되어진다.(One or more CPUs,
device controllers connet through common bus providing access to shared memory)
- Cpu들과 디바이스 컨트롤러는 병렬로 실행되어 메모리 사이클을 통해 경쟁한다.(Concurrent execution of CPUs and devices competing for memory cycles)

![img.png](Image/img3.png)

2.System Bus

- 디바이스 간의 소통채녈
- Bus Protocol : 디바이스 간에 데이터를 움직이게 하는 규칙의 단위
- Master/Slave : Master은 버스의 요청을 초기화 하고 slave는 버스의 요청을 받는다.

3.Computer System Operation

- 각각의 디바이스 컨트롤러는 특정한 디바이스 타입을 맡는다.
- I/O 디바이스와 그리고 CPU는 병렬로 실행이 가능하다.
- 디바이스 컨트롤러는 인터럽트가 발생됨으로 인해 CPU의 연산을 종료시킬시도 있다.

3.Interrupt

- 인터럽트는 미리 정의된 서비스 요청이 들어왔을때 무엇을 하고있거나 혹은 즉시 멈추는 방법이다.
- 다른프로그램들의 실행 응답을 기다리는 가능성을 가지고 있다. 

3-1. Interrupt Implementation

-하드웨어
- Cpu는 인터럽트 상태를 감지하는 하드웨어 신호를 가진다.
- Cpu가 신호를 감지하게 되면은 다음과 같이 수행한다.
1. 하는 것을 멈춘다.
2. 프로그램의 현재 상태를 저장한다.
3. Interrupt 안에있는 Interrupt vector table의 시작 주소를 찾는다.
4. interrupt service rountine으로 jump한다.
- Interrupt Vector는 인터럽트를 위한 주소의 배열이다.

3-2.Polling
- 다른 디바이스나 혹은 프로그램의 상태를 지속적으로 제크한다.
- 응답을 기다리는 동안 CPU사이클의 낭비를 유발한다.(다른 프로그램의 polling이 지속되는 동안 실행할수없음.)

4.Stoage Structure

-Main memory
- Cpu가 직접적으로 접근할수 있는 가장 큰 저장공간이다.
- 전형적으로,RAM(Random Access Memory)는 Dynamic-access-Memory(DRAM)으로 구성되어있다.(휘발성을 가짐-voltage storage)

-Secondary storage

- 큰 비휘발성 메모리의 저장공간을 메인 메모리의 확장 공간으로 제공한다.
- HDD,SSD,FLASH,ETC

5.Definition of Computer System Components

- CPU: 명령어를 실행하는 하드웨어
- Processor : CPU들을 포함하는 물리적인 칩
- Core : CPU의 기본적인 계산 단위
- Multicore : 같은 CPU위에 멀티 코어를 포함하고 있는것
- MultiProcessor : 멀티 프로세서를 포함하는것 


