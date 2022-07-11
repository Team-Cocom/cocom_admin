package com.cocom.music_admin.data.account;

import lombok.Data;

@Data
public class admin_account_info {
    private Integer aa_seq;
    private String aa_id;
    private String aa_pwd;
    private Integer aa_role;
    private String aa_ip;
}