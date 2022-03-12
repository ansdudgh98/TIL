package com.javaBook.ch9;


class Point implements Cloneable{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }



    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public void printSuper(){
        System.out.println("super.getclass()"+super.getClass().hashCode());
    }


    public Object clone() {
        Object obj = null;
        try{
            obj =  super.clone();
        }catch (CloneNotSupportedException e){
        }
        return obj;
    }
}

public class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(3,5);
        Point copy = (Point)original.clone();
        System.out.println(original);
        System.out.println(copy);
        System.out.println("original : "+ original.hashCode());
        System.out.println("copy : "+ copy.hashCode());
        System.out.println("original == copy" + (original==copy));
        System.out.println("original.equals(copy) :"+original.equals(copy));
        original.printSuper();
        copy.printSuper();

    }
}
