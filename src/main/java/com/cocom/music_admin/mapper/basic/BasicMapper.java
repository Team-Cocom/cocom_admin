package com.cocom.music_admin.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.basic.GenreInfo;

@Mapper
public interface BasicMapper {
    public List<GenreInfo> selectAllGenreInfo();
    public void insertGenreInfo(String name); 
    public void deleteGenreInfo(Integer seq);
}
