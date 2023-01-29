- 지네릭스(Generics)
  - 지네릭스는 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입체크(compile-time type check)를 해주는 기능이다. 객체의 타입을 컴파일 시에 체크하기 때문에 객체의 타입 안정성을 높이고 형변환의 번거로움이 줄어든다.
  - 타입 안정성을 높인다는 것은 의도하지 않은 타입의 객체가 저장되는 것을 막고, 저장된 객체를 꺼내올 때 원래의 타입과 다른 타임으로 잘못 형변환되어 발생할 수 있는 오류를 줄어준다는 뜻이다.
- 지네릭스의 장점
  - 타입 안정성을 제공한다.
  - 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해 진다.
- 지네릭 클래스의 선언
  ```java
    Class Box{
        Object item;
        void setItem(Object item){this.item = item;}
        Object getItem(){return item;}
    }

    ----> 지네릭스 클래스로 변경
    
    Class Box<T>{
        T item;

        void setItem(T item){this.item = item;}
        T getItem(){return item;}
    }
  ```  
    - T의 경우 Type의 T를 따온것이고 기호의 종류는 상황에 맞게 달라질수 있으며 종류만 모두 다를뿐 '임의의 참조형 타입'을 의미하는 것은 모두 같다.
- 지네릭스의 용어
  ```java
      class Box<T>{}
  ```
  - Box<T> : 지네릭 클래스 'T'의 Box 또는 'T Box'라고 읽는다.
  - T 타입 변수 또는 타입 매개변수(T는 타입 문자)
  - Box : 원시타입
- 지네릭스의 제한
  - 지네릭 클래를 생성할 때, 객체별로 다른 타입을 지정하는 것은 적절하다. 하지만 모든 객체에 대해 동일하게 동작해야 하는 static멤버에 타입 변수 T를 사용할 수 없다. T는 인스턴스 변수로 간주되기 때문에 static멤버는 인스턴스변수를 참조할수 없다.
  - 지네릭 배열은 생성이 불가능 한데 이는 new 연산자 때문이다. new 연산자는 컴파일 시점에 타입 T가 뭔지 정확히 알아야 하지만 컴파일 시점에는 T가 어떤 타입이 될지 전혀 알 수 없다. 같은 맥락으로 instanceof연산자도 new연산자와 같은 이유로 T를 피 연산자로 사용할 수 없다.
  - 꼭 지네릭 배열을 생성해야되면 Reflection API의 new Instance()와 같이 동적으로 객체를 생성하는 메서드로 배열을 생성하거나 Object배열을 복사한다음 T[]로 형변환 하는 방법등을 사용한다.
- 지네릭 클래스의 객체 생성과 사용
  - 지네릭 클래스를 생성할 때에는 참조변수와 생성자에 대입된 타입(매개변수화된 타입)이 일치해야 한다. 일치하지 않는 경우에는 에러가 발생한고 상속관계에 있어서도 마찬가지다.
  ```java
      Box<Apple> appleBox = new Box<Apple>(); //OK
      Box<Apple> appleBox = new Box<Grape>(); //에러
      //Apple이 Fruit의 자손이라고 가정
      Box<Apple> appleBox = new Box<Grape>(); //에러 대입된 타입이 다르다.
  ```
  - 두 지네릭 클래스의 타입이 상속 관계에 있고,대입된 타입이 같은 것은 괜찮다.
  ```java
      //FruitBox가 Box의 자손이라고 가정
      Box<Apple> appleBox = new FruitBox<Apple>();//OK
  ```
  - JDK1.7부터는 추정이 가능한 경우 타입을 생략할 수 있게 되었다. 참조변수의 타입으로 부터 Box가 Apple타입의 객체만 저장한다는 것을 알 수 있기때문에 생성자에 반복해서 타입을 짖어해주지 않아도 된다.
  ```java
      Box<Apple> appleBox = new Box<Apple>();
      Box<Apple> appleBox = new Box<>(); //생략가능
  ```
  - 생성된 Box<T>의 객체에 void add(T item)으로 객체를 추가할 떄,대입된 타입과 다른 타입의 객체는 추가할 수 없다.
  ```java
      Box<Apple> appleBox = new Box<Apple>();
      appleBox.add(new Apple()) //Ok
      appleBox.add(new Grape()) //에러
  ```
  - 타입 T가 Fruit인 경우 void add(Fruit item)가 되므로 Fruit의 자손들은 이 메서드의 매개변수가 될 수 있다. 
  ```java
      //Apple이 Fruit의 자손이라고 가정
      Box<Fruit> fruitBox = new Box<Fruit>();
      fruitBox.add(new Fruit()); OK
      fruitBox.add(new Apple()); OK
  ```
