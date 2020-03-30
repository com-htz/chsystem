package com.htz.chsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * <p>Title: TbStudent</p>
 * <p>Description: tb_student表对应实体对象</p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 9:03 2020/3/26
 */

@Data
public class TbStudent implements Serializable {
    private Long id;
    private String name;
    private String gender;
    private Date birth;
    private String idCard;
    private String address;
    private String father;
    private String faPhone;
    private String mother;
    private String moPhone;
    private String note;

}
