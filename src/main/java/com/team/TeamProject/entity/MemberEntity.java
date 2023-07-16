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
    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(memberDto.getEmail());
        memberEntity.setPassword(memberDto.getPassword());
        memberEntity.setName(memberDto.getName());

        return memberEntity;
    }
}
