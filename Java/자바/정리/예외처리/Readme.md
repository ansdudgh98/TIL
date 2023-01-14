- 에러(error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
    - 종류
        1. 컴파일 에러 : 컴파일 시에 발생하는 에러
        2. 런타임 에러: 실행 시에 발생하는 에러
        3. 실행은 되지만 의도와 다르게 동작하는 것
- 예외(exception) : 프로그램 코드에 의해서 수습될 수 있는 미약한 오류
    - 예외클래스 계층도

      ![IMG_0003](https://user-images.githubusercontent.com/52616389/212485140-2c03bae8-bc4b-49e0-b040-864f6fa862ac.JPG)

    - Exception클래스와 RuntimeException클래스 중심의 상속 계층도

      ![IMG](https://user-images.githubusercontent.com/52616389/212485421-b971488d-877b-4aa0-aa81-d610e5e86a2a.png)

    - 예외 클래스들은 두 그룹으로 나뉘어 질 수 있다.
        1. Exception클래스와 그 자손들(RuntimeException과 자손들 제외)
            - 사용자의 실수와 같은 외적인 요인에 발생하는 예외
        2. RuntimeException클래스와 그 자손들
            - 프로그래머의 실수로 발생하는 예외
- 예외처리하기
    - 정의 - 프로그램 실행시 발생할 수 있는 예외에 대비한 코드를 작성하는 것
    - 목적 - 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것
    1. try -catch문

        ```java
        try{
        		//예외가 발생할 가능성이 있는 문장들을 넣는다.
        }catch(Exception e1){
        		//Exception이 발생한 경우 이를 처리하기위한 문장을 넣는다.
        }
        catch(Exception e2){
        		//Exception이 발생한 경우 이를 처리하기위한 문장을 넣는다.
        }
        ```

        - 예외가 발생한 경우
            - 발생한 예외와 일치하는 catch블럭이 있는지 확인한다.
            - 일치하는 catch블럭을 찾게 되면, 그 catch블럭 내의 문장들을 수행하고 try-catch문을 빠져나가서 그 다음 문장을 계속해서 수행한다. 만약 일치하는 catch블럭을 찾지 못하면, 예외는 처리되지 못한다.
        - try블럭 내에서 예외가 발생하지 않은 경우
            - catch블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.
    2. 메서드에 예외 선언하기
        - 메서드에 예외를 선언하려면, 메서드의 선언부에 키워드 throws를 사용해서 메서드 내에서 발생할 수 있는 예외를 적어두기만 하면 된다.

            ```java
            void method() throws Exception1,Exception2, .... ExceptionN{
            	//메서드 내용
            }
            ```

    3. finally블럭
        - finally블럭은 예외의 발생여부에 상관없이 실행되어야할 코드를 포함시킬 목적으로 사용된다.
        - try-catch문의 끝에 선택적으로 덧붙여 사용할 수 있으며,try-catch-finally의 순서로 구성된다.

        ```java
        try{
        		//예외가 발생할 가능성이 있는 문장들을 넣는다.
        }catch(Exception e1){
        		//Exception이 발생한 경우 이를 처리하기위한 문장을 넣는다.
        }finally{
        	//finally블럭은 try-catch문의 맨 마지막에 위치해야한다.
        	//예외가 발생하지 않은 경우 try->finally순으로 실행된다.
        }
        ```

    4. 자동 자원 반환 - try - with - resources문
        - try - with - resources문이라는 try-catch문의 변형이 새로 생겼고 입출력과 관련된 클래스를 사용할 때 유용하다.
        - 입출력에 사용되는 클래스 중에서는 사용한 후에 꼭 닫아 줘야 하는 것들이 있는데 사용했던 자원이 반환 되기 때문이다.
- printStackTrace()와 getMessage()
    - printStackTrace():예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메세지를 화면에 출력한다.
    - getMessage(): 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.
- 멀티 catch블럭
    - 여러 catch블럭을 ‘|’기호를 이용해서 , 하나의 catch블럭으로 합칠수있으며 예외 클래스의 개수에는 제한이 없다.

        ```java
        try{
        		//예외가 발생할 가능성이 있는 문장들을 넣는다.
        }catch(ExceptionA e1){
        		//Exception이 발생한 경우 이를 처리하기위한 문장을 넣는다.
        }
        catch(ExceptionB e2){
        		//Exception이 발생한 경우 이를 처리하기위한 문장을 넣는다.
        }
        
        --->
        
        try{
        		//예외가 발생할 가능성이 있는 문장들을 넣는다.
        }catch(ExceptionA e1| ExceptionB e2){
        		e.printStackTrace();
        }
        ```

- 예외 발생시키기
    - thorw를 사용해서 프로그래머가 고의로 예외를 발생시킬 수 있다.
    1. 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든 다음

        ```java
        Exception e = new Exception("고의로 발생시켰음");
        ```

    2. 키워드 throw를 이용해서 예외를 발생시킨다.

        ```java
        throw e;
        ```

- 예외의 호출 스택

    ```java
    public class Main {
        public static void main(String[] args) throws Exception{
            method1();
        }
    
        static void method1() throws Exception{
            method2();
        }
    
        static void method2 throws Exception{
            throw new Exception();
        }
    
    }
    
    //실행결과
    Exception in thread "main" java.lang.Exception
    at org.example.Main.method2(Main.java:12)
    at org.example.Main.method1(Main.java:8)
    at org.example.Main.main(Main.java:5)
    ```

    - 예외가 발생한 메서드에서 예외처리를 하지 않고 자신을 호출한 메서드에게 예외를 넘겨줄 수 있지만 이것으로 예외가 처리된 것은 아니고 예외를 단순히 전달만 하는 것이다. 결국 어느 한 곳에서는 반드시 try-catch문으로 예외처리를 해주어야 한다.
    - 예외가 발생했을 때, 모두 3개의 메서드(main,method1,method2)가 호출스택에 있었으며, 예외가 발생한 곳은 제일 윗줄에 있는 method2()라는 것과 main메서드가 method1()을 그리고 method1은 method2를 호출했다는 것을 알 수있다.
- 사용자정의 예외 만들기
    - 보통 Exception클래스 또는 RuntimeException클래스로 부터 상속받아 클래스를 만들지만, 필요에 따라서 알맞은 예외 클래스를 선택할 수 있다.

    ```java
    class MyException extends Exception {
        MyException(String msg){ //문자열을 매개변수로 받는 생성자.
            super(msg);//조상인 Exception클래스의 생성자로 호출
        }
    }
    ```

- 예외 되던지기(exception re-throwing)
    - 한 메서드에서 발생할 수 있는 예외가 여럿인 경우, 몇개는 try-catch문을 통해서 메서드 내에서 자체적으로 처리하고, 그 나머지는 선언부에 지정하여 호출된 메서드에서 처리하도록 함으로써, 양쪽에서 나눠서 처리되도록 할 수 있다.
    - 단 하나의 예외에 대해서도 예외가 발생한 메서드와 호출한 메서드,양쪽에서 처리하도록 할 수있는데 이 방법은 예외 되던지기(exception re-throwing)라고 한다.
    - 예외가 발생할 가능성이 있는 메서드에서 try-catch문을 사용해서 예외를 처리해주고 catch문에서 필요한 작업을 행한 후에 throw문을 사용해서 예외를 다시 발생시킨다. 다시 발생한 예외는 이 메서드를 호출한 메서드에게 전달되고 호출한 메서드의 try-catch문에서 예외를 다시 처리한다.

    ```java
    public class Main {
        public static void main(String[] args) {
            try{
                method1();
            }catch(Exception e){
                System.out.println("메인메서드에서 예외가 처리");
            }
        }
        static void method1() throws Exception{
            try{
                throw new Exception();
            }catch (Exception e){
                System.out.println("method1에서 예외가 처리");
                throw e;
            }
        }
    }
    ```

- 연결된 예외(chained exception)
    - 여러가지 예외를 하나의 큰 분류의 예외로 묶어서 다루기 위해서 원인 예외로 등록해서 다시 예외를 발생시킨다.

    ```java
    Throwable initCause(Throwable cause) 지정한 예외를 원인 예외로 등록
    Throwable getCause() 원인 예외를 반환
    ```
