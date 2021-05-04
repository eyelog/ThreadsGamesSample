package javaset.simpletread;


public class SubThreadSample {

    public static void main(String[] args) {

        SubThread subThread = new SubThread();
        subThread.start();
    }

    static class SubThread extends Thread {

        SubThread() {
            super("Суб-поток");
            System.out.println("Создан Суб-поток " + this);
        }

        public void run() {
            System.out.println("Суб-поток запущен...");

            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println("Суб-поток: " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Суб-поток прерван");
            }
        }
    }
}
