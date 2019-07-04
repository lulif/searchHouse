package com.gdxx.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupportAddressDTO {
	private Long id;
	@JsonProperty(value = "belong_to")
	private String belongTo;

	@JsonProperty(value = "en_name")
	private String enName;

	@JsonProperty(value = "cn_name")
	private String cnName;

	private String level;

	private double baiduMapLongitude;

	private double baiduMapLatitude;
}
