- **상속**
    - 정의 : 기존의 클래스를 재사용 하여 새로운 클래스를 작성하는 것이다.
    - 구현 방법 : 새로 작성하고자 하는 클래스의 이름 뒤에 상속받고자 하는 이름을 키워드 extents와 함께 써 주면 된다.

    ```java
    class Child extends Parent{
    		//...
    }
    ```

    - 표현
        1. 조상클래스 : 부모(parent)클래스,상위(super)클래스,기반(base)클래스
        2. 자손클래스 : 자식(child)클래스, 하위(sub)클래스, 파생된(derived)클래스

      <그림>

    - 특징
        1. 생성자와 초기화 블럭은 상속되지 않는다. 멤버만 상속된다.
        2. 자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거다 많다.
    - 장점
        1. 상속관계를 이용하여 프로그램의 코드 중복을 최소화 시켜준다.
        2. 클래스간 상속관계를 맺어 클래스의 공통적인 부분은 조상 클래스에서 관리하고 자손 클래스는 자신에 정의된 멤버만 관리하면 된다.
- 클래스간의 관계
    - 포함(composite) 관계

      정의 : 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것을 뜻한다.

      장점 : 단위별로 여러개의 클래스를 작성한 다음, 이 단위 클래스들을 포함 관계로 재사용하면 보다 간결하고 손쉽게 클래스를 작성할수있고, 작성된 단위 클래스들은 다른 클래스들을 작성하는데 재사용이 될

      수있다.

        - 예

        ```java
        class Circle {
        	int x;
        	int y;
        	int r;
        } // Circle 코드를 아래와 같이 개선할수있음
        
        class Point {
        	int x;
        	int y;
        }
        
        class Circle{
        	Point c = new Point(); // 원점
        	int r;
        }
        ```

    - 클래스간의 관계 결정하기
        1. 상속관계 ‘~은 ~이다(is-a)’
        2. 포함관계 ‘~은 ~을 가지고 있다.(has-a)’

      예)

      원(Circle)은 점(Point)이다. - Circle is a Point.

      원(Circle)은 점(Point)을 가지고 있다. - Circle has a Point.

- 단일 상속(single inheritance)
    - 다른 객체지향 언어인 C++에서는 여러 조상 클래스로부터 상속받는 것이 가능한 ‘다중 상속(multiple inheritance)을 허용하지만 자바에서는 오직 단일 상속만을 허용함
    - 다중 상속을 허용하는 경우 여러 클래스로부터 상속받을 수 있기 때문에 복합적인 기능을 가진 클래스를 쉽게 작성할수있지만 클래스의 관계가 매우 복잡해져서 자바에서는 이런 문제점을 해결하기 위해 단일상속만을 허용한다.
- Object클래스
    - Object클래스는 모든 클래스 상속계층도의 최상위에 있는 조상클래스이다. 다른 클래스로부터 상속 받지 않는 모든 클래스들은 자동적으로 Object클래스로부터 상속받게 함

    ```java
    Class Tv{
    	...
    }	
    위의 코드는 아래의 extends Object 코드가 생략 된것임.
    Class Tv extends Object{
    }
    ```

    - 상속 계층도

      <그림>

- 오버라이딩(overriding)
    - 정의 : 조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것
    - 자손 클래스 자신에 맞게 변경해야하는 경우가 많은데 이럴 때 조상의 메서드를 오버라이딩한다.
    - 예

    ```java
    class Point{
    	int x;
    	int y;
    
    	String getLocation(){
    		return "x : " + x + ", y :" + y;
    	}
    }
    
    class Point{
    	int x;
    	int y;
    	String getLocation(){
    		return "x : " + x + ", y :" + y + ", z:" + z;
    	}
    }
    
    ```

    - 조건
        1. 자손클래스에서 오버라이딩하는 메서드는 조상 클래스의 메서드와 이름이 같아야 한다.
        2. 자손클래스에서 오버라이딩하는 메서드는 조상 클래스의 메서드와 매개변수가 같아야 한다.
        3. 자손클래스에서 오버라이딩하는 메서드는 조상 클래스의 메서드와 반환타입이 같아야 한다.
        4. 선언부가 서로 일치해야 하지만 접근 제어자(access modifier)와 예외(exception)는 제한된 조건하에 다르게 변경할 수 있음
            1. 접근 제어자는 조상 클래스의 메서드보다 좁은 범위로 변경 할 수 없다.(ex. 기존 protected → default,private는 불가능)
            2. 조상 클래스의 메서드보다 많은 수의 예외를 선언 할수 없다.
            3. 인스턴스 메서드를 static메서드로 또는 그 반대로 변경할 수 없다.
- 오버로딩 vs 오버라이딩
    - 오버로딩(overloading) : 기존에 없는 새로운 메서드를 정의하는 것(new)
    - 오버라이딩(overriding) : 상속받은 메서드의 내용을 변경하는 것(change, modifiy)

    ```java
    class Parent{
    	void parentMethod(){}
    }
    
    class Child extends Parent{
    	void parentMethod(){}
    	void parentMethod(int i ){}
    	
    	void childMethod(){}
    	void childMethod(int i){}
    	void childMethod(){} //에러, 중복정의 되었음 
    }
    ```