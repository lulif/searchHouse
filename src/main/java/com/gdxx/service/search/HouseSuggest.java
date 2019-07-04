package com.gdxx.service.search;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class HouseSuggest {
    private String input;
    private int weight = 10; // 默认权重
}
