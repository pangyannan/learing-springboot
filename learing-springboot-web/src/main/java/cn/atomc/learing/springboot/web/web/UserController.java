package cn.atomc.learing.springboot.web.web;

import cn.atomc.learing.springboot.web.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric
 * @create 2019-06-02
 */
@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping("/")
    public User getUser(){
        User user = new User();
        user.setName("小明");
        user.setAge(18);
        user.setPassword("123456");
        return user;
    }
    @GetMapping("/{name}")
    public User getUserByName(@PathVariable String name){
        User user = new User();
        user.setName(name);
        return user;
    }

    @PostMapping("/")
    public User saveUser(User user){
        return user;
    }

    @GetMapping("list")
    public List<User> listUser(){
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setName("小明");
        user1.setAge(18);
        user1.setPassword("123456");
        list.add(user1);

        User user2 = new User();
        user2.setName("小芳");
        user2.setAge(16);
        user2.setPassword("666");
        list.add(user2);
        return list;
    }
}
