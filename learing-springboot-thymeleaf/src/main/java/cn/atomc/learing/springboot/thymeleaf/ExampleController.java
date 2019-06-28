package cn.atomc.learing.springboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric
 * @create 2019-06-06
 */
@Controller
public class ExampleController {
    @GetMapping("string")
    public String string(Model model, ModelMap map){
        map.put("userName","eric");
        return "string";
    }

    @GetMapping("/if")
    public String ifunless(ModelMap map) {
        map.addAttribute("flag", "yes");
        return "if";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "list";
    }
    private List<User> getUserList(){
        List<User> list=new ArrayList<>();
        User user1=new User("小明",18,"123456");
        User user2=new User("小芳",16,"123123");
        User user3=new User("小王",2,"666888");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }



    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springboot/1/2");
        map.addAttribute("img", "http://pic122.huitu.com/res/20190604/2076396_20190604171028287060_1.jpg");
        return "url";
    }


    @RequestMapping("/eq")
    public String eq(ModelMap map) {
        map.addAttribute("name", "eric");
        map.addAttribute("age", 30);
        map.addAttribute("flag", "yes");
        return "eq";
    }


    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "woman");
        return "switch";
    }


}
