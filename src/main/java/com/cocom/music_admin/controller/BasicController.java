package com.cocom.music_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cocom.music_admin.mapper.basic.BasicMapper;

@Controller
<<<<<<< HEAD
@RequestMapping("/genre/list")
public class BasicController {
    @Autowired BasicMapper basic_mapper;
    @GetMapping()
=======
public class BasicController {
    @Autowired BasicMapper basic_mapper;
    @GetMapping("/genre/list")
>>>>>>> develop
    public String getGenreList(Model model){
        model.addAttribute("list",basic_mapper.selectAllGenreInfo());
        return "/basic/genre/list";
    }
}
