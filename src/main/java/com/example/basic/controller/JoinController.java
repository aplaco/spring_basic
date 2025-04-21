package com.example.basic.controller;
import com.example.basic.dto.JoinDTO;
import com.example.basic.entity.JoinEntity;
import com.example.basic.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//인스턴스를 담을 멤버변수에 final 지정 가능케 함
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;
   

    @GetMapping("/join")
    public String join(){
        return "join";
    }


    @PostMapping("/join/create")
    public String create(@ModelAttribute JoinDTO formDTO, Model model  ){
        String msg = joinService.processJoin(formDTO);
        model.addAttribute("data", msg);
        return "index";
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model){
        List<JoinEntity> users = joinService.getAllUsers();
        return "admin";
    }
}

