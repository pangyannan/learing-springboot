package cn.atomc.learing.springboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eric
 * @create 2019-06-28
 */
@Controller
public class LayoutController {
    @GetMapping("index")
    public String index(){
        return "layout/index";
    }

    @GetMapping("fragment")
    public String fragment(){
        return "layout/fragment";
    }

    @RequestMapping("/layout")
    public String layout() {
        return "layout/layout";
    }

    @RequestMapping("/home")
    public String home() {
        return "layout/home";
    }

}
