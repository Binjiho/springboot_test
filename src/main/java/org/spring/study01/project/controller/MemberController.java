package org.spring.study01.project.controller;

import lombok.RequiredArgsConstructor;
import org.spring.study01.project.dto.MemberDto;
import org.spring.study01.project.service.MemberService;
import org.spring.study01.project.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/project/member")
public class MemberController {
//    @Autowired
//    private MemberService memberService;

    //RequiredArgsConstructor
    private final MemberService memberService;

    @GetMapping({"", "/index"})
    public String openIndexPage(){
        return "project/member/index";
    }


    @GetMapping("/join")
    public String openJoinMemberPage(){
        return "/project/member/join";
    }

    @PostMapping("/join")
    public String saveMember(@ModelAttribute MemberDto memberDto){
        int rs = memberService.memberInsert(memberDto);
        if (rs!=1){
            return "redirect:/project/member/join";
        }else{
            return "redirect:/project/member/joinResult";
        }
    }

    @GetMapping("/path/{userId}")
    public String postPathVariable(@PathVariable(value = "userId") String userId ){
        System.out.println("userId -> "+userId);
        return "";
    }
}
