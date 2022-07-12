package com.cocom.music_admin.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.basic.EnterInfo;
import com.cocom.music_admin.data.basic.CountryInfo;
import com.cocom.music_admin.data.basic.GenreInfo;
import com.cocom.music_admin.data.basic.MusicInfo;
import com.cocom.music_admin.data.basic.ReleaseCompanyInfo;

@Mapper
public interface BasicMapper {
    public List<GenreInfo> selectAllGenreInfo();
    public Integer selectGenreName(String name);
    public void insertGenreInfo(String name); 

    public List<EnterInfo> selectAllEnterInfo();
    public void insertEnterInfo(String name);
    public Integer selectEnterName(String name);

    public void deleteEnterInfo(Integer seq);

    public void deleteGenreInfo(Integer seq);

    public List<CountryInfo> selectAllCountryInfo();
    public Integer selectCountryName(String name);
    public void insertCountryInfo(String name); 
    public void deleteCountryInfo(Integer seq);

    public void insertReleaseCompany(String name);
    public List<ReleaseCompanyInfo> selectAllReleaseInfo();
    public void deleteReleaseInfo(Integer seq);

    public void insertMusicInfo(MusicInfo data);
    public List<MusicInfo> selectAllfromMusicInfo(String keyword , Integer offset);
    public Integer selectAllfromMusicPageCnt(String keyword);

}
