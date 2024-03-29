package com.gdxx.service.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class HouseBucketDTO {
    // 聚合bucket的key
    private String key;

    // 聚合结果值
    private long count;
}
