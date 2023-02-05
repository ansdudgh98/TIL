- 람다식
    - 람다식(Lambda expression)은 간단히 말해서 메서드를 하나의 식(expression)으로 표현한 것이다.
    - 람다식은 함수를 간략하면서도 명확한 식으로 표현할 수 있게 해준다.
    - 메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로, 람다식을 익명(annoymous function)이라고 한다.
    ```java
        **메서드 표현**
        int method(){
            return (int) (Math.random() * 5) + 1;
        }

        **람다식 표현**
        int[] arr = new int[5];
        Arrays.setAll(arr, (i) -> (int)(Math.random()*5 + 1));
    ```
    - 메서드보다 람다식이 간결하면서도 이해하기가 쉽다.
    - 모든 메서드는 클래스에 포함되어야 하므로 새로 만들어야하고, 객체도 생성해야지만 메서드를 호출할 수 있지만, 람다식은 이 모든 과정없이 오직 람다식 자체만으로도 이 메서드의 역활을 대신할 수 있다.

- 람다식 작성하기
    - 람다식은 메서드에서 이름과 반환타입을 제거하고 매개변수 선언부와 몸통{} 사이에 ->을 추가한다.
    ```java
        반환타입 메서드이름 (매개변수 선언){
            문장들
        }

        int max(int a, int b){
            return a>b ? a : b;
        }

        (int a, int b) -> {return a>b ? a:b } 

        (int a,b) -> return a>b ? a:b

        (a,b) -> a>b ? a:b
    ```

- 함수형 인터페이스(Functional Interface)
    - 람다식이 메서드와 동등한 것 같지만 사실 람다식은 익명 클래스의 객체와 동등하다.
    ```java
        (int a, int b) -> a>b ? a:b 

        =========>

        new Object(){
            int max(int a,int b){
                return a>b ? a:b;
            }
        }
    ```
    - 람다식으로 정의된 익명 객체의 메서드의 호출
        
        - 참조변수가 있어야 객체의 메서들를 호출 할 수 있기때문에 기 익명 객체의 주소를 f라는 참조 변수에 저장해보자
        - 참조변수의 타입은 참조형이니까 클래스 또는 인터페이스가 가능하다. 그리고 람다식과 동등한 메서드가 정의되어 있는 것이어야 한다.
        ```java
            타입 f = (int a, int b) -> a > b ? a : b; 
        ```

        ```java
            ** MyFunction인터페이스를 생성 **
            interface MyFunction{
                public abstract int max(int a,int b);
            }

            **익명 클래스의 객체 생성 **

            MyFunction f = new Function(){
                public int max(int a,int b){
                    return a>b ? a:b;
                }
            };

            ** 익명 객체를 람다식으로 대체 **
            MyFunction f = (int a,int b) -> a >b ? a:b; //익명객체를 람다식으로 대체

            
            int big = f.max(5,3); //익명 객체의 클래스 메서드 호출
        ```
        
        - 인터페이스를 구현한 익명 객체를 람다식으로 대체가 가능한 이유는, 람다식도 실제로는 익명객체이고, MyFunction인터페이스를 구현한 익명객체의 메서드 max()와 람다식의 매개변수의 타입과 개수 그리고 반환값이 일치하기 때문이다.
        - 람다식을 다루기 위한 인터페이스를 함수형 인터페이스(functional interface)라고 부른다.

        ```java
            @FunctionalInterface // @FuntionalInterface를 붙이면 컴파일러가 함수형 인터페이스를 올바르게 정의하였는지 확인해준다.
            interface MyFunction{
                public abstarct int max(int a, int b);
            }
        ```
        - 단 함수형 인터페이스에는 오직 하나의 추상메서드만 정의되어 있어야 한다. 반면에 static메서드와 default메서드의 갯수에는 제약이 없다.

        ```java
            List<String> list = Arrays.asList("abc","aaa","bbb","ddd","aaa");

            Collections.sort(list, new Comparator<String>()){
                public int compare(String s1, String s2){
                    return s2.compareTo(s1);
                }
            }

            =======>

            List<String> list = Arrays.asList("abc","aaa","bbb","ddd","aaa");
            Collections.sort(list,(s1,s2)-> s2.compareTo(s1));
        ```

- 함수형 인터페이스 타입의 매개변수와 반환타입
    - 메서드의 매개변수가 MyFunction타입이면, 이 메서드를 호출할 때 람다식을 참조하는 참조변수를 매개변수로 지정해야한다는 뜻이다.
    ```java
        @FunctionalInterface
        interface MyFunction{
            void myMethod(); //추상메서드
        }

        void aMethod(Myfunction f){
            f.myMethod();
        }

        ...

        MyFunction f = () -> System.out.println("myMethod()");
        aMethod(f);

        //또는 참조변수없이 아래와 같이 직접 람다식을 매개변수로 지정하는 것이 가능하다.

        aMethod(() -> System.out.println("myMethod()")); //람다식을 매개변수로 지정
    ```
    
    - 메서드의 반환타입이 함수형 인터페이스 타입이라면, 이 함수형 인터페이스의 추상메서드와 동등한 람다식을 가리키는 참조변수를 반환하거나 람다식을 직접 반환할 수 있다.

    ```java
        MyFunction myMethod(){
            MyFunction f = () -> {};
            return f;

            ==>

            return () -> {};
        
        }
    ``
    
    - 람다식의 타입과 형변환
        - 함수형 인터페이스로 람다식을 참조할 수 있는 것일 뿐, 람다식의 타입이 함수형 인터페이스의 타입과 일치하는 것은 아니다. 람다식은 익명 객체이고, 익명 객체는 타입이 없다.
        - 정확히는 타입은 있지만 컴파일러가 임의로 이름을 정하기 때문에 알 수 없는 것이다. 대입연산자의 양변의 타입을 일치시키기 위해 아래와 같이 형변환이 필요하다.
        - 람다식은 MyFunction 인터페이스를 직접 구현하지 않았지만, 이 인터페이스를 구현한 클래스의 객체와 완전히 동일하기 때문에 형변환을 허용하고, 이 형변환은 생략이 가능하다.
        - 람다식은 이름이 없을 뿐 분명히 객체인데도 아래와 같이 Object 타입으로 형변환 할 수 없다. 람다식은 오직 함수형 인터페이스만 형변환이 가능하다.
        ```java
            MyFunction f = (MyFunction) {()->{}}; //양변의 타입이 다르므로 형변환이 필요

            Object obj = (Object){()->{}}; //에러 함수형 인터페이스로만 가능

            //굳이 Object타입으로 형변환 하려면 먼저 함수형 인터페이스로 변환해야함
            Object obj = (Object)(MyFunction)(()->{});
        ```
- java.util.function패키지 
    - 이 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았다.
    | 함수형 인터페이스 | 메서드 | 설명 |

    

        






    







        





        

