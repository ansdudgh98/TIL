package chapter2.ch8;

public class UserInfo {

    public int userHeight;
    public int userWeight;
    public String userName;

    public UserInfo(int userHeight,int userWeight,String userName){
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.userName = userName;
    }

    public String ShowUserInfo(){
        return userName + "님의 키는 " + userHeight + "몸무게는 "+userWeight + " 입니다.";
    }

    public static void main(String[] args) {
        UserInfo tomas = new UserInfo(180,78,"Tomas");
        System.out.println(tomas.ShowUserInfo());

    }

}
