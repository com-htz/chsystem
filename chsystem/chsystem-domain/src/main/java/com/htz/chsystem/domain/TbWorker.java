package com.htz.chsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_worker表对应对象
 */
@Data
public class TbWorker implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String address;
    private Date created;
    private Date updated;

}
