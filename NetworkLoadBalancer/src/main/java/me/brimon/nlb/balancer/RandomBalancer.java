package me.brimon.nlb.balancer;

import me.brimon.nlb.configuration.GlobalConfiguration;
import me.brimon.nlb.configuration.Host;

import java.util.Random;

public class RandomBalancer implements Balancer{

    public static Random random = new Random();

    @Override
    public Host getNextHost() {
        return GlobalConfiguration.nlbConfiguration.getHosts().get(random.nextInt(GlobalConfiguration.nlbConfiguration.getHosts().size()));
    }
}
