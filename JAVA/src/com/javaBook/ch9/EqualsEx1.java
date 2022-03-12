package com.javaBook.ch9;

public class EqualsEx1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);

        if (v1.equals(v2)) {
            System.out.println("v1과 v2는 같습니다.");
        } else {
            System.out.println("v1과 v2는 다릅니다.");
        }

        System.out.println("v2=v1 before");
        v2  = v1;
        System.out.println("v2=v1 after");

        System.out.println("v1 = " + v1);
        System.out.println("v2 = " + v2);

        if (v1.equals(v2)) {
            System.out.println("v1과 v2는 같습니다.");
        } else {
            System.out.println("v1과 v2는 다릅니다.");

        }

    }

}
class Value {
    int value;
    Value(int value){
        this.value = value;
    }
}
