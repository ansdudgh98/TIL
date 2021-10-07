package chapter2.ch11;

public class TestReport {
    public static void main(String[] args) {
        MakeReport makeReport = new MakeReport();
        String line = makeReport.getReport();
        System.out.println(line);
    }


}