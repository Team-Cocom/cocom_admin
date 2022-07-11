package com.cocom.music_admin.data.account;

import java.util.Date;

import lombok.Data;

@Data
public class artist_info {
    private Integer ai_seq;
    private String ai_name;
    private String ai_img_file;
    private Integer ai_ent_seq;
    private Date ai_debut_dt;
    private Integer ai_gr_seq;
    private Integer ai_mu_seq;
    private Integer ai_cr_seq;
    private Integer ai_mi_seq;
    private Integer ai_aisu_seq;

}
