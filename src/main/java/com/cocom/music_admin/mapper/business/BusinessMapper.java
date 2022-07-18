package com.cocom.music_admin.mapper.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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

    public void insertPassInfo(PassInfo data);
    public List<PassInfo> selectPassInfo(String keyword, Integer offset);
    public Integer selectPassPageCnt(String keyword);

}
