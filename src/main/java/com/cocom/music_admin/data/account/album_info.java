package com.cocom.music_admin.data.account;

import java.util.Date;

import lombok.Data;

@Data
public class album_info {
    private int ab_seq;
    private String ab_name;
    private String ab_img_file;
    private Date ab_re_dt;
    private int ab_ai_seq;
    private int ab_ent_seq;
    private String ab_rci_name;
    private int ab_mu_seq;
    private String ab_txt;
    private int ab_age;
    private int ab_mv_seq;
    private Date ab_reg_dt;
    private int ab_acom_seq;
}
