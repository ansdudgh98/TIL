- Calendar와 Date
    - Date는 JDK1.0부터 제공되었던 클래스이며 Calendar는 Date클래스의 다음버전이며 JDK1.8부터 ‘java.time’패키지로 기존의 단점들을 개선한 새로운 클래스들이 추가되었다.
    - Calendar는 추상 클래스이기 때문에 직접 객체를 생성할 수 없고,메서드를 통해서 완전히 구현된 클래스의 인스턴스를 얻어야 한다.

    ```java
    Calendar cal = Calendar.getInstance(); //가능
    
    Calendar cal = new Calendar(); //추상클래스이기 때문에 Calenadr클래스를
    															 //구현한 클래스의 인스턴스를 반환 받아야 한다.
    
    ```

    - GregorianCalendar는 Calendar를 상속받아 오늘날 전세계 공통으로 사용하고 있는 그레고리력에 맞게 구현한 것으로 태국(BuddhistCalendar)을 제외한 나머지 국가에서는 GregorianCalendar를 사용하면 된다.
    - 인스턴스를 직접 생성하지 않고 이처럼 메서드를 통해서 인스턴스를 반환받게 하는 이유는 최소한의 변경으로 프로그램이 동작할 수 있도록 하기 위한 것이다.
- 형식화 클래스
    - 형식화 클래스는 ‘java.text’패키지에 포함되어 있으며 숫자,날짜,텍스트 데이터를 일정한 형식에 맞게 표현할 수 있는 방법을 객체지향적으로 설계하여 표준화 한 클래스이다.
    - 형식화 클래스는 형식화에 사용될 패턴을 정의하는데, 데이터를 정의된 패턴에 맞춰 형식화할수 있을 뿐만 아니라 역으로 형식화된 데이터에서 원래의 데이터를 얻어낼 수도 있다.
- DemicalFormat
    - 형식화 클래스 중에서 숫자를 형식화 하는데 사용되는 것이 DemicalFormat이다.
    - 숫자데이터를 정수,부동소수점,금액등의 다양한 형식으로 표현할 수 있으며,반대로 일정한 형식의 텍스트 데이터를 숫자로 쉽게 변환하는 것도 가능하다.
    - 사용방법

    ```java
    double number = 1234567.89;
    DecimalFormat df = new DemicalFormat("#.#E0");
    String result = df.format(number);
    ```

- SimepleDateFormat
    - Date와 Calendar만으로 날짜 데이터를 원하는 형태로 다양하게 출력하는 것은 불편하고 복잡하지만,SimpleDateFormat을 사용하면 이러한 문제는 간단히 해결된다.

  | Letter | Date or Time Component | Presentation       | Examples |
      | --- |--------------------| --- | --- |
  | G | Era designator | Text               | AD |
  | y | Year | Year               | 1996; 96 |
  | Y | Week year | Year               | 2009; 09 |
  | M | Month in year | Month              | July; Jul; 07 |
  | w | Week in year | Number             | 27 |
  | W | Week in month | Number             | 2 |
  | D | Day in year | Number             | 189 |
  | d | Day in month | Number             | 10 |
  | F | Day of week in month | Number             | 2 |
  | E | Day name in week | Text               | Tuesday; Tue |
  | u | Day number of week (1 = Monday, ..., 7 = Sunday) | Number             | 1 |
  | a | Am/pm marker | Text               | PM |
  | H | Hour in day (0-23) | Number             | 0 |
  | k | Hour in day (1-24) | Number             | 24 |
  | K | Hour in am/pm (0-11) | Number             | 0 |
  | h | Hour in am/pm (1-12) | Number             | 12 |
  | m | Minute in hour | Number             | 30 |
  | s | Second in minute | Number             | 55 |
  | S | Millisecond | Number             | 978 |
  | z | Time zone | General Time zone  | Pacific Standard Time; PST; GMT-08:00 |
  | Z | Time zone | RFC 822 time zone  | -0800 |
  | X | Time zone | ISO 8621 time zone | -08; -0800; -08:00 |

    ```java
    Date today = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    String result = df.format(today);
    ```

- ChoiceFormat
    - ChoiceFomat은 특정 범위에 속하는 값을 문자열로 변환해준다.

    ```java
    double[] limits = {60,70,80,90};
    
    String[] grades = {"D","C","B","A"};
    
    Choice Format form = new ChoiceFormat(limits,grades);
    
    ...
    ```

