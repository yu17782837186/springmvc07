package com.ning.controller;
import com.ning.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DemoController {
//    @RequestMapping("main")
//    public String main(){
//        return "/WEB-INF/page/main.jsp";
//    }
    //优先找最匹配的
    @RequestMapping("{page}")
    public String main(@PathVariable String page){
        System.out.println("restful");
        return page;
    }
//    @RequestMapping("login")
//    public String login(){
//        System.out.println("login");
//        return "/login.jsp";
//    }
    @RequestMapping("login")
    public String login(Users users, HttpSession session){
        if (users.getUsername().equalsIgnoreCase("admin")&&users.getPassword().equals("123")) {
            session.setAttribute("users",users);
            return "main";
        }else {
            return "redirect:/login,jsp";
        }
    }
}
