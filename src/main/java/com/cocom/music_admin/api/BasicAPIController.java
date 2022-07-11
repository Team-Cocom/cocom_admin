package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.data.basic.EnterInfo;
import com.cocom.music_admin.mapper.basic.BasicMapper;


@RestController
@RequestMapping("/api")
public class BasicAPIController {
    @Autowired BasicMapper basic_mapper;
    @PutMapping("/genre/add")
    public Map<String,Object> putGenre(@RequestParam String name){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.insertGenreInfo(name);
        resultMap.put("status", true);
        resultMap.put("message", name+"장르를 추가하였습니다");
        return resultMap;
    }
<<<<<<< HEAD
    @PutMapping("/enter/add")
    public Map<String, Object> putenter(@RequestParam String name) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        
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
=======
    @DeleteMapping("/genre/delete")
    public Map<String,Object> deleteGenre(@RequestParam Integer seq){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.deleteGenreInfo(seq);
        resultMap.put("status", true);
        resultMap.put("message", "장르를 삭제 하였습니다");
        return resultMap;
    }
>>>>>>> 96b4d1e964177ac8d6c46e138aedf4788197a0fc
}
