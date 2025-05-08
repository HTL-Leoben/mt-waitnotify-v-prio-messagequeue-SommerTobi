package at.htlle.pos4.prio_messagequeue;

import java.util.LinkedList;
import java.util.Queue;

public class PriorityMessageQueue {
    private final int maxSize;
    private final Queue<Message> priorityQueue = new LinkedList<>();
    private final Queue<Message> normalQueue = new LinkedList<>();

    public PriorityMessageQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void sendMessage(Message msg) throws InterruptedException {
        while (size() >= maxSize) {
            wait();
        }
        if (msg.isPriority()) {
            priorityQueue.add(msg);
        } else {
            normalQueue.add(msg);
        }
        System.out.println(Thread.currentThread().getName() + " sendMessage(): " + msg);
        notifyAll();
    }

    public synchronized Message receiveMessage() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        Message msg = !priorityQueue.isEmpty() ? priorityQueue.poll() : normalQueue.poll();
        System.out.println(Thread.currentThread().getName() + " receiveMessage(): " + msg);
        notifyAll();
        return msg;
    }

    private int size() {
        return priorityQueue.size() + normalQueue.size();
    }

    private boolean isEmpty() {
        return priorityQueue.isEmpty() && normalQueue.isEmpty();
    }
}
