package ch6;

public class Ex1 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(() -> {
//            try{
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            while(true) {
                System.out.println("Thread:" + Thread.currentThread().getName());
                try{
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                    return;
                }
            }
        });
        thread.start();

        System.out.println("hello");

        System.out.println("Thread:" + Thread.currentThread().getName());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread:"+Thread.currentThread().getName());
        }
    }

}
