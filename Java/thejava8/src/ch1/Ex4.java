package ch1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ex4 {
    public static void main(String[] args) {
        //인스턴스 메소드
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;

        //인스턴스가 생성 되는 것이 아님
        Supplier<Greeting> newGreeting = Greeting::new;
        Function<String,Greeting> YHGreeting = Greeting::new;

        //스태틱 메서드
        UnaryOperator<String> hi = Greeting::hi;

        String[] names = {"keesun","whiteshop","toby"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));


    }
}
