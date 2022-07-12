package com.cocom.music_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cocom.music_admin.mapper.business.BusinessMapper;

@Controller
public class BusinessController {
    @Autowired BusinessMapper business_mapper;
    @GetMapping("/magazine/list")
    public String listmagazine(Model model) {
        model.addAttribute("list", business_mapper.selectMagazineList());
        return "/business/magazine_list";
    }
    @GetMapping("/magazine/add")
    public String addMagazine(Model model) {
        return "/business/magazine_add";
    }
    @GetMapping("/magazine/desc")
    public String selectMagazineDesc(Model model) {
        return "/business/magazine_desc";
    }
}
