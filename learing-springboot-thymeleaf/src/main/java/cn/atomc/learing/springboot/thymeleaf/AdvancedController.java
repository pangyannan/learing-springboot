package cn.atomc.learing.springboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric
 * @create 2019-06-27
 */
@Controller
public class AdvancedController {

    @GetMapping("inLine")
    public String inLine(Model model){
        model.addAttribute("userName","Eirc");
        return "inline";
    }

    @RequestMapping("/object")
    public String object(HttpServletRequest request) {
        request.setAttribute("requestAttribute","i am request attribute");
        HttpSession session = request.getSession();
        session.setAttribute("sessionAttribute","i am session attribute");
        return "object";
    }

    @RequestMapping("/utility")
    public String utility(Model model) {
        model.addAttribute("modelStr", "modelBlog");
        model.addAttribute("modelBool", true);
        model.addAttribute("modelArray", new Integer[]{1,2,3,4});
        model.addAttribute("modelList", Arrays.asList(1,3,2,4,0));
        Map modelMap = new HashMap();
        modelMap.put("thName", "${#...}");
        modelMap.put("desc", "变量表达式内置方法");
        model.addAttribute("modelMap", modelMap);
        model.addAttribute("modelDate", new Date());
        model.addAttribute("modelNum", 888.888D);
        return "utility";
    }
}
