package com.cocom.music_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cocom.music_admin.mapper.basic.BasicMapper;


@Controller
public class BasicController {
    @Autowired BasicMapper basic_mapper;
<<<<<<< HEAD
    @Autowired BasicMapper enter_mapper;
=======
>>>>>>> 96b4d1e964177ac8d6c46e138aedf4788197a0fc
    @GetMapping("/genre/list")
    public String getGenreList(Model model){
        model.addAttribute("list",basic_mapper.selectAllGenreInfo());
        return "/basic/genre/list";
    }
<<<<<<< HEAD
    @GetMapping("/enter/list")
    public String getEnterList(Model model){
        model.addAttribute("list", enter_mapper.selectAllEnterInfo());
        return "/basic/enter/list";
=======
    @GetMapping("/country/list")
    public String getCountryList(Model model){
        model.addAttribute("list",basic_mapper.selectAllCountryInfo());
        return "/basic/country_list";
>>>>>>> basic_work
    }
}
