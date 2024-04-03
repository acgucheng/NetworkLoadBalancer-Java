package me.brimon.nlb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Worker extends Thread{

    InputStream inputStream;
    OutputStream clientOutputStream;
    public Worker(Socket clientSocket, Socket workloadSocket) throws IOException {
         inputStream = workloadSocket.getInputStream();
         clientOutputStream = clientSocket.getOutputStream();

    }

    @Override
    public void run() {
        try{
            byte[] buffer = new byte[1024];
            while(inputStream.read(buffer) != -1){
                clientOutputStream.write(buffer);
                clientOutputStream.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
