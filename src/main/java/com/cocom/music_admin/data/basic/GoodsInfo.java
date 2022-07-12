package com.cocom.music_admin.data.basic;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsInfo {
    private Integer gz_seq;
    private String gz_name;
    private String gz_img_file;
    private Integer gz_ai_seq;
    private Integer gz_ent_seq;
    private Integer gz_ab_seq;
    private Date gz_reg_dt;
    private String gz_ex_text;
    private Integer gz_price;
    private Integer gz_count;
    private String gz_notice;
    private Integer gz_stock;

}
