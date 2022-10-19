package ch5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Ex2 {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        System.out.println("===============");

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthday = LocalDateTime.of(1982, Month.JULY, 15, 0, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(birthday);
        System.out.println(nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2020,Month.JULY,15);

        Period period = Period.between(today,thisYearBirthday);
        System.out.println(period.getDays());

        LocalDateTime plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println(between.getSeconds());

        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMddyyyy));


    }

}
