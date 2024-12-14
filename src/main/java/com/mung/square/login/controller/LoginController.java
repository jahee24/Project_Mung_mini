package com.mung.square.login.controller;

import com.mung.square.dto.LoginDTO;
import com.mung.square.dto.UserDTO;
import com.mung.square.login.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequiredArgsConstructor
@SessionAttributes("user")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage() {
        // 로그인 페이지 렌더링
        return "redirect:/"; // login.html 템플릿을 반환
    }

    @PostMapping("/login")
    public String login(LoginDTO login, Model model, HttpSession session) {
        System.out.println("스프링이 제공하는 로그인---------------------------------------");
        UserDTO user = loginService.login(login);
        if(user != null) {
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("member_no",user.getMemberNo());
            session.setAttribute("name", user.getName());
            session.setAttribute("phoneNumber", user.getPhoneNumber());
            model.addAttribute("user", user);
        }



        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {//세션 종료
        System.out.println("스프링이 제공하는 로그아웃-------------------------------------");
        sessionStatus.setComplete();
        return "redirect:/";
    }


}
