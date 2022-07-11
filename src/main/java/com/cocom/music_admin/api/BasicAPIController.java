package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
