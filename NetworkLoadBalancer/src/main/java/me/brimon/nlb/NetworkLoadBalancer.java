package me.brimon.nlb;

import me.brimon.nlb.configuration.GlobalConfiguration;
import me.brimon.nlb.configuration.Host;
import me.brimon.nlb.configuration.NLBConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Random;

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
        System.out.println(GlobalConfiguration.nlbConfiguration.getHosts().toString());
        List<Host> hosts = GlobalConfiguration.nlbConfiguration.getHosts();
        Random random = new Random();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client Socket established");
                Socket socket = new Socket(hosts.get(random.nextInt(hosts.size())).ip, 8080);
                RequestHandler requestHandler = new RequestHandler(clientSocket.getInputStream(), socket.getOutputStream());
                Worker worker = new Worker(clientSocket, socket);
                requestHandler.start();
                worker.start();
            }
        }
    }
}
