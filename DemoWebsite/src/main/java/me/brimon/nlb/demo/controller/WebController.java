package me.brimon.nlb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@Controller
public class WebController {

    @GetMapping("/index")
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) throws UnknownHostException {
        String ipAddress = Inet4Address.getLocalHost().getHostAddress();
        if(ipAddress == null){
            ipAddress = System.getenv("HOSTNAME");
        }
        model.addAttribute("ipAddress", ipAddress);
        return "index";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
