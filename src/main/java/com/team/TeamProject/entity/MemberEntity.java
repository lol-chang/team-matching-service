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

    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(memberDto.getEmail());
        memberEntity.setPassword(memberDto.getPassword());
        memberEntity.setName(memberDto.getName());

        memberEntity.setProject_cnt(memberDto.getProject_cnt());
        memberEntity.setLeader_cnt(memberDto.getLeader_cnt());
        memberEntity.setPresent_grade(memberDto.getPresent_grade());
        memberEntity.setTarget_grade(memberDto.getTarget_grade());
        memberEntity.setMbti(memberDto.getMbti());
        memberEntity.setRole_fst(memberDto.getRole_fst());
        memberEntity.setRole_scd(memberDto.getRole_scd());



        return memberEntity;
    }
}
