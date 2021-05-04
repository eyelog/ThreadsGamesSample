package javaset.simpletread;

public class RunnableThread2 {

    public static void main(String []args){
        Runnable task = () -> System.out.println("Hello, From Runnable!");
        Thread thread = new Thread(task);
        thread.start();
    }
}
