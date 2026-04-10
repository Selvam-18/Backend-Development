package com.example.SpringWeb;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        System.out.println("Tomcat Server running");
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int n1, @RequestParam("num2") int n2, ModelAndView mv) {
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        System.out.println(n1, n2);
        int result = n1 + n2;

        mv.addObject("result", result);
        mv.setViewName("result");
        return mv;
    }

    @ModelAttribute("course")
    public String courseName() {
        return "Java";
    }

    @RequestMapping("addAlien")
    public String addAlien(Alien alien) {
//        Alien a1 = new Alien();
        return  "result";
    }

}