- 제한된 지네릭 클래스
  - 타입 문자로 사용할 타입을 명시하면 한 종류의 타입만 저장할 수 있도록 제한할 수 있지만, 그래도 여전히 모든 종류의 타입을 지정할 수 있다는 것에는 변함이 없다.
  - 따라서 지네릭 클래스의 타입을 제한하기위해 지네릭 타입에 extends를 사용하면, 특정 타입의 자손들만 대입할수 있게 제한할 수 있다.
  ```java
      class Fruit<T exteds Fruit>{
          ArrayList<T> list = new ArrayList<T>();
          ...
      }
  ```
  - 만일 클래스가 아니라 인터페이스를 구현해야 한다는 제약이 필요하면 이때도 extends를 사용한다. implements를 사용하지 않는다.
  - 클래스Fruit의 자손이면서 Eatable인터페이스도 구현해야한다면 아래와 같이 &기호로 연결한다.
  ```java
      class FruitBox<T extends Fruit & Eatable>{...}
  ```
- 와일드 카드
  ```java
      class Jucier{
          static Juice makeJuice(FruitBox<Fruit> box){
              string tmp = "";
              for(Fruit f : box.getList()) tmp += f + "";
              return new Juice(tmp);
          }
      }

      FruitBox<Fruit> fruitBox = new FruitBox<Fruit>(); --- 1
      FruitBox<Apple> appleBox = new FruitBox<Apple>(); 

      System.out.println(Jucier.makeJuice(fruitBox)); //OK
      System.out.println(Jucier.makeJuice(appleBox)); //에러

      static Juice makeJuice(FruitBox<Fruit> box){...}
      static Juice makeJuice(FruitBox<Apple> box){...}
  ```
  - Juicer클래스는 지네릭 클래스가 아닌데다, 지네릭 클래스라고 해도 static메서드에는 타입 매개변수 T를 매개변수에 사용할 수 없으므로 아예 지네릭스를 적용하지 않던가, 1과 같이 타입 매개변수 대신 특정타입을 지정해줘야 한다. 하지만 지네릭 타입을 Fruit<Fruit>로 고정해 놓으면,위의 코드에서 알 수 있듯이 FruitBox<Apple>타입의 객체는 makeJuice()매게변수가 될 수 없으므로 여려개의 타입의 매개변수를 갖는 메서드를 만들 수 밖에 없다.
  - 그러나 마지막 2개의 메서드와 같이 오버로딩을 하게 되면 컴파일 에러가 발생한다. 지네릭 타입이 다른 것만으로는 오버로딩이 성립하지 않기 때문이다. 이럴때 사용하기 위해 고안된 것이 와일드 카드 이다. 와일드 카드는 기호 ?로 표현하는데 와일드 카드는 어떠한 타입도 될 수 있다.
  - ?만으로는 Object타입과 다를 게 없으므로, 다음과 같이 extends와 super로 상한(upper bound)과 하한(lower bound)을 제한할 수 있다.
  ```
    <? extends T> 와일드 카드의 상한 제한,T와 그 자손들만 가능
    <? super T> 와일드 카드의 하한 제한,T와 그 조상들만 가능
    <?> 제한 없음, 모든 타입이 가능<? extends Object>와 동일
  ```
  - 와일드 카드를 사용해서 makeJuice()의 매개변수 타입을 FruitBox<Fruit>에서 FruitBox<? extends Fruit>으로 바꾸면 FruitBox<Fruit>뿐만 아니라 FruitBox<Apple>와 FruitBox<Grape>도 가능하게 된다.
  ```java
    static Juice makeJuice(FruitBox<? extends Fruit> box){
        string tmp = "";
        for(Fruit f : box.getList()) tmp += f + "";
        return new Juice(tmp);
    }
  ```
  - 매개변수의 타입을 FruitBox<? extends Object>로 하면 모든 종류의 FruitBox가 이 메서드의 매개변수로 가능해진다. 대신, 전과 달리 box의 요소가 Fruit의 자손이라는 보장이 없으므로 아래의 for문에서 box에 저장된 요소를 Fruit타입의 참조변수로 못받는다. 하지만 실제로 테스트를 해보면 문제없이 컴파일이 되는데 그 이유는 지네릭 클래스에서 FruitBox를 제한하였기 때문이다. 컴파일러는 위 문장으로 부터 모든 FruitBox의 요소들이 Fruit의 자손이라는 것을 알고 있으므로 문제 삼지 않는 것이다.
