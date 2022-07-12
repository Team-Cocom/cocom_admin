package com.cocom.music_admin.mapper.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

<<<<<<< HEAD
import com.cocom.music_admin.data.business.MagazineDesc;
import com.cocom.music_admin.data.business.MagazineInfo;

@Mapper
public interface BusinessMapper {
    public List<MagazineInfo> selectMagazineList();
    public void insertMagazine(MagazineInfo data);
    public void deleteMagazineInfo(Integer seq);
    public List<MagazineDesc> selectMagazineDesc();
    public void insertMagazineDesc(MagazineDesc data);
=======
import com.cocom.music_admin.data.business.AdminRecommend;
import com.cocom.music_admin.data.business.request.AdminPlayListVO;

@Mapper
public interface BusinessMapper {
    public void insertAdminRecommend(AdminRecommend data);
    public Integer selectMusicSeq(String filename);
    public List<AdminRecommend> selectAllRecommend();
    public List<AdminPlayListVO> selectRecommendByString(String title);
>>>>>>> basic_work
}
