package chapter2.ch1;

/*
  패스트캠퍼스 part2 객체지향 프로그래밍 객체지향 입문 강의의 함수와 메서드 강의 내용 코드
  함수를 구현한 코드이며 지역변수에 대한 설명을 들었음
  함수안에 구현한 변수는 스택메모리에 저장되어 구현이 됨
  메소드도 동일한 방식

*/


public class FunctionTest {

    public static int addNum(int num1,int num2){
        int result; //지역변수
        result = num1 + num2;
        return result;
    }

    public static void sayHello(String greeting){
        System.out.println(greeting);
    }

    public static int calcSum(){
        int sum=0;
        int i;

        for(i=0;i<=100;i++){
            sum+=1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 20;
        int total = addNum(n1,n2);
        sayHello("안녕하세요.");
        int num = calcSum();
        System.out.println(total);
        System.out.println(num);
    }
}
