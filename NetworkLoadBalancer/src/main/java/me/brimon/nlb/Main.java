package me.brimon.nlb;

import me.brimon.nlb.api.SpringApplication;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SpringApplication.run();
        NetworkLoadBalancer networkLoadBalancer = new NetworkLoadBalancer();
        networkLoadBalancer.start(2333);
    }
}