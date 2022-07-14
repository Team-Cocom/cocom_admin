package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.data.business.AdminRecommend;
import com.cocom.music_admin.data.business.PassInfo;
import com.cocom.music_admin.mapper.basic.BasicMapper;
import com.cocom.music_admin.mapper.business.BusinessMapper;

@RestController
@RequestMapping("/api")
public class BusinessAPIController {
    @Autowired BusinessMapper business_mapper;
    @Autowired BasicMapper basic_mapper;
    @GetMapping("/admin_recommend/music_list")
    public Map<String,Object> getMusicList(
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable Integer page 
        ){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();

        if(page == null) page = 1;

        resultMap.put("pageCount", basic_mapper.selectAllfromMusicPageCnt(keyword));
        resultMap.put("list", basic_mapper.selectAllfromMusicInfo(keyword, (page-1)*10));
        resultMap.put("status",true);
        resultMap.put("message","노래 등록이 완료되었습니다.");
        return resultMap;
    }

    


    @PutMapping("/admin_recommend/add")
    public Map<String,Object> putMusicList(@RequestBody AdminRecommend data){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
            business_mapper.insertAdminRecommend(data);
            resultMap.put("status",true);
            resultMap.put("message",data.getArd_title()+"재생목록에 노래를 등록하였습니다.");
        return resultMap;
    }
    @PutMapping("/pass/add")
    public Map<String,Object> putPassInfo(@RequestBody PassInfo data){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        business_mapper.insertPassInfo(data);
        resultMap.put("status",true);
        resultMap.put("message",data.getPs_name()+" 이용권을 등록하였습니다.");
        return resultMap;
    }
}
