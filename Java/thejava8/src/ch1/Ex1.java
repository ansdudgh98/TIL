package ch1;

public class Ex1 {
    public static void main(String[] args) {
        //람다 형태의 표현식
        //RunSomething runSomething = () -> System.out.println("hoy");
        RunSomething runSomething = (number)->{
            return number + 10;
        };
        /*익명 내부 클래스
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("hoy");
            }
        };*/

        System.out.println(runSomething.doIt(1));
    }
}
