package com.team.TeamProject.service;

import com.team.TeamProject.entity.UserEntity;
import com.team.TeamProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUserAll(){
        return userRepository.findAll();
    }
    public void teamMatching(){
        List<UserEntity> users = getUserAll();
        int teamSize = users.size()/4;
        int remainder = users.size()%4;
        if(remainder != 1) teamSize++;

        List<UserEntity>[] teams = new List[teamSize];

        // 0 : 발표, 1 : 자료조사, 2 : ppt, 3 : 팀장
        PriorityQueue<UserEntity>[] roles = new PriorityQueue[4];

        int pointer = 0;




    }
}
