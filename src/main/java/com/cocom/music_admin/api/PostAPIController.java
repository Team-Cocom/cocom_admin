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

import com.cocom.music_admin.data.post.NoticeInfo;
import com.cocom.music_admin.mapper.post.PostMapper;

@RestController
@RequestMapping("/api")
public class PostAPIController {
    @Autowired PostMapper post_mapper;
    @PutMapping("/post/add")
    public Map<String,Object> putPost(@RequestBody NoticeInfo data){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        post_mapper.insertPostInfo(data);
        resultMap.put("status", true);
        resultMap.put("message", "공지사항이 등록되었습니다.");
        return resultMap;
    }
    @PatchMapping("/post/delete_img")
    public Map<String,Object> deletePostImg(@RequestParam Integer seq){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        post_mapper.deleteNoticeImg(seq);
        resultMap.put("message", "이미지 삭제를 완료하였습니다.");
        return resultMap;
    }
    @DeleteMapping("/post/delete")
    public Map<String, Object> deleteNoticeInfo(@RequestParam Integer post_no) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        post_mapper.deleteNoticeInfo(post_no);
        resultMap.put("status", true);
        resultMap.put("message", "공지사항 정보 삭제를 완료했습니다.");
        return resultMap;
    }
    
    @PatchMapping("/post/detail")
    public Map<String,Object> patchPostDetails(@RequestBody NoticeInfo data){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        post_mapper.selectAllNoticeInfo();
        post_mapper.updateNoticDetails(data);
        resultMap.put("status", true);
        resultMap.put("message", "공지사항 정보 수정을 완료했습니다.");
        return resultMap;
    }
}
