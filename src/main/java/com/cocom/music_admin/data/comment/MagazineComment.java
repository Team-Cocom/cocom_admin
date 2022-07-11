package com.cocom.music_admin.data.comment;

import java.util.Date;

import lombok.Data;

@Data
public class MagazineComment {
    private Integer mzcom_seq;
    private Integer mzcom_mz_seq;
    private Integer mzcom_mi_seq;
    private Integer mzcom_star_score;
    private Integer mzcom_li_seq;
    private Integer mzcom_rep_seq;
    private String mzcom_text;
    private Date mzcom_reg_dt;
    private Date mzcom_mod_dt;
}
