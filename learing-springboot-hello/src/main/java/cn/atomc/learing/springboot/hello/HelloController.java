package cn.atomc.learing.springboot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(String name){
        return "Hello world, " + name;
    }
}
