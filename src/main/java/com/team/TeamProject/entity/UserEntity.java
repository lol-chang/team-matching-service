package com.team.TeamProject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.catalina.User;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class UserEntity implements Comparable<UserEntity>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    // 프로젝트 경험 횟수
    private int project_cnt;
    // 팀장 경험
    private int leader_cnt;
    // 현재 학점
    private String present_grade;
    // 목표 학점
    private String target_grade;

    // mbti
    private String mbti;
    // 맡고싶은 역할
    private String role_fst;
    private String role_scd;

    public double getScore(){
        double sum = 0.0;
        sum += 0.5 * project_cnt;
        sum += 0.3 * leader_cnt;
        sum += 0.2 * Double.parseDouble(present_grade);
        sum += 0.4 * Double.parseDouble(target_grade);

        return sum;
    }
    public int compareTo(UserEntity userEntity){
        return Double.compare(userEntity.getScore(), this.getScore());
    }
}
