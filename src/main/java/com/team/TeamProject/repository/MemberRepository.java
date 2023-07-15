package com.team.TeamProject.repository;

import com.team.TeamProject.entity.MemberEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원 정보 조회 (select 쿼리)
    Optional<MemberEntity> findByEmail(String email);
}
