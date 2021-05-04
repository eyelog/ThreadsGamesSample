package javaset.simpletread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableThread {

    public static void main(String[] args) throws Exception  {

        Callable task = () -> "Hello, From Runnable!";
        FutureTask<String> future = new FutureTask<>(task);
        Thread thread = new Thread(future);
        thread.start();
        System.out.println(future.get());
    }
}
