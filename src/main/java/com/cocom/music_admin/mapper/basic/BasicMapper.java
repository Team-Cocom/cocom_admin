package com.cocom.music_admin.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.basic.AlbumInfo;
import com.cocom.music_admin.data.basic.CountryInfo;
import com.cocom.music_admin.data.basic.GenreInfo;
import com.cocom.music_admin.data.basic.EnterInfo;
import com.cocom.music_admin.data.basic.MusicInfo;
import com.cocom.music_admin.data.basic.ReleaseCompanyInfo;
import com.cocom.music_admin.data.business.GoodsInfo;

@Mapper
public interface BasicMapper {

    public void insertMusicInfo(MusicInfo data);
    public List<MusicInfo> selectAllfromMusicInfo(String keyword , Integer offset);
    public Integer selectAllfromMusicPageCnt(String keyword);
    public MusicInfo selectMusicInfoBySeq(Integer seq);
    public void deleteMusicImgFile(String filename);
    public void deleteMusicFile(String filename);
    public void updateMusicInfo(MusicInfo data);

    public List<GenreInfo> selectGenreInfo();
    public void insertGenreInfo(String gr_name);
    public void deleteGenreInfo(Integer seq);
    public Integer selectGenreInfos(String name);

    public List<CountryInfo> selectCountryInfo();
    public void insertCountry(String name);
    public void deleteCountryInfo(Integer seq);
    public Integer selectCountryInfos(String name);
    public List<EnterInfo> selectAllEnterInfo(String keyword, Integer offset);
    public Integer selectAllEnterInfoPageCnt(String keyword);
    public void insertEnterInfo(String name);
    public Integer selectEnterName(String name);
    public void deleteEnterInfo(Integer seq);
    public List<EnterInfo> selectAllfromEnter();

    public List<ReleaseCompanyInfo> selectAllReCompanyInfos(String keyword, Integer offset);
    public Integer selectAllReComPageCnt(String keyword);
    public void insertReleaseComInfo(String name);
    public Integer selectReleaseComName(String name);
    public void deleteRelComInfo(Integer seq);

    public List<AlbumInfo> selectAlbumsInfo(String keyword, Integer offset);
    public Integer selectAlbumPageCnt(String keyword);
    public void insertAlbumInfo(AlbumInfo data);
    public List<GoodsInfo> selectAllGoodsList(String keyword, Integer offset);
    public Integer selectGoodsPageCnt(String keyword);
    public Integer selectGoodsName(String name);
    public void insertGoodsInfo(GoodsInfo data);
    
}
