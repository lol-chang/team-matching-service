package com.team.TeamProject.dto;


import com.team.TeamProject.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
// NoArgsConstructor 은 생성자가 따로 있어도 기본생성자를 만들어줘서 파라미터 없이 객체 생성 가능.
@NoArgsConstructor
@ToString
public class MemberDto {
    private Long id;

    private String name;

    private String email;

    private String password;

    // 프로젝트 경험 횟수
    private int project_cnt;
    // 팀장 경험
    private int leader_cnt;
    // 현재 학점
    private double present_grade;
    // 목표 학점
    private double target_grade;

    // mbti
    private String mbti;
    // 맡고싶은 역할
    private String role_fst;
    private String role_scd;
    public static MemberDto toMemberDto(MemberEntity memberEntity){
        MemberDto memberDto = new MemberDto();
        memberDto.setId(memberEntity.getId());
        memberDto.setName(memberEntity.getName());
        memberDto.setEmail(memberEntity.getEmail());
        memberDto.setPassword(memberEntity.getPassword());

        memberDto.setProject_cnt(memberEntity.getProject_cnt());
        memberDto.setLeader_cnt(memberEntity.getLeader_cnt());
        memberDto.setPresent_grade(memberEntity.getPresent_grade());
        memberDto.setTarget_grade(memberEntity.getTarget_grade());
        memberDto.setMbti(memberEntity.getMbti());
        memberDto.setRole_fst(memberEntity.getRole_fst());
        memberDto.setRole_scd(memberEntity.getRole_scd());
        return memberDto;
    }

}
