package ch6;

import java.util.concurrent.*;

public class Ex3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> submit = executorService.submit(hello);
        System.out.println("started");

        submit.get();

        System.out.println("End");
        executorService.shutdown();
    }
}
