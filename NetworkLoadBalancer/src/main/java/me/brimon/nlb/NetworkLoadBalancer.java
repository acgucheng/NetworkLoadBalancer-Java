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

    public static NetworkLoadBalancer currentLoadBalancer;
    public static NetworkLoadBalancer getCurrentLoadBalancer(){
        return currentLoadBalancer;
    }

    public static void reload(){
        currentLoadBalancer.reloadHosts();
    }

    public List<Host> hosts;

    private void reloadHosts(){
        hosts = GlobalConfiguration.nlbConfiguration.getHosts();
        System.out.println("Host list reloaded, " + hosts.toString());
    }

    public NetworkLoadBalancer() throws IOException {
        currentLoadBalancer = this;
        loadConfiguration();
        hosts = GlobalConfiguration.nlbConfiguration.getHosts();
        System.out.println(GlobalConfiguration.nlbConfiguration.getHosts().toString());
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
        Random random = new Random();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while(true) {
                Socket clientSocket = null;
                try{
                    clientSocket = serverSocket.accept();
                    Host host = GlobalConfiguration.balancer.getNextHost();
                    Socket socket = new Socket(host.ip, Integer.parseInt(host.port));
                    RequestHandler requestHandler = new RequestHandler(clientSocket, socket);
                    Worker worker = new Worker(clientSocket, socket);
                    requestHandler.start();
                    worker.start();
                }catch (Exception e){
                    e.printStackTrace();
                    if(clientSocket != null){
                        clientSocket.close();
                    }
                }

            }
        }
    }
}
