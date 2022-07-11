package com.cocom.music_admin.data.comment;

import java.util.Date;

import lombok.Data;

@Data
public class StarpostComment {
    private Integer scom_seq;
    private Integer scom_spi_seq;
    private Integer scom_mi_seq;
    private Integer scom_star_score;
    private Integer scom_li_seq;
    private Integer scom_rep_seq;
    private String scom_text;
    private Date scom_reg_dt;
    private Date scom_mod_dt;
}
