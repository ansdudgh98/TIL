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
      ```
    
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
    | -------------|-----|-----|
    | java.lang.Runnable| void run() | 매개변수도 없고, 반환값도 없음|
    | Supplier<T>| T get() -> T | 매개변수는 없고 반환값만 있음|
    | Consumer<T>| T -> void accept(T t) | Supplier와 반대로 매개변수만 있고 반환값이 없음|
    | Function<T,R>| T -> R apply(T t) -> R | 일반적인 함수, 하나의 매개변수를 받아서 결과를 반환|
    | Predicate<T> | T -> boolean test(T t) -> boolean | 조건식을 표현하는데 사용됨, 매개변수는 하나, 반환타입은 boolean|

    - 타입문자 'T'는 'Type'을 'R'은 'Return Type'을 의미한다.   

    - 조건식의 표현에 사용되는 Predicate
      - Predicate는 Function의 변형으로, 반환타입이 boolean이라는 것만 다르다. Predicate는 조건식을 람다식으로 표현하는데 사용된다.
      ```java
        Predicate<String> isEmptyStr = s -> s.length == 0;
        String s = "";

        if(isEmptyStr.test(s))
            System.out.println("This.is an Empty String");
      ```
    
    - 매개변수가 두 개인 함수형 인터페이스
      - 매개변수의 개수가 2개의 함수형 인터페이스는 이름 앞에 접두사 'Bi'가 붙는다.
    
    | 함수형 인터페이스 | 메서드 | 설명 |
    | -------------|-----|-----|
    | BiConsumer<T,U>| T,U -> void accept(T t,U u) | 두 개의 매개변수만 있고,반환값이 없음|
    | BiPredicate<T,U>| T,U -> boolean test(T t,U u) -> boolean | 조건식을 표현하는데 사용됨, 매개변수는 둘,반환값은 boolean|
    | BiFunction<T,U,R>| T,U -> R apply(T t,U u) -> R | 두 개의 매개변수를 받아서 하나의 결과를 반환|

    ```java
        @FuncationalInterface
        interface TriFunction<T,U,V,R>{
            R apply(T t,U u,V v);
        }
    ```

    - UnaryOperator와 BinaryOperator
      - Function의 또 다른 변형으로 UnaryOperator와 BinaryOperator가 있는데, 매개변수의 타입과 반환타입의 타입이 모두 일치한다는 점만 제외하고는 Function과 같다.

    | 함수형 인터페이스 | 메서드 | 설명 |
    | -------------|-----|-----|
    | UnaryOperator<T>| T -> T apply(T,t) -> T | Function의 자손,Function과 달리 매개변수와 결과의 타입이 같다.|
    | BinaryOperator<T> | T,t -> T apply(T t,T t) -> T | BiFunction의 자손,BiFunction과 달리 매개변수와 결과의 타입이 같다.|

    - 컬렉션 프레임웍과 함수형 인터페이스
    
        | 인터페이스 | 메서드 | 설명 |
        | ------- | ---- | --- |
        |Collection| boolean removeIf(Predicate<E> filter)|조건에 맞는 요소를 삭제|
        |List| void replaceAll(UnaryOperator<E> operator) | 모든 요소를 변환하여 대체|
        |Iterable| void forEach(Consumer<T> action) | 모든 요소에 작업 action을 수행|
        |Map| V compute(K key,BiFunction<K,V,V> f) | 지정된 키의 값에 작업 f를 수행|
        |Map| V computeIfAbsent(K key,Function<K,V> f)| 키가 없으면, 작업 f 수행 후 추가|
        |Map| V computeIfPresent(K key, BiFunction<K,V,V> f) | 지정된 키가 있을 때, 작업 f 수행|
        |Map| V merge(K key, V value, BiFunction<V,V,V> f)| 모든 요소에 병합작업 f를 수행|
        |Map| void forEach(BiConsumer<K,V> action) | 모든 요소에 작업 action을 수행|
        |Map| void replaceAll(BiFunction<K,V,V> f) | 모든 요소에 치환작업 f수행|

    - 기본형을 사용하는 함수형 인터페이스

        | 함수형 인터페이스 | 메서드 | 설명 |
        | -------------|-----|-----|  
        |DoubleToIntFunction|double -> int applyAsInt(double d) -> int | AToBFunctio은 입력이 A타입 출력이 B타입|
        |ToIntFUnction<T> | T -> int applyAsInt(T value) -> int | ToBFunction은 출력이 B타입이다. 입력은 지네릭 타입|
        |IntFunction<R> | int -> R apply(T t,U u) -> R | AFunction은 입력이 A타입이고 출력은 지네릭 타입|
        |OptionalConsumer<T> | T,int -> void accept(T t, U u) | ObjAFunction은 입력이 T,A타입이고 출력은 없다.|

    - Function의 합성과 Predicate의 결합
        - java.util.function패키지의 함수형 인터페이스에는 추상메서드 외에도 디폴트 메서드와 static메서드가 정의되어 있다.
        ```java
            Function
            default <V> Function<T,V> andThen(Function<? super R,? extends V> after)
            default <V> Function<T,R> compose(Function<? super V,? extnes T> before)
            static <T> Function <T,T> identity()

            Predicate
            default Predicate<T> and(Predicate<? super T> other)
            default Predicate<T> or(Predicate<?super T> other)
            default Predicate<T> negate()
            static <T> Predicate<T> isEqual(Object targetRef)
        ```
- 메서드 참조
  - 람다식이 하나의 메서드만 호출하는 경우에는 메서드 참조(method reference)라는 방법으로 람다식을 간략히 할 수 있다.
  - 예)문자열을 정수로 변환하는 람다식
    ```java
        Function<String, Integer> f = (String s ) -> Integer.parseInt(s);

        Function<String, Integer> f = Integer::parseInt;//메서드 참조

        BiFunction<String,String,Boolean> f = (s1,s2) -> s1.equals(s2);

        BiFunction<String,String,Boolean> f = String::equals;
    ``` 
- 메서드 참조를 사용할 수 있는 경우가 한가지 더 있는데, 이미 생성된 객체의 메서드를 람다식에서 사용한 경우에는 클래스이름 대신에 그 객체의 참조변수를 적어줘야 한다.
  ```java
      MyClass obj = new MyClass();
      Function<String,Boolean> f = (x) -> obj.equals(x); //람다식
      Function<String,Boolean> f2 = obj::eqauls; //메서드 참조
  ```
  
  |종류| 람다                       |메서드 참조|
  |--------------------------|---|-------|
  |static 메서드 참조| (x)->ClassName.method(x) |ClassName::method|
  |인스턴스메서드 참조| (obj,x) -> obj.method(x) |ClassName::method|
  |특정 객체 인스턴스메슫 참조| (x) -> obj.method(x)     | obj::method|

  - 하나의 메서드만 호출하는 람다식은 '클래스이름::메서드이름'또는 참조변수::메서드이름'으로 바꿀 수 있다.

  - 생성자의 메서드 참조
      ```java
      Supplier<MyClass> s = () -> new MyClass(); // 람다식
      Supplier<MyClass> s = MyClass::new; //메서드 참조
      ```

- 스트림(stream)
  - 스트림은 데이터소스를 추상화하고 데이터를 다루는데 자주 사용되는 메서드들을 정의해 놓았다. 데이터를 추상화하였다는 것은, 데이터 소스가 무엇이던 간에 같은 방식으로 다룰 수 있게 되었다는 것과 코드의 재사용성이 높아진다는 것을 의미한다.
  - 스트림은 데이터 소스를 변경하지 않는다. 스트림은 데이터 소스로 부터 데이터를 읽기만할 뿐, 데이터 소스를 변경하지 않는다는 차이가 있다. 필요하다면, 정렬된 결과를 컬렉션이나 배열에 담아서 반환할 수도 있다.
  - 스트림은 Iterator처럼 일회용이다. Iterator로 컬렉션의 요소를 모두 읽고 나면 다시 사용할 수 없는 것처럼, 스트림도 한번 사용하면 닫혀서 다시 사용할 수 없다. 필요하면 다시 생성해야한다.
  - 스트림은 작업을 내부 반복으로 처리한다. 스트림을 이용한 작업이 간결할 수 있는 비결중의 하나가 바로 '내부 반복'이다. 내부 반복이라는 것은 반복문을 메서드의 내부에 숨길수 있다는 것을 의미한다. forEach()는 스트림에 정의된 메서드 중의 하나로 매개변수에 대입된 람다식을 데이터 소스의 모든 요소에 적용한다.
- 스트림의 연산
  - 스트림이 제공하는 다양한 연산을 이용해서 복잡한 작업들을 간단히 처리할 수 있다. 마치 데이터베이스에 SELECT문으로 질의(쿼리,query)하는 것과 같은 느낌이다.
  - 스트림이 제공하는 연산은 중간연산과 최종연산으로 분류할 수 있는데, 중간연산은 연산결과를 스트림으로 반환하기 때문에 중간연산을 연속해서 연결할 수 있다. 반면에 최종연산은 스트림의 요소를 소모하면서 연산을 수행하므로 단 한번만 연산이 가능하다.
  ```java
    stream.distinct().limit(5).sorted().forEach(System.out::println)
  ```
  - 스트림의 중간연산 목록

    | 중간연산                                       | 설명                                         |
    |--------------------------------------------|---|
    | Stream<T> distinct()                       | 중복을 제거                                     |
    | Stream<T> filter(Predicate<T> predicate)   | 조건에 안 맞는 요소 제외                             |
    | Stream<T> limit(long maxSize)              | 스트림의 일부를 잘라낸다.                             |
    | Stream<T> skip(long n)                     | 스트림의 일부를 건너뛴다.                             |
    | Stream<T> peek(Consumer<T> action)         | 스트림의 요소에 작업수행                              |
    | Stream<T> sorted()                         | 스트림의 요소를 정렬한다.                             |
    | Stream<T> sorted(Comparator<T> comparator) | 스트림의 요소를 정렬한다.                             |
    | Stream<R> map(Function<T,R> mapper)        | 스트림의 요소를 변환한다.                             |
    | DoubleStream mapToDouble(ToDoubleFunction<T> mapper)| 스트림의 요소를 변환한다.                             |
    | IntStream mapToInt(ToIntFunction<T> mapper) | 스트림의 요소를 변환한다.                             |
    | LongStream mapToLong(ToLongFunction<T> mapper)| 스트림의 요소를 변환한다.                             |
    | Stream<R> flatMap(Function<T,Stream<R>> mapper)| 스트림의 요소를 변환한다.                             |
    | DoubleStream flatMapToDouble(Function<T,DoubleStream> m)| 스트림의 요소를 변환한다.                             |
    | IntStream flatMapToInt(Function<T,IntStream> m)| 스트림의 요소를 변환한다.                             |
    | LongStream flatMapToLong(Function<T,LongStream> m)| 스트림의 요소를 변환한다.                             |

  - 스트림 최종 연산 목록

    | 최종연산                                                                                | 설명 |
    |-------------------------------------------------------------------------------------| --- |
    | void forEach(Counsumer<? super T> action                                            | 각 요소에 지정된 작업 수행|
    | void forEachOrdered(Counsumer<? super T> action                                     | 각 요소에 지정된 작업 수행|
    | long count()                                                                        | 스트림의 요소의 개수 반환|
    | optional<T> max(Comparator<? super T> comparator                                    | 스트림의 최대값/최소값을 반환|
    | optional<T> min(Comparator<? super T> comparator                                    | 스트림의 최대값/최소값을 반환|
    | Optional<T> findAny()                                                               | 스트림의 요소 하나를 반환|
    | Optional<T> findFirst()                                                             | 스트림의 요소 하나를 반환|
    | boolean allMatch(Predicate<T> p)                                                    | 주어진 조건을 모든 요소가 만족시키는지, 만족시키지 않는지 확인|
    | boolean anyMatch(Predicate<T> p)                                                    | 주어진 조건을 모든 요소가 만족시키는지, 만족시키지 않는지 확인|
    | boolean noneMatch(Predicate<T> p)                                                   | 주어진 조건을 모든 요소가 만족시키는지, 만족시키지 않는지 확인|
    | Object[] toArray()                                                                  | 스트림의 모든 요소를 배열로 반환|
    | A[] toArray(IntFunction<A []> generator)                                            | 스트림의 모든 요소를 배열로 반환|
    | Optional<T> reduce(BinaryOperator<T> accumulator)                                   | 스트림의 요소를 하나씩 줄여 가면서(리듀싱) 계산한다.|
    | T reduce(T identity,BinaryOperator<T> accumulator)                                  | 스트림의 요소를 하나씩 줄여 가면서(리듀싱) 계산한다.|
    | U reduce(U identity,BinaryOperator<T> accumulator,BinaryOperator<U> combiner)       | 스트림의 요소를 하나씩 줄여 가면서(리듀싱) 계산한다.|
    | R collect(Collector<T,A,R> collector                                                | 스트림의 요소를 수집한다. 주로 요소를 그룹화하거나 분활한 결과를 컬렉션에 담아 반환하는데 사용된다.|
    | R collect(Supplier<R> supplier, BiConsumer<R,T> accumlator,BiConsumer<R,T> combiner | 스트림의 요소를 수집한다. 주로 요소를 그룹화하거나 분활한 결과를 컬렉션에 담아 반환하는데 사용된다.|

  -  지연된 연산
      - 스트림 연산에서 한 가지 중요한 점은 최종 연산이 수행되기 전까지 중간 연산이 수행되지 않는다는 것이다. 스트림에 대해 distinct()나 sort()같은 중간 연산을 호출해도 즉각적인 연산이 수행되는 것은 아니라는 것이다. 중간 연산을 호출하는 것은 단지 어떤 작업이 수행 되어야 하는지를 지정해주는 것일 뿐이다. 최종 연산이 수행 되어야 비로소 스트림의 요소들이 중간연산을 거쳐 최종 연산에서 소모된다.

  
    
    

    

















        





        

