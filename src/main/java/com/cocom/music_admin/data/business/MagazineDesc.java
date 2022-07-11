package com.cocom.music_admin.data.business;

import lombok.Data;

@Data
public class MagazineDesc {
    private Integer mzd_seq;
    private String mzd_name;
    private Integer mzd_mzcom_seq;
    private String mzd_text;
    private String mzd_img_file;
    private Integer mzd_mi_seq;
}
