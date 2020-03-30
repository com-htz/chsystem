package com.htz.chsystem.domain;

import lombok.Data;

/**
 *
 * <p>Title: TbTeamStudent</p>
 * <p>Description: tb_team_student表对应对象</p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 */

@Data
public class TbTeamStudent {
    private Long id;
    private Long teamId;
    private Long studentId;
    private String name;
}
