package com.cocom.music_admin.data.post;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeInfo {
    private Integer ni_seq;
    private String ni_ex_text;
    private String ni_img_file;
    private String ni_title;
    private String ni_import;
    private Date ni_reg_dt;
    private Date ni_mod_dt;
}
