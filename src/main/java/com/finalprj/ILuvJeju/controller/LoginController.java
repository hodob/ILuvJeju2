package com.finalprj.ILuvJeju.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalprj.ILuvJeju.dto.MemberDTO;
import com.finalprj.ILuvJeju.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping(value="/main")
    public String main(@RequestParam(value="name", defaultValue = "world") String name, Model model){
        model.addAttribute("name", name);
        return "main";
    }  
   
    
    @GetMapping(value="/test")
    public String test(@RequestParam(value="name", defaultValue = "world") String name, Model model){
    	System.out.println("tset@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return "test";
    }

    @RequestMapping("/memberL")
    public String memberLogin() throws Exception{
    	System.out.println("memberLogin@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return "/member/memberLogin";
    }

    @RequestMapping("/login")
    public String loginUser(MemberDTO dto, HttpServletRequest request) throws Exception{
    	System.out.println("loginUser@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    	System.out.println(dto+"@@@@@@@@@@1@@@@@@@@@@@@@");
        String url = "";
        HttpSession session = request.getSession();
        System.out.println(dto+"@@@@@@@@@@2@@@@@@@@@@@@@");
        MemberDTO member = service.login(dto);
        System.out.println(dto+"@@@@@@@@@@3@@@@@@@@@@@@@");
        System.out.println(member+"@@@@@@@@@@4@@@@@@@@@@@@@");
        if(member != null){
            session.setAttribute("member",member);
            System.out.println(member+"@@@@@@@@@@5@@@@@@@@@@@@@");
            System.out.println(dto+"@@@@@@@@@@6@@@@@@@@@@@@@");
            request.setAttribute("role",dto.getRole());
			/* url = "/test"; */
        }else{
            request.setAttribute("result","false");
            url = "/member/memberLogin";
        }
        return url;
    }

    @RequestMapping("/logout")
    public String logoutUser(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        session.invalidate();
        request.setAttribute("result","true");
        return "/main";
    }
}
