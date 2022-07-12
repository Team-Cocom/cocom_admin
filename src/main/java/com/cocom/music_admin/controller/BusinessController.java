package com.cocom.music_admin.controller;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> basic_work
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD

=======
import org.springframework.web.bind.annotation.RequestParam;

import com.cocom.music_admin.data.business.request.AdminPlayListVO;
>>>>>>> basic_work
import com.cocom.music_admin.mapper.business.BusinessMapper;

@Controller
public class BusinessController {
    @Autowired BusinessMapper business_mapper;
<<<<<<< HEAD
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
=======
    @GetMapping("/admin/recommend")
    public String getAdRecommend(Model model){
        model.addAttribute("list", business_mapper.selectAllRecommend());
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
>>>>>>> basic_work
    }
}
