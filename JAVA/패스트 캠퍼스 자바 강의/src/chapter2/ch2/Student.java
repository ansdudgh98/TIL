package chapter2.ch2;

public class Student {
    public int studentID; //클래스의 속성
    public String studentName;
    public String address;

    public void showStudentInfo(){
        System.out.println(studentID+","+studentName + "," + address);
    }
    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String name){
        studentName = name;
    }
}
