package com.example.JavaAssignment;

public class Message {
    private final String content;
    private final String from;
    private final String to;

    public Message(String content, String from, String to) {
        this.content = content;
        this.from = from;
        this.to = to;
    }

    public String getContent() { return content; }
    public String getFrom() { return from; }
    public String getTo() { return to; }

    @Override
    public String toString() {
        return "[" + from + " -> " + to + "] " + content;
    }
}
