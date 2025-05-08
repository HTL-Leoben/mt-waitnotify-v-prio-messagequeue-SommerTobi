[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/llj5fjPm)
# Priority at.htlle.pos4.prio_messagequeue.Message Queue

Es soll mit Hilfe von `wait()` und `notifyAll(`), eine at.htlle.pos4.prio_messagequeue.Message Queue erstellt werden, in der Nachrichten von `at.htlle.pos4.prio_messagequeue.Producer` erzeugt werden und `at.htlle.pos4.prio_messagequeue.Consumer`, diese Nachrichten aus der `MessqgeQueue` holen. Das Abholen der Messages soll generell nach dem **FIFO** Prinzip erfolgen. Eine `at.htlle.pos4.prio_messagequeue.Message` besteht aus einem Prirority-Flag und dem eigentlichen Content (String). Messages, bei denen das Priority Flag auf `true` gesetzt ist, sollen vorgereiht werden - wobei auch für Priority Nachrichten das **FIFO** Prinzip angewandt werden soll.

![Priority at.htlle.pos4.prio_messagequeue.Message Queue](PriorityMessageQueuedrawio.drawio.png)

Es soll die Möglichkeit geben, die **maximale Anzahl** der verwalteten Messages in der Queue zu definieren!

Um die Implementierung ordentlich testen zu können sollen die Procucer in zufälligen Zeitabständen Nachrichten an die Queue senden und at.htlle.pos4.prio_messagequeue.Consumer in zufälligen Zeitabständen, Nachrichten von der Queue abrufen (= empfangen).

> :warning: **Beachte:** Ist die maximale Anzahl an Nachrichten in der Queue erreicht, so darf solange kein at.htlle.pos4.prio_messagequeue.Producer Nachrichten an die Queue senden, solange nicht ein Cosumer eine Nachricht aus der Queue entegen nimmt. Ist die at.htlle.pos4.prio_messagequeue.Message Queue hingegen leer, so müssen alle at.htlle.pos4.prio_messagequeue.Consumer solange warten, bis Nachrichten von at.htlle.pos4.prio_messagequeue.Producer wieder in die Queue gestellt werden.

## Klassen

```java

class at.htlle.pos4.prio_messagequeue.Message {
    boolean isPriority = false;
    String content;

    // Constructor, getter, setter 
}

class at.htlle.pos4.prio_messagequeue.Producer extends Thread {

    // at.htlle.pos4.prio_messagequeue.Producer name
    private String name;

    // Constructor, getter, setter

    // Produce at random time Messages
}

class at.htlle.pos4.prio_messagequeue.Consumer extends Thread {

    // at.htlle.pos4.prio_messagequeue.Consumer name
    private String name;

    // Constructor, getter, setter

    // Consume at random time messgaes
}

class PriortyMessageQueue {

    // necessary Constructor

    // necessary class variables
    public synchronized void sendMessge(at.htlle.pos4.prio_messagequeue.Message msg) {
        // implementation
    }

    public synchronized at.htlle.pos4.prio_messagequeue.Message receiveMessage() {
        // implementation
    }
}
```

## Möglicher Programmablauf

```console
Procducer1 sendMessage(): at.htlle.pos4.prio_messagequeue.Message Content1
Produccer2 sendMessage(true): at.htlle.pos4.prio_messagequeue.Message Content2
Consumer1 receiveMessage(): true, MessageContent2
Consumer2 receiveMessage(): false, MessageContent1
Consomer1 receiveMessage(): WAIT
...
```
