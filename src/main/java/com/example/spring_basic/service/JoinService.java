package com.example.spring_basic.service;

import com.example.spring_basic.dto.JoinDTO;
import com.example.spring_basic.entity.JoinEntity;
import com.example.spring_basic.repository.JoinRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinRepo joinRepo;

    public String processJoin(JoinDTO dto) {
        // Entity클래스로 부터 각 항목에 맞는 데이터를 인자로 전달하여 실제 DB에 저장할 모델 인스턴스 생성
        JoinEntity user = new JoinEntity(null, dto.getUname(), dto.getEmail(), dto.getColors() );

        //위에서 생성한 user라는 인스턴스를 joinRepo의 save메서드로 전달하기만 하면 DB에 데이터 저장됨
        //save() 리포지토리에서 JPA구현체가 자동으로 생성 DB저장 전용 메서드
        joinRepo.save(user);

        String result = "name: "+dto.getUname()+"<br />"
                + "email: "+dto.getEmail()+"<br />"
                + "my color: "+dto.getColors();
        return result;
    }
}