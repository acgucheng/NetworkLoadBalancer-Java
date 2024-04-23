package me.brimon.nlb.configuration;

import me.brimon.nlb.balancer.Balancer;
import me.brimon.nlb.balancer.RandomBalancer;
import me.brimon.nlb.balancer.RoundRobinBalancer;

public class GlobalConfiguration {
    public static NLBConfiguration nlbConfiguration;
    public static Balancer balancer = new RoundRobinBalancer();
}
