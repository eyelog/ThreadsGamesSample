package javaset.simpletread;

public class RunnableThread {

    public static void main(String[] args) {

        new SubThreadRunnable();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
    }

    static class SubThreadRunnable implements Runnable {
        Thread thread;

        SubThreadRunnable() {
            thread = new Thread(this, "Поток для примера");
            System.out.println("Создан второй поток " + thread);
            thread.start();
        }

        public void run() {
            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println("Второй поток: " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Второй поток прерван");
            }
        }
    }
}


