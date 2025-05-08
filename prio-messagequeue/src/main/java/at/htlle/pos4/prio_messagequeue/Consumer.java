package at.htlle.pos4.prio_messagequeue;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer extends Thread {
    private final PriorityMessageQueue queue;

    public Consumer(String name, PriorityMessageQueue queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
                queue.receiveMessage();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
