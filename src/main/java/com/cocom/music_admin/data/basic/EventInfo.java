package com.cocom.music_admin.data.basic;

import java.util.Date;

import lombok.Data;

@Data
public class EventInfo {
    private Integer eve_seq;
    private String eve_name;
    private String eve_ex_text;
    private String eve_img_file;
    private Date eve_reg_dt;
    private Integer eve_mi_seq;
    private String eve_title_img;
}
