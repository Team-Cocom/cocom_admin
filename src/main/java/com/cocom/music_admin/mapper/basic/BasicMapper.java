package com.cocom.music_admin.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.basic.EnterInfo;
import com.cocom.music_admin.data.basic.CountryInfo;
import com.cocom.music_admin.data.basic.GenreInfo;
import com.cocom.music_admin.data.basic.ReleaseCompanyInfo;

@Mapper
public interface BasicMapper {
    public void insertGenreName(String gr_name);
    public List<GenreInfo> selectAllGenreInfos();
    public Integer dpchkGenreNames(String name);

}
