package chapter2.ch2;

public class StudentTest {

    public static void main(String[] args) {

        Student studentLee = new Student(); // 생성자 불러옴
        // 인스턴스를 생성,참조변수 = 생성되는 곳에 위치를 나타내는 것
        studentLee.setStudentName("Lee"); //인스턴스의 값을 메소드를 이용하여 설정
        studentLee.address = "서울";
        studentLee.studentID = 12345;
        studentLee.showStudentInfo();

        Student studentKim = new Student();
        studentKim.studentName = "김유신";
        studentKim.address = "경주";
        studentKim.studentID = 54321;
        studentKim.showStudentInfo();

        System.out.println(studentLee); //@뒤에 나오는 것이 주소값 (참조값,reference value,가상 address)
        System.out.println(studentKim);

    }
}
