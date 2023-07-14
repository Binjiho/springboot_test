package org.spring.study01.project.controller;

import org.spring.study01.project.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project/member")
public class MemberController {
    @GetMapping({"", "/index"})
    public String openIndexPage(){
        return "/project/member/index";
    }


    @PostMapping("/params")
    public String postParams(MemberDto memberDto, Model model){
        model.addAttribute("member", memberDto);
        return "/project/member/response";
    }

    @GetMapping("/path/{userId}")
    public String postPathVariable(@PathVariable(value = "userId") String userId ){
        System.out.println("userId -> "+userId);
        return "";
    }
}
