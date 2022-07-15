package com.cocom.music_admin.mapper.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.business.GoodsInfo;
import com.cocom.music_admin.data.business.MagazineDesc;
import com.cocom.music_admin.data.business.MagazineInfo;
import com.cocom.music_admin.data.basic.EventInfo;
import com.cocom.music_admin.data.basic.MusicInfo;
import com.cocom.music_admin.data.business.AdminRecommend;
import com.cocom.music_admin.data.business.PassInfo;
import com.cocom.music_admin.data.business.request.AdminPlayListVO;

@Mapper
public interface BusinessMapper {



    public void insertAdminRecommend(AdminRecommend data);
    public Integer selectMusicSeq(String filename);
    public List<AdminPlayListVO> selectAllTodayRecommend();
    public List<AdminPlayListVO> selectAllRecommendGenre();
    public List<AdminPlayListVO> selectAllRecommendArtis();
    public List<AdminPlayListVO> selectAllRecommendAlbum();
    public List<AdminPlayListVO> selectRecommendByString(String title);

    public List<MusicInfo> selectMusicInfoByUser();
    public List<MusicInfo> selectMusicInfoRecommend();

    public List<EventInfo> selectEventInfo();
    public void insertEventInfo(EventInfo data);
    public void deleteEventInfo(Integer seq);
    public void updateEventInfo(EventInfo data);
    
    public List<EventInfo> selectAllEveInfos(String keyword, Integer offset) ;
    public Integer selectAllEvePageCnt(String keyword);
    public EventInfo selectEventBySeq(Integer seq);
}
