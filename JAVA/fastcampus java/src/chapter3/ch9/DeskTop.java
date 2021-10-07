package chapter3.ch9;

public class DeskTop extends Computer{

    @Override
    public void display() {
        System.out.println("DeskTop disply");
    }

    @Override
    public void typing() {
        System.out.println("Desktop typing");
    }

    @Override
    public void turnOff() {
        System.out.println("Desktop turnOff");
    }
}

