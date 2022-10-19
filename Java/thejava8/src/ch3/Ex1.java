package ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");


        for (String s : name) {
            System.out.println(s.toUpperCase());
        }
        

        System.out.println("===============");



        List<String> collect = name.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("===============");

        name.forEach(System.out::println);

        System.out.println("===============");

        List<String> collection = name.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collection.forEach(System.out::println);
    }
}
