package me.brimon.nlb.balancer;

import me.brimon.nlb.configuration.GlobalConfiguration;
import me.brimon.nlb.configuration.Host;
import me.brimon.nlb.configuration.NLBConfiguration;

public class RoundRobinBalancer implements Balancer{

    private static int index = -1;

    public Host getNextHost(){
        index = (index + 1) % GlobalConfiguration.nlbConfiguration.getHosts().size();
        return GlobalConfiguration.nlbConfiguration.getHosts().get(index);
    }
}
