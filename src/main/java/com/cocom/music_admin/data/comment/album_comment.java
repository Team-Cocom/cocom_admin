package com.cocom.music_admin.data.comment;

import java.util.Date;

import lombok.Data;

@Data
public class album_comment {
    private Integer acom_seq;
    private Integer acom_mi_seq;
    private Integer acom_star_score;
    private Integer acom_li_seq;
    private Integer acom_rep_seq;
    private String acom_text;
    private Date acom_reg_dt;
    private Date acom_mod_dt;
}
