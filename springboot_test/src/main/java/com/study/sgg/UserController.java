package com.study.sgg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shuaion 2018/4/24
 **/
@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/test")
    public String main(Model model){

        model.addAttribute("test","只要我们把HTML页面放在classpath:/templates/，thymeleaf就能自动渲染；");
        return "test_thymeleaf";
    }
}
