package ch6;

public class Ex7 {

    public static void main(String[] args) {
        firstMethod();
    }

    static void firstMethod() {
        secondMethod();
    }

    static void secondMethod() {
        System.out.println("secondMethod");
    }

}
