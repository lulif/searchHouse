package com.gdxx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "house_picture")
public class HousePicture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "house_id")
	private Long houseId;

	private String path;

	@Column(name = "cdn_prefix")
	private String cdnPrefix;

	private int width;

	private int height;

	private String location;
}
