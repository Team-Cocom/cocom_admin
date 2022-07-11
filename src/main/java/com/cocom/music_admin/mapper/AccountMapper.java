package com.cocom.music_admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cocom.music_admin.data.account.AdminAccountInfoVO;

@Mapper
public interface AccountMapper {
    public void adminAccountJoin(AdminAccountInfoVO data);
    public void Login(AdminAccountInfoVO data);
}
