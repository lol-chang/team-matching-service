package com.team.TeamProject.controller;


import com.team.TeamProject.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MemberController {

    @GetMapping("/member/register")
    public String registerHome(){
        return "registerHome";
    }


    @PostMapping("/member/register/pro")
    public String register(Member member, Model model, MultipartFile multipartFile){




        return "message";
    }


}
