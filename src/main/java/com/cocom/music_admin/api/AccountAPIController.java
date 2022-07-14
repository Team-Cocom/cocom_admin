package com.cocom.music_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.cocom.music_admin.data.account.AdminAccountInfo;
import com.cocom.music_admin.mapper.account.AccountMapper;
import com.cocom.music_admin.util.AESAlgorithm;


@RestController
@RequestMapping("/api/account")
public class AccountAPIController {
    @Autowired AccountMapper account_mapper;
    @PutMapping("/join") 
    public ResponseEntity<Map<String, Object>> addAccountInfo(@RequestBody AdminAccountInfo data) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        data.setAa_pwd(AESAlgorithm.Encrypt(data.getAa_pwd()));
        
        try {
            account_mapper.insertAdminAccount(data);               
        } catch (DuplicateKeyException e) {
            resultMap.put("status", false);
            resultMap.put("message", data.getAa_id()+"은(는) 이미 등록된 아이디 입니다.");
            return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.BAD_REQUEST);
        }
        resultMap.put("status", true);
        resultMap.put("message", "계정 정보를 추가하였습니다");
        return new ResponseEntity<Map<String,Object>>(resultMap,HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Map<String, Object>> patchAccountInfo(@RequestBody AdminAccountInfo data) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(data.getAa_id() == null || data.getAa_id().equals("")) {
            resultMap.put("status", false);
            resultMap.put("message", "아이디가 입력되지 않았습니다.");    
        }
        if(data.getAa_name() == null || data.getAa_name().equals("")) {
            resultMap.put("status", false);
            resultMap.put("message", "이름이 입력되지 않았습니다.");    
        }
        if(data.getAa_pwd() == null || data.getAa_pwd().equals("")) {
            resultMap.put("status", false);
            resultMap.put("message", "비밀번호가 입력되지 않았습니다.");    
        }
        if(data.getAa_role() == null) {
            resultMap.put("status", false);
            resultMap.put("message", "관리 유형을 입력하지 않았습니다.");    
        }
        account_mapper.updateAdminAccountInfo(data);
        data.setAa_pwd(AESAlgorithm.Encrypt(data.getAa_pwd()));

        resultMap.put("status", true);
        resultMap.put("message", "계정 정보를 수정하였습니다.");
        return new ResponseEntity<Map<String,Object>>(resultMap,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public Map<String, Object> postAccountLogin(@RequestBody AdminAccountInfo data) {
    Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

    account_mapper.deleteAdminAccountInfo(data);

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
