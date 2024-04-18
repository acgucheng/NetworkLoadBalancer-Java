package me.brimon.nlb.api.host;

import me.brimon.nlb.NetworkLoadBalancer;
import me.brimon.nlb.configuration.GlobalConfiguration;
import me.brimon.nlb.configuration.Host;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/host")
public class HostManagement {

    @GetMapping("")
    public List<Host> list(){
        return GlobalConfiguration.nlbConfiguration.getHosts();
    }

    @PostMapping("")
    public List<Host> post(@RequestBody  Host host){
        GlobalConfiguration.nlbConfiguration.getHosts().add(host);
        NetworkLoadBalancer.reload();
        return GlobalConfiguration.nlbConfiguration.getHosts();
    }

    @DeleteMapping
    public List<Host> delete(@RequestBody Host host){
        GlobalConfiguration.nlbConfiguration.deleteHost(host);
        NetworkLoadBalancer.reload();
        return GlobalConfiguration.nlbConfiguration.getHosts();
    }

}
