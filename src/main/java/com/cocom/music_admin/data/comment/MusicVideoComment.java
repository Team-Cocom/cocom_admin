package com.cocom.music_admin.data.comment;

import java.util.Date;

import lombok.Data;

@Data
public class MusicVideoComment {
    private Integer mcom_seq;
    private Integer mcom_mv_seq;
    private Integer mcom_mi_seq;
    private Integer mcom_star_score;
    private Integer mcom_li_seq;
    private Integer mcom_rep_seq;
    private String mcom_text;
    private Date mcom_reg_dt;
    private Date mcom_mod_dt;
}
