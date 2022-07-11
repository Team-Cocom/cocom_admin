package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.mapper.basic.BasicMapper;

@RestController
public class BasicAPIController {
    @Autowired BasicMapper basic_mapper;
    @PutMapping("/genre/add")
    public Map<String,Object> putGenre(@RequestParam String name){
        Map<String,Object> m = new LinkedHashMap<String,Object>();

        
        Integer isDuplicatedName = basic_mapper.dpchkGenreNames(name);
        if(isDuplicatedName > 0) {
            m.put("status", false);
            m.put("message", name+"(는)은 중복 된 장르명입니다.");
            return m;
        }
        basic_mapper.insertGenreName(name);
        m.put("status", true);
        m.put("message", name+"를 추가하였습니다");
        return m;
    }
}
