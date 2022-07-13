package com.cocom.music_admin.mapper.post;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.post.NoticeInfo;

@Mapper
public interface PostMapper {
    public void insertPostInfo(NoticeInfo data);
    public List<NoticeInfo> selectAllfromNoticeInfo(String keyword,Integer offset);
    public Integer selectNoticePageCnt(String keyword);
}
