package me.brimon.nlb.balancer;

import me.brimon.nlb.configuration.Host;

public interface Balancer {

    public Host getNextHost();
}
