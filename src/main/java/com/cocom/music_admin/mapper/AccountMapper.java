package com.cocom.music_admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.account.AdminAccountInfo;

@Mapper
public interface AccountMapper {
    public void adminAccountJoin(AdminAccountInfo data);
    public AdminAccountInfo login(AdminAccountInfo data);
}