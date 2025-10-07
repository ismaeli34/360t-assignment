package com.example.JavaAssignment;

import java.io.*;
import java.net.*;
// Checks if the program should run as a server or a client using command-line arguments.
public class ProcessMain {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java ProcessMain <server|client>");
            return;
        }

        if ("server".equalsIgnoreCase(args[0])) {
            runServer();
        } else if ("client".equalsIgnoreCase(args[0])) {
            runClient();
        }
    }

    private static void runServer() throws IOException {
//        ServerSocket listens on port 5000.
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started on port 5000, waiting...");
        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        int counter = 0;
        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("Server received: " + msg);
            counter++;
            String reply = msg + "-" + counter;
            out.println(reply);
        }
    }

    private static void runClient() throws IOException {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String msg = "Hello";
        for (int i = 1; i <= 10; i++) {
            out.println(msg);
            String reply = in.readLine();
            System.out.println("Client received: " + reply);
            msg = reply + "-" + i;
        }
        socket.close();
    }

}
