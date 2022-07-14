package com.cocom.music_admin.data.business;

import java.util.Date;

import lombok.Data;

@Data
public class PassInfo {
    private Integer ps_seq;
    private Integer ps_type;
    private Date ps_mi_buy_dt;
    private String ps_name;
<<<<<<< HEAD
    private Integer ps_price;
    private Integer ps_mi_seq;
    private String ps_img_file;
=======
    private String ps_img_file;
    private Integer ps_price;
    private Integer ps_mi_seq;
>>>>>>> 32d52224d96bfcfa0fc5bca78d1e6b4bd4f2d134
    private Integer ps_period;

}
