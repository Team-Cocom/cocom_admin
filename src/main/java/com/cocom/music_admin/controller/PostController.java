package com.cocom.music_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cocom.music_admin.mapper.post.PostMapper;

@Controller
public class PostController {
    @Autowired PostMapper post_mapper;
    @GetMapping("/notice")
    public String getPostList(Model model,
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer page
    ){
        if(page==null) page=1;
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("list", post_mapper.selectAllfromNoticeInfo(keyword, (page-1)*10));
        model.addAttribute("pageCount", post_mapper.selectNoticePageCnt(keyword));
        return "post/notice_list";
    }
}
