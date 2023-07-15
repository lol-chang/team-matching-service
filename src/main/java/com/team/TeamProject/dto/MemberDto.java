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


    //entity -> dto로 변경 필요

    public static MemberDto toMemberDTO(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(memberEntity.getId());
        memberDto.setName(memberEntity.getName());
        memberDto.setEmail(memberEntity.getEmail());
        memberDto.setPassword(memberEntity.getPassword());
        return memberDto;
    }

}
