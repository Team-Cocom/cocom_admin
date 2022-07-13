package com.cocom.music_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cocom.music_admin.mapper.basic.BasicMapper;



@Controller
public class BasicController {
    @Autowired BasicMapper basic_mapper;
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
    public String addMusic(Model model,@RequestParam @Nullable Integer music_no){
        model.addAttribute("genre_list", basic_mapper.selectAllGenre());
        model.addAttribute("music_no", music_no);
        return "/basic/music_add";
    }
    @GetMapping("/music/detail")
    public String patchMusic(Model model,@RequestParam @Nullable Integer music_no){
        model.addAttribute("list", basic_mapper.selectMusicInfoBySeq(music_no)); 
        model.addAttribute("genre_list", basic_mapper.selectAllGenre());
        model.addAttribute("music_no", music_no);
        return "/basic/music_add";
    }
}
