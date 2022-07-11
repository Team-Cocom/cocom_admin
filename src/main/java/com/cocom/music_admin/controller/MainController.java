package com.cocom.music_admin.controller;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD

@Controller
public class MainController {
    public String getMain() {
        return "/index";
    }
    public String getList() {
        return "/list";
    }
=======
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMain() {
        return "/index";
    }
>>>>>>> 3c8b99a45df8bdde4de2cf8bbd0ce28ef74b2873
}
