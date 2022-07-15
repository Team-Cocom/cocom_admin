package com.cocom.music_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cocom.music_admin.data.basic.AlbumInfo;
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
    public String addMusic(Model model,@RequestParam @Nullable Integer music_no){
        model.addAttribute("genre_list", basic_mapper.selectAllGenre());
        model.addAttribute("music_no", music_no);
        return "/basic/music_add";
    }
    @GetMapping("/genre/list")
    public String listGenre(Model model) {
        model.addAttribute("genreList", basic_mapper.selectGenreInfo());
        return "/basic/genre_list";
    }
    @GetMapping("/genre/add")
    public String addGenre(Model model) {
        return "/basic/genre_add";
    }
    @GetMapping("/genre/delete")
    public String deleteGenre(Model model) {
        return "/basic/genre_delete";
    }
    @GetMapping("/country/list")
    public String listCountry(Model model) {
        model.addAttribute("list", basic_mapper.selectCountryInfo());
        return "/basic/country_list";
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
    public String getReleaseList(Model model, @RequestParam @Nullable String keyword,
    @RequestParam @Nullable Integer page
    ){
        if(page == null)  page = 1;
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("releaseList", basic_mapper.selectAllReCompanyInfos(keyword, (page-1)*10));
        model.addAttribute("pageCnt", basic_mapper.selectAllReComPageCnt(keyword));
        return "/basic/release";
    }
    
    @GetMapping("/album/list")
    public String getAlbumList (Model model, @RequestParam @Nullable String keyword,
    @RequestParam @Nullable Integer page
    ){
        if(page == null) page = 1;
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("genreList", basic_mapper.selectGenreInfo());
        model.addAttribute("albumList", basic_mapper.selectAlbumSummary(keyword, (page-1)*10));
        model.addAttribute("pageCnt", basic_mapper.selectAlbumPageCnt(keyword));
        return "/basic/album_list";
    }
    @GetMapping("/album/detail")
    public String getAlbumList (Model model, @RequestParam Integer seq){
        model.addAttribute("list", basic_mapper.selectAlbumInfoBySeq(seq));
        return "/basic/album_detail";
    }
    
    @GetMapping("/album/add")
    public String getAlbumAdd(Model model){
        model.addAttribute("enterList", basic_mapper.selectAllfromEnter());
        model.addAttribute("relList", basic_mapper.selectAllFromRelInfo());
        return "basic/album_add";
    }
    @GetMapping("/album/modify")
    public String getAlbumMod(Model model){
        model.addAttribute("enterList", basic_mapper.selectAllfromEnter());
        model.addAttribute("relList", basic_mapper.selectAllFromRelInfo());
        return "basic/album_list";
    }
    
    @GetMapping("/music/detail")
    public String patchMusic(Model model,@RequestParam @Nullable Integer music_no){
        model.addAttribute("list", basic_mapper.selectMusicInfoBySeq(music_no)); 
        model.addAttribute("genre_list", basic_mapper.selectAllGenre());
        model.addAttribute("music_no", music_no);
        return "/basic/music_add";
    }
}
