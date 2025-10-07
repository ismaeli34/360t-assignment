package com.example.JavaAssignment;
import java.util.HashMap;
import java.util.Map;

// MessageBus acts as a mediator.
public class MessageBus {
    private final Map<String, Player> players = new HashMap<>();

    /***
     *   register() method is
     *  responsible to register the players
     */

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    /***
     *   deliver() method is
     *  responsible for delivering messages between players.
     */

    public void deliver(Message msg) {
        Player recipient = players.get(msg.getTo());
        if (recipient != null) {
            recipient.receive(msg);
        }
    }
}
