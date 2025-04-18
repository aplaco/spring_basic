package com.example.spring_basic.service;

import org.springframework.stereotype.Service;

@Service
public class JoinService {
    public String processJoin(String uname, String email, String colors) {
        //컨트롤럴를 통해 실제 템플릿에 전달된 데이터가 맵핑된 태그 문자열 반환
        String result = "name: "+uname+"<br />"
                + "email: "+email+"<br />"
                + "my color: "+colors;
        return result;
    }
}
