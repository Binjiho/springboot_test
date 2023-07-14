package org.spring.study01.project.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    /**
     * requestMapping은 old Type
     * @return
     */
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String text2(){
//        return "test";
//    }

    @GetMapping("/test")
    public String text(){
        return "test";
    }

}
