package com.gdxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@Table(name = "support_address")
@ToString
public class SupportAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 上一级行政单位
	@Column(name = "belong_to")
	private String belongTo;

	@Column(name = "en_name")
	private String enName;

	@Column(name = "cn_name")
	private String cnName;

	private String level;

	@Column(name = "baidu_map_lng")
	private double baiduMapLongitude;

	@Column(name = "baidu_map_lat")
	private double baiduMapLatitude;

	/**
	 * 行政级别定义
	 */
	@Getter
	@AllArgsConstructor
	public enum Level {
		CITY("city"), REGION("region");
		
		private String value;

		public static Level of(String value) {
			for (Level level : Level.values()) {
				if (level.getValue().equals(value)) {
					return level;
				}
			}
			throw new IllegalArgumentException();
		}
	}
}
