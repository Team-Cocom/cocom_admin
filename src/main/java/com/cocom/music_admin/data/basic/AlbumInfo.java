package com.cocom.music_admin.data.basic;

import java.util.Date;

import lombok.Data;

@Data
public class AlbumInfo {
    private Integer ab_seq;
    private String ab_name;
    private String ab_img_file;
    private Date ab_re_dt;
    private Integer ab_ai_seq;
    private Integer ab_ent_seq;
    private String ab_rci_name;
    private Integer ab_mu_seq;
    private String ab_txt;
    private Integer ab_age;
    private Integer ab_mv_seq;
    private Date ab_reg_dt;
    private Integer ab_acom_seq;
    private Integer ab_is_confirm;
}
