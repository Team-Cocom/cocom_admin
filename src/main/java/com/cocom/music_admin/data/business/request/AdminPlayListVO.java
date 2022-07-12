package com.cocom.music_admin.data.business.request;

import lombok.Data;

@Data
public class AdminPlayListVO {
    private Integer ard_seq;
    private Integer ard_aa_seq;
    private Integer ard_mu_seq;
    private String ard_title;
    private Integer ard_ab_seq;
    private String mu_name;
    private String mu_music_file;
    private Integer mu_age;
    private String mu_img_file;
}
