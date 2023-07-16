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
    public MemberDto login(MemberDto memberDto){
        // 회원이 입력한 이메일로 DB에서 조회.
        Optional<MemberEntity> byMemberEmail = memberRepository.findByEmail(memberDto.getEmail());
        if(byMemberEmail.isPresent()){
            // 조회 성공
            MemberEntity memberEntity = byMemberEmail.get();
            if(memberEntity.getPassword().equals(memberDto.getPassword())){
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴.
                return MemberDto.toMemberDto(memberEntity);
            }
            else{
                // 비밀번호 불일치
                return null;
            }
        }
        else{
            // 조회 실패
            return null;
        }


    }
}
