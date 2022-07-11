package com.cocom.music_admin.data.basic;

import java.util.Date;

import lombok.Data;

@Data
public class MusicVideoInfo {
    private Integer mv_seq;
    private Integer mv_ai_seq;
    private Integer mv_ab_seq;
    private String mv_vid_file;
    private Integer mv_li_seq;
    private Integer mv_watch;
    private Integer mv_mcom_seq;
    private Integer mv_str_seq;
    private Date mv_reg_dt;
}
