package com.cocom.music_admin.data.comment;

import java.util.Date;

import lombok.Data;

@Data
public class ConcertCommnet {
    private Integer cocom_seq;
    private Integer cocom_ci_seq;
    private String cocom_text;
    private Integer cocom_rep_seq;
    private Date cocom_reg_dt;
    private Integer cocom_mod_dt;
}
