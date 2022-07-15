package com.cocom.music_admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/admin/recommend/list")
    public String getAdRecommendList(Model model, @RequestParam String title){
        List<AdminPlayListVO> ply = business_mapper.selectRecommendByString(title);
        model.addAttribute("list", ply);
        return "/business/admin_recommend_detail";
    }
    @GetMapping("/admin/event/list")
    public String getEventList(Model model, 
    @RequestParam @Nullable String keyword,
    @RequestParam @Nullable Integer page
    ){
        if(page == null) page = 1;
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("list", business_mapper.selectAllEveInfos(keyword, (page-1)*10));
        model.addAttribute("pageCnt", business_mapper.selectAllEvePageCnt(keyword));
        return "/business/admin_event_list";
    }
    @GetMapping("/admin/event/add")
    public String addEventList(Model model){
        return "/business/admin_event_add";
    }
    @GetMapping("/admin/event/delete")
    public String delEventList(Model model) {
        return "/business/admin_delete";
    }
    @GetMapping("/admin/event_detail")
    public String modEventInfo(Model model,@RequestParam Integer seq) {
        model.addAttribute("list", business_mapper.selectEventBySeq(seq));
        return "/business/admin_event_detail";
    }

    @GetMapping("/pass/list")
    public String getPass(Model model,
        @RequestParam @Nullable Integer page,
        @RequestParam @Nullable String keyword
    ){
        if(page == null) page = 1;
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("passList", business_mapper.selectPassInfo(keyword,(page-1)*10));
        model.addAttribute("pageCount", business_mapper.selectPassPageCnt(keyword));
        return "/business/pass_list";
    }

    
}
