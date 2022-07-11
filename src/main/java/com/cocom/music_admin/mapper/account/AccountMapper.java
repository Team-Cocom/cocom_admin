package com.cocom.music_admin.mapper.account;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.account.AdminAccountInfo;

@Mapper
public interface AccountMapper {
    public void insertAdminAccount(AdminAccountInfo data);
    public void updateAdminAccountInfo(AdminAccountInfo data);
    public void deleteAdminAccountInfo(AdminAccountInfo data);
    
    public AdminAccountInfo login(AdminAccountInfo data);
}