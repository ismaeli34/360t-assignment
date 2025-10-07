package com.example.JavaAssignment;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Player implements Runnable{
    private final String name;
    private final MessageBus bus;
    private final BlockingQueue<Message> mailbox = new LinkedBlockingQueue<>();
    private int counter = 0;
    private final boolean initiator;
    private int receivedCount = 0;

    public Player(String name, MessageBus bus, boolean initiator) {
        this.name = name;
        this.bus = bus;
        this.initiator = initiator;
    }

    public String getName() { return name; }

    /**
     * receive adds a message to the player’s inbox (mailbox).
     * @param msg
     */
    public void receive(Message msg) {
        mailbox.offer(msg);
    }

    /**
     * send creates a new message and asks the MessageBus
     * to deliver it to the other player.
     * @param content
     * @param to
     */
    private void send(String content, String to) {
        Message msg = new Message(content, this.name, to);
        bus.deliver(msg);
    }

    @Override
    public void run() {
        try {
            if (initiator) {
                send("Hello", "Player2");
            }

            while (true) {
                Message msg = mailbox.take();
                System.out.println(name + " received: " + msg);

                if (initiator) {
                    receivedCount++;
                    if (receivedCount >= 10) {
                        System.out.println(name + " finished after 10 messages.");
                        break;
                    }
                    counter++;
                    send(msg.getContent() + "-" + counter, "Player2");
                } else {
                    counter++;
                    send(msg.getContent() + "-" + counter, "Player1");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
