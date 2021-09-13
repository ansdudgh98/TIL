package chapter2.ch19;

public class CarFactory {
    private static int factoryCarNum = 10001;
    private static CarFactory instance = new CarFactory();


    private CarFactory() {

    }

    public static CarFactory getInstance() {
        if (instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }

    public Car createCar(){
        Car carinstance = new Car(factoryCarNum);
        factoryCarNum++;
        return carinstance;
    }

}