- MessageFormat
    - MessageFormat은 데이터를 정해진 양식에 맞게 출력할 수 있도록 도와준다.
    - 데이터가 들어갈 자리를 마련해 놓은 양식을 미리 작성하고 프로그램을 이용해서 다수의 데이터를 같은 양식으로 출력할 때 사용하면 좋다.

    ```java
    String msg = "Name : {0} \nTel : {1} \nAge:{2} \nBirthDay:{3};
    
    Object arguments = {...}
    
    String result = MessageFormat.format(msg,arguments);
    ```

- java.time패키지
    - Date와 Calendar가 가지고 있던 단점을 해소하기 위해 JDK1.8부터 등장한 패키지 이며 아래의 4개의 패키지를 가지고 있다.

  | 패키지 | 설명 |
      | --- | --- |
  | java.time | 날짜와 시간을 다루는데 필요한 핵심 클래스들을 제공 |
  | java.time.chrono | 표준(ISO)이 아닌 달력 시스템을 위한 클래스들을 제공 |
  | java.time.format | 날짜와 시간을 파싱하고, 형식화하기 위한 클래스들을 제공 |
  | java.time.temporal | 날짜와 시간의 필드(field)와 단위(unit)를 위한 클래스들을 제공 |
  | java.time.zone | 시간대(time-zone)와 관련된 클래스들을 제공 |
    - 위의 패키지들에 속한 클래스들의 가장 큰 특징은 String클래스처럼 “불변”하다는 것이다. 날짜나 시간을 변경하는 메서드들은 기존의 객체를 변경하는 대신 항상 변경된 새로운 객체를 반환한다.
- java.time 패키지의 핵심 클래스
    - 날짜와 시간을 하나로 표현하는 Calendar클래스와 달리 java.time패키지에는 날짜와 시간을 별도로 클래스로 분리해 놓았다. 시간을 표현할 때는 LocalTime클래스를 사용하고, 날짜를 표현할 때는 LocalDate클래스를 사용한다. 그리고 날짜와 시간이 모두 필요할때는 LocalDateTime클래스를 사용하면 된다.

        ```java
        LocalDate + LocalTime -> LocalDateTime
        날짜 + 시간 -> 날짜 & 시간
        
        여기에 시간대까지 다뤄야 한다면 ZonedDateTime클래스를 사용하면 된다.
        LocalDateTime + 시간대 -> ZonedDateTime
        ```

    - 객체 생성하기 - now(),of()
        - java.time패키지에 속한 클래스의 객체를 생성하는 가장 기본적인 방법은 now와 of()를 사용하는 것이다. now()는 현재 날짜와 시간을 저장하는 객체를 생성한다.
        - of는 단순히 필드의 값을 순서대로 지정해 주기만 하면 된다. 각 클래스마다 다양한 종류의 of()가 정의되어 있다.

        ```java
        //now
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        zonedDateTime dateTimeInKr = zonedDateTime.now();
        //of
        LocalDate date = LocalDate.of(2015,11,23);
        LocalDate time = LocalTime.of(23,59,59)
        LocalDateTime dateTime = LocalDateTime.of(date,time);
        ZonedDateTime zDateTim = ZonedDateTime.of(dateTIme,ZoneId.of("Asia/Seoul"));
        ```

- Period와 Duration
    - 날짜와 시간의 간격을 표현하기 위한 클래스도 있는데, Period는 두 날짜간의 차이를 표현하기 위한 것이고,Duration은 시간의 차이를 표현하기 위한 것이다.

        ```java
        날짜 - 날짜 = Period
        시간 - 시간 = Duration
        ```

- Temporal과 TemporalAmount
    - LocalDate,LocalTime,LocalDateTime,ZonedDateTime등 날짜와 시간을 표현하기 위한 클래스들은 모두 Temporal, TemporalAccessor,TemporalAdjuster인터페이스를 구현했고, Duration과 Period는 TemporalAmout인터페이스를 구현하였다.
    - Temporal, TemporalAccessor, TemporalAdjuster를 구현한 클래스
        - LocalDate, LocalTime,LocalDateTime,ZonedDateTime,Instatn등
    - TemporalAmount를 구현한 클래스
        - Period, Duration