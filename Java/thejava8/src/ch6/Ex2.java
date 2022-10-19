package ch6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread"+Thread.currentThread().getName());
//            }
//        });

        executorService.submit(getRunnable("Hello"));
        executorService.submit(getRunnable("Work"));
        executorService.submit(getRunnable("The"));
        executorService.submit(getRunnable("Java"));
        executorService.submit(getRunnable("Thread"));
        executorService.shutdown();

    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message+Thread.currentThread().getName());
    }


}
