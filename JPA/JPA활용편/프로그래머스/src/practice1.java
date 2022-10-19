import java.util.ArrayList;
import java.util.List;

public class practice1 {
    public static void main(String[] args) {
        System.out.println("case1 : " + solution("111100100011"));
        System.out.println("case2 : " + solution("00011011100000"));
        System.out.println("case3 : " + solution("11111"));
    }

    public static String solution(String src){
        int start = 0;
        String firstWord = String.valueOf(src.charAt(0));
        String answer = "";
        answer = firstWord;
        char countChr = 'A';

        for(int i = 1; i<src.length();i++){
            if(src.charAt(start) == src.charAt(i)){
                System.out.println("same");
                countChr++;
                System.out.println(countChr);
            }
            else if(src.charAt(start) != src.charAt(i)){
                System.out.println("not");
                answer = answer + countChr;
                System.out.println(answer);
                countChr = 'A';
                start = i;
            }

            if(i == src.length() - 1){
                answer = answer + countChr;
            }
        }
        return answer;
    }

}
