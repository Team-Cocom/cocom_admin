package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.web.bind.annotation.PatchMapping;
>>>>>>> basic_work
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.data.basic.GenreInfo;
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
<<<<<<< HEAD
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


    
=======
    @PatchMapping("/music/modify")
    public Map<String,Object> patchMusic(@RequestBody MusicInfo data){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.updateMusicInfo(data);
        resultMap.put("status", true);
        resultMap.put("message","노래 정보를 추가하였습니다.");
        return resultMap;
    }
    
    @PatchMapping("/music/img/delete")
    public Map<String,Object> patchImg(@RequestParam String filename){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.deleteMusicImgFile(filename);
        resultMap.put("status", true);
        resultMap.put("message","이미지 정보가 삭제되었습니다.");
        return resultMap;
    }

    @PatchMapping("/music/file/delete")
    public Map<String,Object> patchMusicFile(@RequestParam String filename){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.deleteMusicFile(filename);
        resultMap.put("status", true);
        resultMap.put("message","노래 정보가 삭제되었습니다.");
        return resultMap;

    }
>>>>>>> basic_work

}
