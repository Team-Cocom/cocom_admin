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
        if(page == null) page = 1;
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

    @GetMapping("/enter/list")
    public String getEnterList(
    Model model,
    @RequestParam @Nullable String keyword,
    @RequestParam @Nullable Integer page
    ) {
        if(page == null) page = 1;
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("list", basic_mapper.selectAllEnterInfo(keyword, (page-1)*10));
        model.addAttribute("pageCnt", basic_mapper.selectAllEnterInfoPageCnt(keyword));
        return "/basic/enter";
    }

    @GetMapping("/release/list")
    public String getReleaseList(
        Model model,
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer page
        ){
        if(page == null)  page = 1;
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("list", basic_mapper.selectAllReCompanyInfos(keyword, (page-1)*10));
        model.addAttribute("pageCnt", basic_mapper.selectAllReComPageCnt(keyword));
        return "/basic/release";
    }
    @GetMapping("/goods/list")
    public String getGoodsList(
        Model model,
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer page
        ){         
            if(page == null) page = 1;
            model.addAttribute("keyword", keyword);
            model.addAttribute("page", page);
            model.addAttribute("list", basic_mapper.selectAllGoodsList(keyword, (page-1)*10));
            model.addAttribute("pageCnt", basic_mapper.selectGoodsPageCnt(keyword));
            return "/basic/goods";
    }

    @GetMapping("/goods/add")
    public String getGoodsAdd(
        Model model,
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer page
        ){         
            if(page == null) page = 1;
            model.addAttribute("keyword", keyword);
            model.addAttribute("page", page);
            model.addAttribute("list", basic_mapper.selectAllGoodsList(keyword, (page-1)*10));
            model.addAttribute("pageCnt", basic_mapper.selectGoodsPageCnt(keyword));
            return "/basic/goods_add";
    }

}
