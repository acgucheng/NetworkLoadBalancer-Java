package me.brimon.nlb;

import ch.qos.logback.core.net.server.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Worker extends Thread{

    InputStream inputStream;
    OutputStream clientOutputStream;

    Socket clientSocket;
    Socket workloadSocket;

    public Worker(Socket clientSocket, Socket workloadSocket) throws IOException {
         inputStream = workloadSocket.getInputStream();
         clientOutputStream = clientSocket.getOutputStream();
         this.clientSocket = clientSocket;
         this.workloadSocket = workloadSocket;

    }

    @Override
    public void run() {
        try{
            byte[] buffer = new byte[1];
            while(inputStream.read(buffer) != -1){
                try {
                    clientOutputStream.write(buffer);
                    clientOutputStream.flush();
                }catch (Exception e){
                    System.out.println("Worker Closed Connection!");
                }
            }
            System.out.println("Worker Closed Connection!");
            clientSocket.close();
            workloadSocket.close();
        }catch (Exception e){
            System.out.println("Client Closed Connection!");
        }

    }

}
