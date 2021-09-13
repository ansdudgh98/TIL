package chapter2.ch18;

/*
*  싱글톤 패턴을 학습하는 강의
*  싱글톤 패턴은 유일하게 객체를 생성할 때 사용하는 패턴
*  Library 로는 Java.util.Calendar이 있음
* */


public class CompanyTest {
    public static void main(String[] args) {
        Company company1 = Company.getInstance();
        Company company2 = Company.getInstance();

        System.out.println(company1);
        System.out.println(company2);

    }

}
