package me.brimon.nlb;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkLoadBalancer {
    public NetworkLoadBalancer(){

    }

    public void start(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client Socket established");
                Socket socket = new Socket("www.google.com", 80);
                RequestHandler requestHandler = new RequestHandler(clientSocket.getInputStream(), socket.getOutputStream());
                Worker worker = new Worker(clientSocket, socket);
                requestHandler.start();
                worker.start();
            }
        }
    }
}
