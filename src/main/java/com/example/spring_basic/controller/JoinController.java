package com.example.spring_basic.controller;
import com.example.spring_basic.dto.JoinDTO;
import com.example.spring_basic.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {
    //서비스 계층으로부터 joinService라는 인스턴스 @Autowired라는 어노테이션을 통해 바로 해당 인스턴스 객체를 바로 가져올수 있음 (new 연산자 호출 필요없음)
    @Autowired
    private JoinService joinService;


    // 처음 조인폼 화면 출력 하는 get방식 요청
    @GetMapping("/join")
    public String join(){
        return "join";
    }

    //해당 조인폼 화면에서 폼의 전송 이벤트 발생시 데이터 가공하는 post 방식 요청
    //이떄 폼의 모든 요소를 일일이 전달하는 것이 아닌 DTO파일로 감싸로 전달
    //Model타입의 파라미터, 서비스에 전달된 데이터를 뷰템플릿에 전달하기 위한 전용 클래스
    @PostMapping("/join/create")
    public String create(@ModelAttribute JoinDTO formDTO, Model model  ){
        String msg = joinService.processJoin(formDTO);
        model.addAttribute("data", msg);
        return "index";
    }
}
