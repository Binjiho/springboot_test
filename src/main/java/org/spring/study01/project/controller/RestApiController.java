package org.spring.study01.project.controller;

import org.spring.study01.project.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    //조회 GET /localhost:8080/rest/api/v1/user/1
    @GetMapping("/get")
    public String getTest(){
        return "get1";
    }

    //삽입 POST /localhost:8080/rest/api/v1/user
    @PostMapping("/params")
    public MemberDto postParams(MemberDto memberDto){
        return memberDto;
    }

    @PostMapping("/params2") //비동기 통신일때 @RequestBody, @ResponseBody사용
    public MemberDto postParams2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    //수정 PUT /localhost:8080/rest/api/v1/user/{user_id}
    @PutMapping("/put")
    public String put(){
        return "putMapping";
    }

    //삭제 DELETE /localhost:8080/rest/api/v1/user/{user_id}
    @DeleteMapping("/delete")
    public String delete(){
        return "deleteMapping";
    }

    @GetMapping("/list")
    public List<MemberDto> getListMember(){
        List<MemberDto> members = new ArrayList<>();
        return members;
    }

    @PostMapping("join")
    public int joinMember(MemberDto memberDto){
        int rs = 0;
        return rs;
    }
}
