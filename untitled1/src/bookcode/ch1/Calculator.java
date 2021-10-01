package bookcode.ch1;

public class Calculator {
    int add(int i,int j){
        return i + j;
    }
    int sub(int i,int j){
        return i-j;
    }
    int multiply(int i,int j){
        return i*j;
    }
    int divide(int i,int j){
        return i/j;
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.add(5,4));
        System.out.print(cal.add(5,4));
        System.out.print(cal.sub(2,6));
        System.out.print(cal.divide(5,4));
    }



}
