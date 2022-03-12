package com.javaBook.ch8;

public class Excepition7 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        System.out.println(1);
        System.out.println(2);
        for(int i =0;i<Integer.MAX_VALUE;i++){
        try {
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        }catch(ArithmeticException ae){
            if(ae instanceof ArithmeticException)
                System.out.println("TRUE");
            //System.out.println("ArithmeticException");
            ae.printStackTrace();
            System.out.println(ae.getMessage());
        }catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
            System.out.println(e.getMessage());
            }
        }
        long finishTime = System.currentTimeMillis();
        long elapsedTime = finishTime - startTime;
        System.out.println(elapsedTime + "ms");

    }
}
