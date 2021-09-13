package chapter2.ch14;

public class TakeTrasTest {

    public static void main(String[] args) {

        Student studentJ = new Student("James",5000);
        Student studentT = new Student("Tomas",10000);

        Bus bus100 = new Bus(100);
        Bus bus500 = new Bus(500);

        studentJ.takeBus(bus100);

        Subway greensubway = new Subway(2);
        studentT.takeSubway(greensubway);
        greensubway.showSubwayInfo();

        bus500.showBusInfo();
        bus100.showBusInfo();


    }

}
