package com.cocom.music_admin.data.basic;

import java.util.Date;

import lombok.Data;

@Data
public class AlbumListInfoVO {
    private Integer ab_seq;
    private String ab_name;
    private String ab_img_file;
    private Date ab_re_dt;
    private String ab_txt;
    private Integer ab_age;
    private Date ab_reg_dt;
    private Integer ab_is_confirm;
    private String mu_seq;
    private String mu_name;
    private String mu_img_file;
    private String mu_music_file;
    private Integer mu_age;
    private String mu_is_confirm;
    private String gr_name;
    private String rci_name;
    private String ent_name;
}
