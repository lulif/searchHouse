package com.gdxx.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 预约看房实体类
 */
@Setter
@Getter
@Entity
@Table(name = "house_subscribe")
public class HouseSubscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "admin_id")
    private Long adminId;

    // 预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成
    private int status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @Column(name = "order_time")
    private Date orderTime;

    private String telephone;

    /**
     * 踩坑 desc为MySQL保留字段 需要加转义
     */
    @Column(name = "`desc`")
    private String desc;

}
