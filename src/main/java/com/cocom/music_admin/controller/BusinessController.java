package com.cocom.music_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cocom.music_admin.mapper.basic.BasicMapper;
import com.cocom.music_admin.mapper.business.BusinessMapper;

@Controller
public class BusinessController {
    @Autowired BusinessMapper business_mapper;
    @Autowired BasicMapper basic_mapper;
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
    @GetMapping("/goods/list")
    public String getGoodsList(
        Model model,
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer page
        ){         
            if(page == null) page = 1;
            model.addAttribute("keyword", keyword);
            model.addAttribute("page", page);
            model.addAttribute("goodsList", business_mapper.selectAllGoodsList(keyword, (page-1)*10));
            model.addAttribute("pageCnt", business_mapper.selectGoodsPageCnt(keyword));
            return "/business/goods_list";
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
                model.addAttribute("list", business_mapper.selectAllGoodsList(keyword, (page-1)*10));
                model.addAttribute("enterList", basic_mapper.selectAllfromEnter());
            model.addAttribute("pageCnt", business_mapper.selectGoodsPageCnt(keyword));
            return "/business/goods_add";
    }
    
}
