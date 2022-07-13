package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.data.post.NoticeInfo;
import com.cocom.music_admin.mapper.post.PostMapper;

@RestController
@RequestMapping("/api")
public class PostAPIController {
    @Autowired PostMapper post_mapper;
    @PutMapping("/post/add")
    public Map<String,Object> putPost(@RequestBody NoticeInfo data){
        Map<String,Object> m = new LinkedHashMap<String,Object>();
        post_mapper.insertPostInfo(data);
        m.put("message", "성공!");
        return m;
    }
}
