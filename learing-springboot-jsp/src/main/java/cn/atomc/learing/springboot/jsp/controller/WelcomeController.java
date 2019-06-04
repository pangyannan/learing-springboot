package cn.atomc.learing.springboot.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Eric
 * @create 2019-06-03
 */
@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome( ){
        return "welcome";
    }
}
