package com.gdxx.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gdxx.entity.HousePicture;

public interface HousePictureRepository extends CrudRepository<HousePicture, Long> {

	List<HousePicture> findAllByHouseId(Long id);

}
