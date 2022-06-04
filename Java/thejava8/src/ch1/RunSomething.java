package ch1;

@FunctionalInterface
public interface RunSomething {
    //함수형 인터페이스는 추상형 인터페이스가 한개 만 존재한다.
    //void doIt();

    int doIt(int number);

    static void printName(){
        System.out.println("YH");
    }

    default void printAge(){
        System.out.println("25");
    }

}
