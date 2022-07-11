package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocom.music_admin.data.account.AdminAccountInfo;
import com.cocom.music_admin.mapper.AccountMapper;
import com.cocom.music_admin.util.AESAlgorithm;


@RestController
@RequestMapping("/api/account")
public class AccountAPIController {
    @Autowired AccountMapper account_mapper;
    @PutMapping("/join") 
    public Map<String, Object> putAccountJoin(@RequestBody AdminAccountInfo data) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        account_mapper.adminAccountJoin(data);
        resultMap.put("status", true);
        resultMap.put("message", "관리자 등록이 완료되었습니다.");
        return resultMap;
    }

    @PostMapping("/login")
    public Map<String, Object> postAccountLogin(@RequestBody AdminAccountInfo data, HttpSession session) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        data.setAa_pwd(AESAlgorithm.Encrypt(data.getAa_pwd()));
        AdminAccountInfo user = account_mapper.login(data);

        if(user == null) {
            resultMap.put("status", false);
            resultMap.put("message", "아이디 또는 비밀번호 오류입니다.");
            return resultMap;
        }

        resultMap.put("status", true);
        resultMap.put("message", "로그인 되었습니다.");
        return resultMap;
    }

}
