package com.cocom.music_admin.data.account;

import java.util.Date;

import lombok.Data;

@Data
public class music_info {
    private Integer mu_seq;
    private String mu_name;
    private Integer mu_ai_seq;
    private String mu_lyrics;
    private Integer mu_ab_seq;
    private String mu_img_file;
    private String mu_music_file;
    private Integer mu_li_seq;
    private Integer mu_playtime;
    private String mu_explain_txt;
    private Integer mu_age;
    private Integer mu_str_seq;
    private Date mu_reg_dt;

}
