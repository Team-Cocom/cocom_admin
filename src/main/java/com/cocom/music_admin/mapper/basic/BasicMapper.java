package com.cocom.music_admin.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

<<<<<<< HEAD
import com.cocom.music_admin.data.basic.CountryInfo;
import com.cocom.music_admin.data.basic.GenreInfo;
=======
import com.cocom.music_admin.data.basic.EnterInfo;
import com.cocom.music_admin.data.basic.GoodsInfo;
>>>>>>> yuna_work
import com.cocom.music_admin.data.basic.MusicInfo;


@Mapper
public interface BasicMapper {
<<<<<<< HEAD

=======
>>>>>>> yuna_work
    public void insertMusicInfo(MusicInfo data);
    public List<MusicInfo> selectAllfromMusicInfo(String keyword , Integer offset);
    public Integer selectAllfromMusicPageCnt(String keyword);

<<<<<<< HEAD
    public List<GenreInfo> selectGenreInfo();
    public void insertGenreInfo(String gr_name);
    public void deleteGenreInfo(Integer seq);
    public Integer selectGenreInfos(String name);

    public List<CountryInfo> selectCountryInfo();
    public void insertCountry(String name);
    public void deleteCountryInfo(Integer seq);
    public Integer selectCountryInfos(String name);
=======
    public List<EnterInfo> selectAllEnterInfo(String keyword, Integer offset);
    public Integer selectAllEnterInfoPageCnt(String keyword);
    public void insertEnterInfo(String name);
    public Integer selectEnterName(String name);
    public void deleteEnterInfo(Integer seq);

    public List<ReleaseCompanyInfo> selectAllReCompanyInfos(String keyword, Integer offset);
    public Integer selectAllReComPageCnt(String keyword);
    public void insertReleaseComInfo(String name);
    public Integer selectReleaseComName(String name);
    public void deleteRelComInfo(Integer seq);

    public List<GoodsInfo> selectAllGoodsList(String keyword, Integer offset);
    public Integer selectGoodsPageCnt(String keyword);
    public Integer selectGoodsName(String name);
    public void insertGoodsInfo(GoodsInfo data);
    
>>>>>>> yuna_work
}
