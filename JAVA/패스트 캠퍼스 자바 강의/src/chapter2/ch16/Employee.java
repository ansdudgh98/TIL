package chapter2.ch16;

public class Employee {

    private static int serialNum = 1000;

    private int employeeId;
    private String employeeName;
    private String department;

    public Employee(){
        serialNum++;
        employeeId = serialNum;
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }
    public static int getSerialNum(){


        return serialNum;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }



}
