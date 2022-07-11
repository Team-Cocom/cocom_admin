package com.cocom.music_admin.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    public String getMain() {
        return "/index";
    }
    public String getList() {
        return "/list";
    }
}
