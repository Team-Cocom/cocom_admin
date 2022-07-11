package com.cocom.music_admin.data.basic;

import java.util.Date;

import lombok.Data;

@Data
public class concert_info {
    private Integer ci_seq;
    private String ci_title_name;
    private Integer ci_ai_seq;
    private String ci_place;
    private String ci_ex_text;
    private String ci_ex_img_file;
    private Date ci_perform_dt;
    private Integer ci_tic_seq;
    private Date ci_reg_dt;
    private Integer ci_eve_seq;
    private Integer ci_age;
    private Integer ci_cocom_seq;
    private Integer ci_li_seq;
}
