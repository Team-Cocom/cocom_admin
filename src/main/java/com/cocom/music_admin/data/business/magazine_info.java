package com.cocom.music_admin.data.business;

import java.util.Date;

import lombok.Data;

@Data
public class magazine_info {
    private Integer mz_seq;
    private String mz_name;
    private String mz_poster_img;
    private Date mz_reg_dt;
    private Integer mz_mzd_seq;
    
}
