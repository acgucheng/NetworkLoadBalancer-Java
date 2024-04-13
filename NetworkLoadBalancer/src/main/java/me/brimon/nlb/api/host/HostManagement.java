package me.brimon.nlb.api.host;

import me.brimon.nlb.configuration.GlobalConfiguration;
import me.brimon.nlb.configuration.Host;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/host")
public class HostManagement {

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Host> list(){
        return GlobalConfiguration.nlbConfiguration.getHosts();
    }

    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Host> post(@RequestBody  Host host){
        GlobalConfiguration.nlbConfiguration.getHosts().add(host);
        return GlobalConfiguration.nlbConfiguration.getHosts();
    }

    @DeleteMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Host> delete(@RequestBody Host host){
        GlobalConfiguration.nlbConfiguration.deleteHost(host);
        return GlobalConfiguration.nlbConfiguration.getHosts();
    }

}
