package ch5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex1 {

    public static void main(String[] args) {
        //java 8 버전 이전
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        long time = date.getTime();

        //java8 이후


    }

}
