package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.data.business.MagazineDesc;
import com.cocom.music_admin.data.business.MagazineInfo;
import com.cocom.music_admin.mapper.business.BusinessMapper;

@RestController
@RequestMapping("/api")
public class BusinessAPIController {
    @Autowired BusinessMapper business_mapper;
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

    
}
