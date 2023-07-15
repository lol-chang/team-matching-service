package com.team.TeamProject.service;


import com.team.TeamProject.dto.MemberDto;
import com.team.TeamProject.entity.MemberEntity;
import com.team.TeamProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDto);
        memberRepository.save(memberEntity);


    }

    public MemberDto login(MemberDto memberDto) {
        /*
        1. 회원 입력을 DB에서 조회
        2. DB에서 입력 비번과 조회 비번 비교
        (원시적인 방법이라 연습용 _보안 고려 X)
         */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByEmail(memberDto.getEmail());
        // Optional 은 NPE(NullPointerException) 방지 wrapper

        if (byMemberEmail.isPresent()) {
            //조회 성공(이메일 존재 + 비번이 맞는지는 모름)
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getPassword().equals(memberDto.getPassword())) {
                //ps까지도 일치

                //controller에 넘기려면 memberDTO로 변경 필요
                MemberDto dto = MemberDto.toMemberDTO(memberEntity);
                return dto;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }

    }
}
