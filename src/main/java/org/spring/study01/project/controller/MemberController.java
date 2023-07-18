package org.spring.study01.project.controller;

import lombok.RequiredArgsConstructor;
import org.spring.study01.project.dto.MemberDto;
import org.spring.study01.project.service.MemberService;
import org.spring.study01.project.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/project/member")
public class MemberController {

    //RequiredArgsConstructor
    private final MemberService memberService;

    @GetMapping({"", "/index"})
    public String openIndexPage(Model model){
        List<MemberDto> result= memberService.getMemberList();
        model.addAttribute("result", result);
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
            return "redirect:/project/member/index";
        }
    }

    @GetMapping("/detail/{userId}")
    public String postPathVariable(@PathVariable(value = "userId") Long userId, Model model ){
        System.out.println("userId -> "+userId);
        MemberDto memberDto = memberService.memberDetail(userId);
        if (memberDto != null){
            model.addAttribute("member", memberDto);
            return "project/member/detail";
        }else{
            return "redirect:project/member/memberList";
        }
    }
}
