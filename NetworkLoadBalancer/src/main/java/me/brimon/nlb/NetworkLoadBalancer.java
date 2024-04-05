package me.brimon.nlb;

import me.brimon.nlb.configuration.GlobalConfiguration;
import me.brimon.nlb.configuration.NLBConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkLoadBalancer {
    public NetworkLoadBalancer(){

    }

    private void loadConfiguration() throws IOException {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.yml");
        NLBConfiguration nlbConfiguration = yaml.loadAs(inputStream, NLBConfiguration.class);
        GlobalConfiguration.nlbConfiguration = nlbConfiguration;
    }

    public void start(int port) throws IOException {
        loadConfiguration();
        System.out.println(GlobalConfiguration.nlbConfiguration.hosts.toString());
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client Socket established");
                Socket socket = new Socket("localhost", 8080);
                RequestHandler requestHandler = new RequestHandler(clientSocket.getInputStream(), socket.getOutputStream());
                Worker worker = new Worker(clientSocket, socket);
                requestHandler.start();
                worker.start();
            }
        }
    }
}
