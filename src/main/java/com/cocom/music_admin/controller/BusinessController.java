package com.cocom.music_admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cocom.music_admin.mapper.basic.BasicMapper;
import com.cocom.music_admin.data.business.request.AdminPlayListVO;
import com.cocom.music_admin.mapper.business.BusinessMapper;

@Controller
public class BusinessController {
    @Autowired BusinessMapper business_mapper;
    @GetMapping("/admin/recommend")
    public String getAdRecommend(Model model){
        model.addAttribute("list", business_mapper.selectAllTodayRecommend());
        model.addAttribute("genre_list", business_mapper.selectAllRecommendGenre());
        model.addAttribute("artist_list", business_mapper.selectAllRecommendArtis());
        model.addAttribute("album_list", business_mapper.selectAllRecommendAlbum());
        model.addAttribute("musicList", business_mapper.selectMusicInfoByUser());
        model.addAttribute("music_recommend", business_mapper.selectMusicInfoRecommend());
        return "/business/admin_recommend_list";
    }
    @GetMapping("/admin/recommend/add")
    public String getAdRecommendAdd(Model model){
        return "/business/admin_recommend_add";
    }
    @GetMapping("/admin/recommend/list")
    public String getAdRecommendList(Model model, @RequestParam String title){
        List<AdminPlayListVO> ply = business_mapper.selectRecommendByString(title);
        model.addAttribute("list", ply);
        return "/business/admin_recommend_detail";
    }

    
}
