package com.example.JavaAssignment;

import org.springframework.boot.autoconfigure.SpringBootApplication;

//	Creates two Player objects:
//
//	p1 is the initiator (true), meaning it sends the first message.
//
//	p2 is the responder (false).
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		MessageBus bus = new MessageBus();

		Player p1 = new Player("Player1", bus, true);
		Player p2 = new Player("Player2", bus, false);

		bus.register(p1);
		bus.register(p2);

		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);

		t1.start();
		t2.start();

	}

}
