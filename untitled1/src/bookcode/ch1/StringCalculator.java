package bookcode.ch1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String text){
        /*if(text == null || text.isEmpty()){
            return 0;
         극단적인 리팩토링 예제로 인한 코드 주석처리

        }*/
        if(isBlank(text))
            return 0;

        /*if(text.contains(",")){
         String[] values = text.split(",");
         int sum = 0;
         for(String value : values){
             sum += Integer.parseInt(value);
         }
         return sum;
        }
        */
        /*String[] values = text.split(",");
        int sum = 0;
        for(String value : values){
            sum += Integer.parseInt(value);
        }
        //SplitTest후 조건문 삭제
        코드의 복잡도로 인하여 리팩토링을 위해 sum메소드로 리팩토링함
        */


        // return Integer.parseInt(text); 리팩토링으로 인한 리턴값 변경

        String[] values = text.split(",");
        //return sum(values);
        //return sum(toInts(values));
        return sum(toInts(split(text)));
    }

    private boolean isBlank(String text){
        return text == null || text.isEmpty();
    }

    private String[] split(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }
        return text.split(",|:");
    }


    private int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for(int i=0;i<values.length;i++){
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private int toPositive(String value){
        int number = Integer.parseInt(value);
        if(number<0)
            throw new RuntimeException();
        return number;
    }

    private int sum(int[] numbers){
        int sum = 0;
       /* for(String value : values){
           // sum += Integer.parseInt(value); 리팩토링으로 인한 코드 변경
        }*/
        for(int number:numbers){
            sum += number;
        }

        return sum;
    }







}
