package com.cocom.music_admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountContoller {
    @GetMapping("/join")
    public String getJoin() {
        return "/account/join";
    }
    
    @GetMapping("/login")
    public String getLogin() {
        return "/account/login";
    }
    
    @GetMapping("/logout") 
    public String getAccountLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}