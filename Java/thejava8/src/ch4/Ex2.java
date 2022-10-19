package ch4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ex2 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(5,"rest api development",false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = spring.isPresent();
        System.out.println(present);

        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean jpapresent = jpa.isEmpty();
        System.out.println(jpapresent);

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        OnlineClass onlineClass = optional.get();
        System.out.println(onlineClass.getTitle());

        optional.ifPresent(oc->{System.out.println(oc.getTitle());});

        OnlineClass onlineClass1 = optional.orElseGet(Ex2::createNewClasses);

        Optional<OnlineClass> optional1 = optional
                .filter(oc -> !oc.isClosed());

        System.out.println(optional1.isEmpty());



    }

    private static OnlineClass createNewClasses() {
        System.out.println("creating new online classses");
        return new OnlineClass(10,"New class",false);
    }
}
