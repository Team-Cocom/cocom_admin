package com.cocom.music_admin.mapper.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.business.GoodsInfo;
import com.cocom.music_admin.data.business.MagazineDesc;
import com.cocom.music_admin.data.business.MagazineInfo;

@Mapper
public interface BusinessMapper {
    public List<MagazineInfo> selectMagazineList();
    public void insertMagazine(MagazineInfo data);
    public void deleteMagazineInfo(Integer seq);
    public List<MagazineDesc> selectMagazineDesc();
    public void insertMagazineDesc(MagazineDesc data);

    public List<GoodsInfo> selectAllGoodsList(String keyword, Integer offset);
    public Integer selectGoodsPageCnt(String keyword);
    public Integer selectGoodsName(String name);
    public void insertGoodsInfo(GoodsInfo data);
    public void deleteGoodsInfo(Integer seq);
}
