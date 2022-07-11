package com.cocom.music_admin.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.basic.EnterInfo;
import com.cocom.music_admin.data.basic.GenreInfo;

@Mapper
public interface BasicMapper {
    public List<GenreInfo> selectAllGenreInfo();
    public void insertGenreInfo(String name); 
<<<<<<< HEAD
    public List<EnterInfo> selectAllEnterInfo();
    public void insertEnterInfo(String name);
    public void deleteEnterInfo(Integer seq);
=======
    public void deleteGenreInfo(Integer seq);
>>>>>>> 96b4d1e964177ac8d6c46e138aedf4788197a0fc
}
