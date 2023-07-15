package com.team.TeamProject.controller;


import com.team.TeamProject.dto.MemberDto;
import com.team.TeamProject.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    // Controller 에 @RequiredArgsConstructor 붙이고, private MemberService memberService 하면 MemberService 접근 권한이 생김. ( 객체생성과 비슷 )
    private final MemberService memberService;
    @GetMapping("/member/register")
    public String registerHome(){
        return "registerHome";
    }

    @GetMapping("login")
    public String loginHome(){
        return "loginHome";
    }





//    html에서의 name="name" 에서 가져온 문자열이 String name로 넘어감.
//    @PostMapping("/member/register/pro")
//    public String save(@RequestParam("name") String name,
//                       @RequestParam("email") String email,
//                       @RequestParam("psw") String psw,
//                       @RequestParam("psw_repeat") String psw_repeat){
//        System.out.println("name = "+name);
//        System.out.println("email = "+email);
//        System.out.println("psw = "+psw);
//        System.out.println("psw_repeat = "+psw_repeat);
//        return "registerHome";
//
//    }

    @PostMapping("/member/register")
    public String save(@ModelAttribute MemberDto memberDto){
        System.out.println("MemberDto.save");
        System.out.println("memberDto = "+memberDto);

//        memberService = new MemberService();
        if(memberService==null) System.out.println("NULL!!");
        memberService.save(memberDto);


        // 스프링에서 아래 같은 객체생성은 잘 하지 않음
//        MemberService memberService = new MemberService();
        return "loginHome";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
        MemberDto loginResult = memberService.login(memberDto);
        if (loginResult!=null) {
            //login success
            session.setAttribute("loginEmail", loginResult.getEmail());//session으로 로그인 유지
            System.out.println("로그인 성공");
            return "main";
        }
        else {
            //login fail
            return "loginHome";
        }

    }


}