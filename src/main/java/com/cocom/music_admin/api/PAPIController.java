package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.data.basic.AlbumInfo;
import com.cocom.music_admin.mapper.basic.BasicMapper;

@RestController
public class PAPIController {
    @Autowired BasicMapper basic_mapper;
    @PutMapping("/prc")
    public Map<String, Object> putAlbumsInfo(@RequestBody AlbumInfo data) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        basic_mapper.insertAlbumInfos(data);
        resultMap.put("status", true);
        resultMap.put("message", "앨범 정보 등록을 완료했습니다.");
        return resultMap;
    }
}
