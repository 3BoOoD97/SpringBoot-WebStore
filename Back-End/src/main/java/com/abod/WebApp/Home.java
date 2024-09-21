package com.abod.WebApp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @ RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @ RequestMapping("/home")
    public String home2() {
        return "Hello  !";
    }


}
