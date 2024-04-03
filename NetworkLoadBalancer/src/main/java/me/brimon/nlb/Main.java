package me.brimon.nlb;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        NetworkLoadBalancer networkLoadBalancer = new NetworkLoadBalancer();
        networkLoadBalancer.start(2333);
    }
}