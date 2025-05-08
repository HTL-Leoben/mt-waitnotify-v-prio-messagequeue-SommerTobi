package at.htlle.pos4.prio_messagequeue;

public class App {
    public static void main(String[] args) {
        PriorityMessageQueue queue = new PriorityMessageQueue(5);

        Producer producer1 = new Producer("Producer-1", queue);
        Producer producer2 = new Producer("Producer-2", queue);

        Consumer consumer1 = new Consumer("Consumer-1", queue);
        Consumer consumer2 = new Consumer("Consumer-2", queue);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
