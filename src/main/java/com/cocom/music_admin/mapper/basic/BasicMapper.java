package com.cocom.music_admin.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

<<<<<<< HEAD
import com.cocom.music_admin.data.basic.EnterInfo;
=======
import com.cocom.music_admin.data.basic.CountryInfo;
>>>>>>> basic_work
import com.cocom.music_admin.data.basic.GenreInfo;

@Mapper
public interface BasicMapper {
    public List<GenreInfo> selectAllGenreInfo();
    public Integer selectGenreName(String name);
    public void insertGenreInfo(String name); 
<<<<<<< HEAD
    public List<EnterInfo> selectAllEnterInfo();
    public void insertEnterInfo(String name);
    public void deleteEnterInfo(Integer seq);
=======
    public void deleteGenreInfo(Integer seq);
<<<<<<< HEAD
>>>>>>> 96b4d1e964177ac8d6c46e138aedf4788197a0fc
=======

    public List<CountryInfo> selectAllCountryInfo();
    public Integer selectCountryName(String name);
    public void insertCountryInfo(String name); 
    public void deleteCountryInfo(Integer seq);
>>>>>>> basic_work
}
