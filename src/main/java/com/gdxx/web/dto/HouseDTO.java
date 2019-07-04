package com.gdxx.web.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HouseDTO {
	private Long id;

	private String title;

	private int price;

	private int area;

	private int direction;

	private int room;

	private int parlour;

	private int bathroom;

	private int floor;

	private Long adminId;

	private String district;

	private int totalFloor;

	private int watchTimes;

	private int buildYear;

	private int status;

	private Date createTime;

	private Date lastUpdateTime;

	private String cityEnName;

	private String regionEnName;

	private String street;

	private String cover;

	private int distanceToSubway;

	private HouseDetailDTO houseDetail;

	private List<String> tags;

	private List<HousePictureDTO> pictures;

	private int subscribeStatus;
	
	public List<String> getTags() {
        if (this.tags == null) {
            tags = new ArrayList<>();
        }
        return tags;
    }
}
