package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
=======
>>>>>>> basic_work
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.cocom.music_admin.data.business.MagazineDesc;
import com.cocom.music_admin.data.business.MagazineInfo;
=======
import com.cocom.music_admin.data.basic.MusicInfo;
import com.cocom.music_admin.data.business.AdminRecommend;
>>>>>>> basic_work
import com.cocom.music_admin.mapper.business.BusinessMapper;

@RestController
@RequestMapping("/api")
public class BusinessAPIController {
    @Autowired BusinessMapper business_mapper;
<<<<<<< HEAD
    @PutMapping("/magazine/add")
    public Map<String, Object> putMagazine(@RequestBody MagazineInfo data) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        business_mapper.insertMagazine(data);
        resultMap.put("status", true);
        resultMap.put("message", "매거진을 등록하였습니다.");
        return resultMap;
    }
    @DeleteMapping("/magazine/delete")
    public Map<String, Object> deleteMagazine(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        business_mapper.deleteMagazineInfo(seq);
        resultMap.put("status", true);
        resultMap.put("message", "매거진 정보를 삭제하였습니다.");
        
        return resultMap;
    }
    @PutMapping("/magazine/desc/")
    public Map<String, Object> PutMagazineDesc(@RequestBody MagazineDesc data){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        business_mapper.insertMagazineDesc(data);
        resultMap.put("status", true);
        resultMap.put("message", "매거진 게시글이 등록되었습니다.");

        return resultMap;
    }

    
=======
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
>>>>>>> basic_work
}
