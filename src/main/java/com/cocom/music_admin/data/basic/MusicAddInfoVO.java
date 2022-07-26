package com.cocom.music_admin.data.basic;

import lombok.Data;

@Data
public class MusicAddInfoVO {
    private Integer mu_seq;
    private String mu_name;
    private String mu_img_file;
    private String mu_music_file;
    private Integer mu_playtime;
    private String mu_lyrics;
    private Integer mu_age;
    private String mu_explain_txt;
    private Integer gr_seq;
    private String gr_name;
    private Integer cr_seq;
    private String cr_name;
    private Integer ai_seq;
    private String ai_name;
    private Integer ab_seq;
    private String ab_name;
}
