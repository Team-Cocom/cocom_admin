package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.data.basic.MusicInfo;
import com.cocom.music_admin.data.business.AdminRecommend;
import com.cocom.music_admin.mapper.business.BusinessMapper;

@RestController
@RequestMapping("/api")
public class BusinessAPIController {
    @Autowired BusinessMapper business_mapper;
    @GetMapping("/admin_recommend/music")
    public Map<String,Object> getMusic(@RequestParam String filename){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        Integer seq = business_mapper.selectMusicSeq(filename);
        if(seq == null) {
            resultMap.put("status",false);
            resultMap.put("message","등록되어 있지 않은 노래입니다\n노래를 먼저 등록해 주세요.");
            return resultMap;
        }
        resultMap.put("status",true);
        resultMap.put("message","노래 등록이 완료되었습니다.");
        resultMap.put("seq", seq);
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
}
