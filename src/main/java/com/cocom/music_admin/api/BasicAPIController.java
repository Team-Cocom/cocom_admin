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

import com.cocom.music_admin.data.basic.AlbumInfo;
import com.cocom.music_admin.data.basic.MusicInfo;
import com.cocom.music_admin.mapper.basic.BasicMapper;

@RestController
@RequestMapping("/api")
public class BasicAPIController {
    @Autowired BasicMapper basic_mapper;
    @PutMapping("/music/add")
    public Map<String,Object> putMusic(@RequestBody MusicInfo data){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        System.out.println(data);
        basic_mapper.insertMusicInfo(data);
        resultMap.put("status", true);
        resultMap.put("message","노래 정보를 추가하였습니다.");
        return resultMap;
    }
    @PutMapping("/genre/add")
    public Map<String, Object> putgenre(@RequestParam String name) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        Integer isDuplicateName = basic_mapper.selectGenreInfos(name);
        if(isDuplicateName > 0) {
            resultMap.put("status", false);
            resultMap.put("message", name+"은 이미 등록된 장르입니다.");
            return resultMap;
        }

        basic_mapper.insertGenreInfo(name);
        resultMap.put("status", true);
        resultMap.put("message", "장르 정보를 추가하였습니다.");
        
        return resultMap;
        
    }
    @DeleteMapping("/genre/delete")
    public Map<String, Object> deletegenre(@RequestParam Integer seq) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        
        basic_mapper.deleteGenreInfo(seq);
        resultMap.put("status", true);
        resultMap.put("message", "장르 정보를 삭제하였습니다.");
        
        return resultMap;
    }
    @PutMapping("/country/add")
    public Map<String, Object> addcountry(@RequestParam String name) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        Integer isDuplicateName = basic_mapper.selectCountryInfos(name);
        if(isDuplicateName > 0) {
            resultMap.put("status", false);
            resultMap.put("message", name+"은 이미 등록된 나라입니다.");
            return resultMap;
        }
        basic_mapper.insertCountry(name);
        resultMap.put("status", true);
        resultMap.put("message", "나라정보를 입력하였습니다.");
        
        return resultMap;
    }
    @DeleteMapping("/country/delete")
    public Map<String, Object> deletecountry(@RequestParam Integer seq) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();

        basic_mapper.deleteCountryInfo(seq);
        resultMap.put("status", true);
        resultMap.put("message", "나라정보를 삭제하였습니다.");

        return resultMap;
    }

    
    @PutMapping("/enter/list")
    public Map<String,Object> putEnterList(@RequestParam String name) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        Integer isDuplicateName = basic_mapper.selectEnterName(name);
        if(isDuplicateName > 0 ) {
            resultMap.put("status", false);
            resultMap.put("message", name+"은 이미 등록된 엔터 입니다.");
            return resultMap;
        }
        basic_mapper.insertEnterInfo(name);
        resultMap.put("status", true);
        resultMap.put("message", name+"엔터 등록을 완료했습니다.");
        return resultMap;
    }
    @DeleteMapping("/enter/list")
    public Map<String,Object> deleteEnterList(@RequestParam Integer seq) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.deleteEnterInfo(seq);
        resultMap.put("status", true);
        resultMap.put("message", "엔터 삭제를 완료했습니다.");
        return resultMap;
    }

    @PutMapping("/release/list") 
    public Map<String, Object> putReleaseComInfo(@RequestParam String name){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        Integer isDuplicateName = basic_mapper.selectReleaseComName(name);
        if(isDuplicateName > 0) {
            resultMap.put("status", false);
            resultMap.put("message", name+"은 이미 등록된 발매사 입니다.");
            return resultMap;
        }
        basic_mapper.insertReleaseComInfo(name);
        resultMap.put("status", true);
        resultMap.put("message", "발매사 등록을 완료했습니다.");
        return resultMap;
    }

    @DeleteMapping("/release/list")
        public Map<String, Object> deleteReleaseComInfo(@RequestParam Integer seq){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.deleteRelComInfo(seq);
        resultMap.put("status", true);
        resultMap.put("message", "발매사 삭제를 완료했습니다.");
        return resultMap;
        }
    
    @PutMapping("/album/add")
    public Map<String, Object> putAlbumsInfo(@RequestBody AlbumInfo data) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        return resultMap;
    }

}
