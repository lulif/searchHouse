package com.gdxx.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 预约看房实体类
 */
@Setter
@Getter
public class HouseSubscribeDTO {
    private Long id;

    private Long houseId;

    private Long userId;

    private Long adminId;

    // 预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成
    private int status;

    private Date createTime;

    private Date lastUpdateTime;

    private Date orderTime;

    private String telephone;

    private String desc;
}
