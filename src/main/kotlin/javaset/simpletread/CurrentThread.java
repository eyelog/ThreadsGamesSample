package javaset.simpletread;

public class CurrentThread {

    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        System.out.println("Текущий поток: " + mainThread);
        System.out.println("Текущий поток имя: " + mainThread.getName());

        // Меняем имя и выводим в текстовом поле
        mainThread.setName("AlterNameOfThread");
        System.out.println("\nНовое имя потока: " + mainThread.getName());
    }
}
