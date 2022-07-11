package com.cocom.music_admin.controller;

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
}
