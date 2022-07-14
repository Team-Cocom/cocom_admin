package com.cocom.music_admin.data.basic;

import java.util.Date;

import lombok.Data;

@Data
public class AlbumSummary {
    private Integer ab_seq;
    private String ab_name;
    private String ab_img_file;
    private Date ab_re_dt;
    private String ab_txt;
    private Integer ab_age;
    private Date ab_reg_dt;
    private Integer ab_acom_seq;
    private String ai_name;
    private String ent_name;
    private String cr_name;
    private String gr_name;
    private String rci_name;
}
