package com.team.TeamProject.repository;

import com.team.TeamProject.entity.MemberEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원 정보 조회
    // 아래 명령어로 select * from member_table where member_email=? 라는 쿼리가 나옴.
    Optional<MemberEntity> findByEmail(String memberEmail);
}