- 지네릭 메서드
  - 메서드의 선언부에 지네릭 타입이 선언된 메서드를 지네릭 메서드라 한다.
  - Collections.sort()가 지네릭 메서드이며, 지네릭 타입의 선언 위치는 반환 타입 바로 앞이다.
  - 아래와 같이 지네릭 클래스에 정의된 타입 매개변수와 지네릭 메서드에 정의된 타입 매개변수는 전혀 별개의 것이다. 같은 타입 문자 T를 사용해도 같은 것이 아니라는 것에 주의해야된다.
  - 지네릭 메서드는 지네릭 클래스가 아닌 클래스에도 정의될수있다.
  ```java
    class FruitBox<T>{
      ...
      static <T> void sort(List<T> list,Comparator<? super T > c){
        ...
      }
    }
  ```
  - static멤버에는 타입 매개변수를 사용할 수 없지만, 메서드에 지네릭 타입을 선언하고 사용하는 것은 가능하다.
  - 메서드에 선언된 지네릭 타입은 지역 변수를 선언한거와 같다.
  - 위에 makeJuice()를 지네릭 메서드로 바꿀수 있다.
  ```java
    static <T extends Fruit> Juice makeJuice(FruitBox<T> box){
      string tmp = "";
      for(Fruit f : box.getList()) tmp += f + "";
      return new Juice(tmp);
    }
  ```
  - 위의 메서드를 호출할 떄는 아래와 같이 타입 변수에 타입을 대입해야한다.
  ```java
    FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
    FruitBox<Apple> appleBox = new FruitBox<APple>();

    System.out.println(Juicer.<Fruit>makeJuice(fruitBox));
    System.out.println(Juicer.<Apple>makeJuice(Apple));

    ** 대부분의 경우 컴파일러가 타입 추정할 수 있기 때문에 아래와 같이 생략이 가능 **
    System.out.println(Juicer.makeJuice(fruitBox));
    System.out.println(Juicer.makeJuice(Apple));

    **지네릭 메서드를 호출할 때,클래스이름이나 참조변수를 생략할수없음 **
    System.out.println(<Fruit>makeJuice(fruitBox));  //에러 클래스 이름 생략 불가
    System.out.println(this.<Fruit>makeJuice(fruitBox)); //가능
    System.out.println(Juicer.<Fruit>makeJuice(fruitBox)); //가능
  ```
  - 지네릭 메서드는 매개변수의 타입이 복잡할 때도 유용한데, 아래와 같은 코드가 있다면 타입을 별도로 선언함으로써 코드를 간략히 할 수 있다.
  ```java
    public static void printAll(ArrayList<? extends Product> list,
                              ArrayList<?extends Product> list2){
                                ...
    }

    public static <T extends Product> void printAll(ArrayList<T> list,
                              ArrayList<T> list2){
                                ...
    }
  ```
- 지네릭 타입의 형변환
```java
  Box box = null;
  Box<Objcct> objBox = null;
  
  ** 경고발생 **
  box = (box)objBox; // 가능 지네릭 타입 -> 원시타입
  objBox = (Box(Object)box); // 원시타입 -> 지네릭 타입
```
- 지네릭 타입과 넌지네릭(non-generic)타입간의 형변환은 항상 가능하다. 다만 경고가 발생할 뿐이다.
- 대입된 타입이 다른 지네릭 타입간엔는 형변환이 Object여도 불가능하다.
- 다만 매개변수에 다형성이 적용되어서 Box<String> 이 Box<? extends Object>와 같은 경우 형변환이 가능하다.

- 지네릭 타입의 제거
- 컴파일러는 지네릭 타입을 이용해서 소스코드 파일을 체크하고, 필요한 곳에 형변환을 넣어준다. 그리고 지네릭 타입을 제거한다. 즉 컴파일된 파일(*.class)에는 지네릭 타입에 대한 정보가 없는 것이다.
- 위의 내용과 같이 하는 주된 이유는 지네릭이 도입되기 전에 이전의 소스코드와 호환성을 유지하기 위해서이다.
- 지네릭 타입의 기본적인 제거과정은 아래와 같다.
  1. 지네릭 타입의 경계(bound)를 제거한다.
  2. 지네릭 타입을 제거한 후에 타입이 일치하지않으면 형변환을 추가한다.
    
  