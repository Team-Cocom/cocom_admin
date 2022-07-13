package com.cocom.music_admin.mapper.basic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.basic.GenreInfo;
import com.cocom.music_admin.data.basic.MusicInfo;

@Mapper
public interface BasicMapper {

    public void insertMusicInfo(MusicInfo data);
    public List<MusicInfo> selectAllfromMusicInfo(String keyword , Integer offset);
    public Integer selectAllfromMusicPageCnt(String keyword);
    public MusicInfo selectMusicInfoBySeq(Integer seq);
    public void deleteMusicImgFile(String filename);
    public void deleteMusicFile(String filename);
    public void updateMusicInfo(MusicInfo data);

    public List<GenreInfo> selectAllGenre();

}
