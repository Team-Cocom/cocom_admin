package com.cocom.music_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cocom.music_admin.mapper.basic.BasicMapper;

@Controller
public class PController {
    @Autowired BasicMapper basic_mapper;

    @GetMapping("/prc")
    public String getPrc(Model model){
        model.addAttribute("abList", basic_mapper.selectAllFromAlbums());
        return "/prc";
    }
    
}
