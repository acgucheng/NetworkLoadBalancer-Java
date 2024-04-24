package me.brimon.nlb.api.host;

import me.brimon.nlb.balancer.RandomBalancer;
import me.brimon.nlb.balancer.RoundRobinBalancer;
import me.brimon.nlb.configuration.GlobalConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balancer")
public class BalancerManagement {

    @PostMapping
    public void post(@RequestBody String balancer){
        switch (balancer){
            case "RoundRobin":
                GlobalConfiguration.balancer = new RoundRobinBalancer();
                break;
            case "Random":
                GlobalConfiguration.balancer = new RandomBalancer();
                break;
        }
    }

}
