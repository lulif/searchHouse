package com.gdxx.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gdxx.entity.SubwayStation;

public interface SubwayStationRepository extends CrudRepository<SubwayStation, Long> {

	List<SubwayStation> findAllBySubwayId(Long subwayId);

}
