package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.data.basic.MusicInfo;
import com.cocom.music_admin.mapper.basic.BasicMapper;


@RestController
@RequestMapping("/api")
public class BasicAPIController {
    @Autowired BasicMapper basic_mapper;
    @PutMapping("/genre/add")
    public Map<String,Object> putGenre(@RequestParam String name){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        Integer isDuplicateName = basic_mapper.selectGenreName(name);
        if(isDuplicateName > 0){
            resultMap.put("status", false);
            resultMap.put("message", name+"은 중복 된 장르 입니다");
            return resultMap;
        }

        else{
        basic_mapper.insertGenreInfo(name);
        resultMap.put("status", true);
        resultMap.put("message", name+"장르를 추가하였습니다");
        return resultMap;
        }
    }

    @PutMapping("/enter/add")
    public Map<String, Object> putenter(@RequestParam String name) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        Integer isDuplicateName = basic_mapper.selectEnterName(name);
        if(isDuplicateName > 0){
            resultMap.put("status", false);
            resultMap.put("message", name+"은 중복 된 기획사 입니다");
            return resultMap;
        }
        basic_mapper.insertEnterInfo(name);
        resultMap.put("status", true);
        resultMap.put("message", name+"기획사를 추가하였습니다.");
        return resultMap;
    }
    @DeleteMapping("/enter/delete")
    public Map<String, Object> deleteEnterInfo(@RequestParam Integer seq){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.deleteEnterInfo(seq);
        resultMap.put("status", true);
        resultMap.put("message", "기획사가 삭제되었습니다.");
        return resultMap;

    }

    @DeleteMapping("/genre/delete")
    public Map<String,Object> deleteGenre(@RequestParam Integer seq){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.deleteGenreInfo(seq);
        resultMap.put("status", true);
        resultMap.put("message", "장르를 삭제 하였습니다");
        return resultMap;
    }


    @PutMapping("/country/add")
    public Map<String,Object> putCountry(@RequestParam String name){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        Integer isDuplicateName = basic_mapper.selectCountryName(name);
        if(isDuplicateName > 0){
            resultMap.put("status", false);
            resultMap.put("message", name+"은 중복 된  국가입니다");
            return resultMap;
        }

        basic_mapper.insertCountryInfo(name);
        resultMap.put("status", true);
        resultMap.put("message", name+" 국가를 추가하였습니다");
        return resultMap;
    }
    @DeleteMapping("/country/delete")
    public Map<String,Object> deleteCountry(@RequestParam Integer seq){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.deleteCountryInfo(seq);
        resultMap.put("status", true);
        resultMap.put("message", "국가이름을 삭제 하였습니다");
        return resultMap;
    }
    @PutMapping("/release/add")
    public Map<String, Object> insertReleaseCompany(@RequestParam String name) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        
        basic_mapper.insertReleaseCompany(name);
        
        resultMap.put("status", true);
        resultMap.put("message", "발매사 이름을 추가하였습니다.");
        
        return resultMap;
    }
    @DeleteMapping("/release/delete")
    public Map<String, Object> deleteReleaseInfo(@RequestParam Integer seq) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.deleteReleaseInfo(seq);
        resultMap.put("status", true);
        resultMap.put("message","발매사 이름을 삭제하였습니다.");
        return resultMap;
    }

    @PutMapping("/music/add")
    public Map<String,Object> putMusic(@RequestBody MusicInfo data){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        System.out.println(data);
        basic_mapper.insertMusicInfo(data);
        resultMap.put("status", true);
        resultMap.put("message","노래 정보를 추가하였습니다.");
        return resultMap;
    }

}
