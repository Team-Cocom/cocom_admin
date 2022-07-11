package com.cocom.music_admin.data.basic;

import java.util.Date;

import lombok.Data;

@Data
public class ticketing_info {
    private Integer tic_seq;
    private Integer tic_ci_seq;
    private Integer tic_mi_seq;
    private Date tic_reg_dt;
}
