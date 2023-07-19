package com.team.TeamProject.dto;


import com.team.TeamProject.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDto {
    private Long id;

    private String name;

    private String email;

    private String password;

    //user 매칭 변수
    private String mbti;//유저 MBTI
    private String role_fst;//맡고 싶은 역할 1순위
    private String role_scd;//맡고 싶은 역할 2순위

    private String project_cnt;//프로젝트 경험 횟수 int
    private String leader_cnt;//팀장 경험 int
    private String present_grade;//현재 학점 double
    private String target_grade;//목표 학점 double



    //entity -> dto로 변경 필요

    public static MemberDto toMemberDTO(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(memberEntity.getId());
        memberDto.setName(memberEntity.getName());
        memberDto.setEmail(memberEntity.getEmail());
        memberDto.setPassword(memberEntity.getPassword());
        memberDto.setMbti(memberEntity.getMbti());
        memberDto.setRole_fst(memberEntity.getRole_fst());
        memberDto.setRole_scd(memberEntity.getRole_scd());
        memberDto.setProject_cnt(memberEntity.getProject_cnt());
        memberDto.setLeader_cnt(memberEntity.getLeader_cnt());
        memberDto.setPresent_grade(memberEntity.getPresent_grade());
        memberDto.setTarget_grade(memberEntity.getTarget_grade());
        return memberDto;
    }

}
