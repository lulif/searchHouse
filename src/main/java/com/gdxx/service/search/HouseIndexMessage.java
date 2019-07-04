package com.gdxx.service.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 序列化消息结构体
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor // 默认构造器 防止jackson序列化失败
public class HouseIndexMessage {

	public static final String INDEX = "index";
	public static final String REMOVE = "remove";

	public static final int MAX_RETRY = 3;

	private Long houseId;
	private String operation;
	private int retry = 0;
	
}