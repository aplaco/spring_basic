package com.example.basic.service;

import com.example.basic.dto.JoinDTO;
import com.example.basic.entity.JoinEntity;
import com.example.basic.repository.JoinRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinRepo joinRepo;

    public String processJoin(JoinDTO dto) {
        JoinEntity user = new JoinEntity(null, dto.getUname(), dto.getEmail(), dto.getColors() );
        joinRepo.save(user);

        String result = "name: "+dto.getUname()+"<br />"
                + "email: "+dto.getEmail()+"<br />"
                + "my color: "+dto.getColors();
        return result;
    }

    // 모든 DB데이터 조회해서 반환
    public List<JoinEntity> getAllUsers(){
        return joinRepo.findAll();
    }
}