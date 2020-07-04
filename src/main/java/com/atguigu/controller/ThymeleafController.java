package com.atguigu.controller;

import com.atguigu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {
    @RequestMapping("/demo")
    public String demo(Model model){

        model.addAttribute("hello", "hello thy");

        //集合数据
        List<User> users = new ArrayList<User>();
        users.add(new User("zhangsan","123","张三"));
        users.add(new User("lisi","123","李四"));
        users.add(new User("wangwu ","123","王五"));
        model.addAttribute("users",users);
       return "demo";
    }
}
