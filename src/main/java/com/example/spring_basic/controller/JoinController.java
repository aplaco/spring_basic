package com.example.spring_basic.controller;

import com.example.spring_basic.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//Model: 컨트롤러에서 템플릿에 데이터를 전달시 필요한 스프링 내장 객체
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
    @Autowired
    private JoinService joinService;

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join/create")
    public String create(
            @RequestParam("uname") String uname,
            @RequestParam("email") String email,
            @RequestParam("colors") String colors,
            Model model //Model 타입의 파라미터 추가
    ){
        //서비스 메서드로 부터 문자열을 전달 받음
        String msg = joinService.processJoin(uname, email, colors);
        //추가한 파라미터로 자동 전달된 인스턴스의 addAttribute라는 메서를 통해
        // {"data":전달할 문자열}형식의 데이터를 index템플릿에 전달
        model.addAttribute("data", msg);
        return "index";
    }
}
