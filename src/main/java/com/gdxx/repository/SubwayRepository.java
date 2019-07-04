package com.gdxx.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gdxx.entity.Subway;

public interface SubwayRepository extends CrudRepository<Subway, Long> {

	List<Subway> findAllByCityEnName(String cityEnName);

}
