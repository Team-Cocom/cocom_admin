package com.cocom.music_admin.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.basic.CountryInfo;
import com.cocom.music_admin.data.basic.GenreInfo;
import com.cocom.music_admin.data.basic.MusicInfo;


@Mapper
public interface BasicMapper {

    public void insertMusicInfo(MusicInfo data);
    public List<MusicInfo> selectAllfromMusicInfo(String keyword , Integer offset);
    public Integer selectAllfromMusicPageCnt(String keyword);

    public List<GenreInfo> selectGenreInfo();
    public void insertGenreInfo(String gr_name);
    public void deleteGenreInfo(Integer seq);
    public Integer selectGenreInfos(String name);

    public List<CountryInfo> selectCountryInfo();
    public void insertCountry(String name);
    public void deleteCountryInfo(Integer seq);
    public Integer selectCountryInfos(String name);
}
