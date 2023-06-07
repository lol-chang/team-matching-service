package com.team.TeamProject.service;


import com.team.TeamProject.dto.MemberDto;
import com.team.TeamProject.entity.MemberEntity;
import com.team.TeamProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDto);
        memberRepository.save(memberEntity);


    }
}
