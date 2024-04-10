package me.brimon.nlb;

import java.io.InputStream;
import java.io.OutputStream;

public class RequestHandler extends Thread{

    InputStream inputStream;
    OutputStream workloadOutputStream;

    public RequestHandler(InputStream inputStream, OutputStream workloadOutputStream){
        this.inputStream = inputStream;
        this.workloadOutputStream = workloadOutputStream;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1];
            while(inputStream.read(buffer) != -1){
                workloadOutputStream.write(buffer);
                workloadOutputStream.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
