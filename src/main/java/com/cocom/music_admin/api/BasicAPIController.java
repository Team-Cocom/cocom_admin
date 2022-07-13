package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.data.basic.GoodsInfo;

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

    @PutMapping("/goods/add")
    public Map<String, Object> putGoodsInfoList(@RequestBody GoodsInfo data){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        Integer isDuplicateGzName = basic_mapper.selectGoodsName(data.getGz_name());
        if(isDuplicateGzName > 0) {
            resultMap.put("status", false);
            resultMap.put("message", data.getGz_name()+"은 이미 등록된 굿즈 정보 입니다.");
            return resultMap;
        }
        basic_mapper.insertGoodsInfo(data);
        resultMap.put("status", true);
        resultMap.put("message", "굿즈 등록을 완료했습니다.");
        return resultMap;
    }
}
