package com.finalprj.ILuvJeju.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.finalprj.ILuvJeju.dto.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try{
        	System.out.println("LoginSuccessHandler 실행");
            MemberDTO dto = ((SecurityDetails)authentication.getPrincipal()).getMemberDTO();
            System.out.println(dto.getRole());
            System.out.println(dto);
            HttpSession session = request.getSession();
            session.setAttribute("member",dto);
            if(dto.getRole()==1) {
            	response.sendRedirect("/ILuvJeju/test");
            }else {response.sendRedirect("/ILuvJeju/main");}
        }catch (Exception e){
            System.out.println("LoginSuccessHandler err : " + e.getMessage());
        }
    }
}
