package chapter2.Ch7;

public class UserInfoTest {

    public static void main(String[] args) {
        UserInfo userLee = new UserInfo();
        userLee.userId = "a12345";
        userLee.userPassword = "zxcvbn12345";
        userLee.userName= "Lee";
        userLee.phonenumber = "01034556699";
        userLee.userAddress = "Seoul,Korea";

        System.out.println(userLee.showUserInfo());

        UserInfo userKim = new UserInfo("b12345","09876mnbvc","kim");
        System.out.println(userKim.showUserInfo());

    }

}
