package me.brimon.nlb.configuration;

import java.util.List;

public class NLBConfiguration {
    private List<Host> hosts;

    public List<Host> getHosts(){
        return hosts;
    }

    public void setHosts(List<Host> hosts){
        this.hosts = hosts;
    }

    public void deleteHost(Host host){
        for(int i = 0; i < hosts.size(); i++){
            Host h = hosts.get(i);
            if(h.getIp().equals(host.getIp()) && h.getPort().equals(host.getPort())){
                hosts.remove(i);
                break;
            }
        }
    }
}
