package com.team.TeamProject.entity;


import com.team.TeamProject.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "user")
public class MemberEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true) // unique 제약조건 추가
    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String mbti;//유저 MBTI
    private String role_fst;//맡고 싶은 역할 1순위
    private String role_scd;//맡고 싶은 역할 2순위

    private String project_cnt;//프로젝트 경험 횟수 int
    private String leader_cnt;//팀장 경험 int
    private String present_grade;//현재 학점 double
    private String target_grade;//목표 학점 double
    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(memberDto.getEmail());
        memberEntity.setPassword(memberDto.getPassword());
        memberEntity.setName(memberDto.getName());
        memberEntity.setMbti(memberDto.getMbti());
        memberEntity.setRole_fst(memberDto.getRole_fst());
        memberEntity.setRole_scd(memberDto.getRole_scd());
        memberEntity.setProject_cnt(memberDto.getProject_cnt());
        memberEntity.setLeader_cnt(memberDto.getLeader_cnt());
        memberEntity.setPresent_grade(memberDto.getPresent_grade());
        memberEntity.setTarget_grade(memberDto.getTarget_grade());
        return memberEntity;
    }
}
