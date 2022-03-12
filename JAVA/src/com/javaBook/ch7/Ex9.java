package com.javaBook.ch7;

//기본형 매개변수는 값을 읽기만 할수있고, 참조형 매개변수는 값을 읽고 변경할수있다.

public class Ex9 extends Exception {
    public static void main(String[] args) {
        Data d1 = new Data();
        d1.x = 10;
        System.out.println("Primitive Param main(): x = " + d1.x);

        Pchange(d1.x);
        System.out.println("Primitive Param After Change(d.x");
        System.out.println("Primitive Param main() : x  = "+d1.x);

        Data d2 = new Data();
        d2.x = 10;
        System.out.println("Primitive Param main(): x = " + d2.x);

        Rchange(d2);
        System.out.println("Primitive Param After Change(d2.x");
        System.out.println("Primitive Param main() : x  = "+d2.x);
    }

    private static void Pchange(int x) {
        x=1000;
        System.out.println("Pchange():x = " + x);
    }

    private static void Rchange(Data d) {
        d.x=1000;
        System.out.println("Rchange():x = " + d.x);
    }
}

class Data{
    int x;
}
