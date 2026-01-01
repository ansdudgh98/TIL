- 열거형(enums)
  - 열거형은 서로 상수를 편리하게 선언하기 위한 것으로 여러 상후를 정의할 때 사용하면 유용하다.
  - 열거형으로 갖는 값 뿐만 아니라 타입도 관리하기 때문에 보다 논리적인 오류를 줄일수 있다.
  ```java
    public class Card {
    static final int CLOVER = 0;
    static final int Heart = 1;
    static final int DIAMOND = 2;
    static final int SPADE = 3;

    static final int TWO = 0;
    static final int THREE = 1;
    static final int FOUR = 2;

    final int kind;
    final int num;
    }

    //아래와 ENUM을 사용하여 같이 개선 가능

    public class Card {
    enum Kind {CLOVER,HEART,DIAMOND,SPADE}
    enum Value {TWO,THREE,FOUR}

    final Kind kind;
    final Value value;
    }
  ```
  - 기존의 많은 언어들 예를 들어 C언어에서는 타입이 달라도 값이 같으면 조건식 결과가 참(true)이였으나, 자바의 열거형은 '타입에 안전한 열거형(typesafe enum)'이여서 실제 값이 같아도 타입이 다르면 컴파일 에러가 발생한다.
  ```java
    if(Card.CLOVER == CARD.TWO) // true 지만 false여야 의미가 맞음.
    if(Card.Kind.CLOVER == CARD.Value.TWO) // 컴파일 에러. 값은 같지만 타입이 다름
  ```
- 열거형의 정의와 사용
  - 열겨형을 사용하는 방법은 아래와 같이 괄호{}안에 상수의 이름을 나열하기만 하면 된다.
  ```java
    enum{열거형 이름} {상수명1, 상수명2, ....}

    enum Direction {EAST, SOUTH, WEST, NORTH}

    **사용법**
    dir = Direction.EAST; //클래스의 static 변수를 참조하는 것과 동일하다.
  ```
  - 열거형 상수간의 비교에는 "=="를 사용 할 수 있다. equlas가 아닌 ==로 비교가 가능하다는 것은 그만큼 빠른 성능을 제공한다는 이야기이다. 그러나 <,>와 같은 비교연산자는 사용할 수 없고 compareTo()는 사용 가능하다.
  - Switch문의 조건식에도 사용이 가능한데 case문에 열거형의 이름을 적지않고 상수의 이름만 적어야 한다.
- enum클래스에 정의된 메소드
  |메서드|설명|
  |----|---|
  |Class<E> getDeclaringClass()|열거형의 Class객체를 반환한다.|
  |String name()|열거형 상수의 이름을 문자열로 반환한다.|
  |int ordinal()|열거형 상수의 정의된 순서를 반환한다.(0부터 시작)|
  |T valueOf(Class<T> enumType,String name)|지정된 열거형에서 name과 일치하는 열거형 상수를 반환한다.|
  - 이 외에도 아래와 같이 컴파일러가 자동으로 추가해주는 메서드가 하나 더 있다.
  ```java
  static E values()
  static E valueOf(String name)
  ```
- 열거형에 멤버 추가하기
  - Enum클래스에 정의된 ordinal()이 열거형 상수가 정의된 순서를 반환하지만, 이 값을 열거형 상수의 값으로 사용하지 않는 것이 좋다.
  - 열거형 상수의 값이 불 연속적인 경우에는 아래와 같이 결거형 상수의 이름 옆에 원하는 값을 괄호()와 함께 적어주면 된다.
  ```java
    enum Direction {EAST(1),SOUTH(5),WEST(-1),NORTH(10)}
  ``` 
  - 지정된 값을 저장할 수 있는 인스턴스 변수와 생성자를 새로 추가해 주어야 한다.
  - 이때 주의할 점은 먼저 열거형 상수를 모두 정의한 다음에 다른 멤버들을 추가해야한다는 것이다. 또한 열거형 상수 마지막에 ;도 잊지 말아야 한다.
  ```java
    enum Direction{
      EAST(1),SOUTH(5),WEST(-1),NORTH(10);

      private final int value;
      Direction(int value){this.value = value}

      public int getValue(){return value;}
    }
  ```
  - 열거형의 인스턴스 변수는 반드시 final이어야 한다는 제약은 없지만 value는 열거형 상수의 값을 저장하기 위한 것이므로 final을 붙였다.
  - 열거형 Direction에 새로운 생성자가 추가 되었지만 "Direction d = new Direction(1);"과 같은 객체를 생성할 수 없다. 열거형 생성자는 제어자가 묵시적으로 private이기 때문이다.
  - 필요하다면 아래와 같이 하나의 열거형 상수에 여러 값을 지정할 수도 있다. 다만 그에 맞게 인스턴스 변수와 생성자 등을 새로 추가해주어야 한다.
  ```java
    enum Direction{
      EAST(1,">"),SOUTH(5,"V"),WEST(-1,"<"),NORTH(10,"^");

      private final int value;
      private final String symbol;
      Direction(int value, String symbol){
        this.value = value
        this.symbol = symobl  
      }

      public int getValue(){return value;}
      public int getSymbol(){return symbol;}
    }
  ``` 
  - 열거형에 추상 메서드 추가할수도 있다.

