package com.cocom.music_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PutMapping;
=======
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> basic_work

import com.cocom.music_admin.mapper.basic.BasicMapper;



@Controller
public class BasicController {
    @Autowired BasicMapper basic_mapper;
    @GetMapping("/genre/list")
    public String getGenreList(Model model){
<<<<<<< HEAD
        model.addAttribute("list", basic_mapper.selectAllGenreInfos());
        
        return "/basic/genre";
=======
        model.addAttribute("list",basic_mapper.selectAllGenreInfo());
        return "/basic/genre_list";
    }
    @GetMapping("/enter/list")
    public String getEnterList(Model model){
        model.addAttribute("list", basic_mapper.selectAllEnterInfo());
        return "/basic/enter_list";
    }
    @GetMapping("/country/list")
    public String getCountryList(Model model){
        model.addAttribute("list",basic_mapper.selectAllCountryInfo());
        return "/basic/country_list";
    }
    @GetMapping("/release/list")
    public String getReleaseList(Model model) {
        model.addAttribute("list", basic_mapper.selectAllReleaseInfo());
        return "/basic/release_list";
>>>>>>> basic_work
    }

    @GetMapping("/music/list")
    public String getMusicList(
        Model model,
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer page
        ){
        if(page == null) page =1;
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("list", basic_mapper.selectAllfromMusicInfo(keyword,(page-1)*10));
        model.addAttribute("pageCnt", basic_mapper.selectAllfromMusicPageCnt(keyword));
        return "/basic/music_list";
    }
    @GetMapping("/music/add")
    public String addMusic(Model model){
        return "/basic/music_add";
    }
}
