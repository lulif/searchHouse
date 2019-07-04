package com.gdxx.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gdxx.entity.HouseDetail;

public interface HouseDetailRepository extends CrudRepository<HouseDetail, Long> {

	HouseDetail findByHouseId(Long id);

	List<HouseDetail> findAllByHouseIdIn(List<Long> houseIds);

}
