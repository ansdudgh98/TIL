package ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Ex2 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        name.forEach(System.out::println);
        Spliterator<String> spliterator = name.spliterator();
        while(spliterator.tryAdvance(System.out::println));

        name.removeIf(s->s.startsWith("k"));
        name.sort(String::compareToIgnoreCase);
    }
}
