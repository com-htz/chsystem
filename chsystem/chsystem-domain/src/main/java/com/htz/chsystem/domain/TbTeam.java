package com.htz.chsystem.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * <p>Title: TbTeam</p>
 * <p>Description: tb_team表对应实体对象</p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 16:32 2020/3/24 
 */

@Data
public class TbTeam implements Serializable {
    private Long id;
    private String grade;
    private String teamName;
    private int stuNumber;
    private String teamNote;
}
