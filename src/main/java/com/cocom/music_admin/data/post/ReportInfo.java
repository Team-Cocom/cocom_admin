package com.cocom.music_admin.data.post;

import lombok.Data;

@Data
public class ReportInfo {
    private Integer rep_seq;
    private Integer rep_mi_seq;
    private Integer rep_acom_seq;
    private Integer rep_mcom_seq;
    private Integer rep_mzcom_seq;
    private Integer rep_cocom_seq;
    private Integer rep_scom_seq;
    private Integer rep_reasons;
}
