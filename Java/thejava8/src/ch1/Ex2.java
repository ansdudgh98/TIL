package ch1;

import java.util.function.*;

public class Ex2 {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));
        //Function은 입력값이 1개
        Function<Integer, Integer> plus102 = (i) -> i+10;
        System.out.println(plus102.apply(2));
        Function<Integer, Integer> multiply2 = (i) -> i*2;
        Function<Integer, Integer> multly2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multly2AndPlus10.apply(10));
        System.out.println(plus10.andThen(multiply2).apply(2));

        Consumer<Integer> consumer = (i) -> System.out.println(i);
        consumer.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        Predicate<String> startsWithYh = (s) -> s.startsWith("YH");
        Predicate<Integer> isEven = (i) -> i%2 == 0;



    }
    static class Plus10 implements Function<Integer, Integer>{
        @Override
        public Integer apply(Integer integer) {
            return integer + 10;
        }
    }
}
