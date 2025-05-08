package at.htlle.pos4.prio_messagequeue;

import java.util.concurrent.ThreadLocalRandom;

public class Producer extends Thread {
    private final PriorityMessageQueue queue;

    public Producer(String name, PriorityMessageQueue queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            while (true) {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1500));
                boolean isPriority = ThreadLocalRandom.current().nextBoolean();
                Message msg = new Message(isPriority, getName() + " Message " + (++count));
                queue.sendMessage(msg);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
