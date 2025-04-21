package com.example.spring_basic.service;

import com.example.spring_basic.dto.JoinDTO;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    public String processJoin(JoinDTO dto) {
        //JoinDTO타입의 폼 객체를 전달받아 데이터를 활용한 태그 문자열 생성후 리턴
        String result = "name: "+dto.getUname()+"<br />"
                + "email: "+dto.getEmail()+"<br />"
                + "my color: "+dto.getColors();
        return result;
    }
}
