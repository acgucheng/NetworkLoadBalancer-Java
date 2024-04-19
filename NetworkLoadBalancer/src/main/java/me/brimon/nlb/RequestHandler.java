package me.brimon.nlb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestHandler extends Thread{

    Socket clientSocket;
    Socket workloadSocket;

    public RequestHandler(Socket clientSocket, Socket workloadSocket){
        this.clientSocket = clientSocket;
        this.workloadSocket = workloadSocket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream workloadOutputStream = workloadSocket.getOutputStream();
            byte[] buffer = new byte[1];
            while(inputStream.read(buffer) != -1){
                workloadOutputStream.write(buffer);
                workloadOutputStream.flush();
            }
            workloadSocket.close();
            clientSocket.close();
        }catch (Exception e){
            System.out.println("Client closed connection!");
        }

    }
}
