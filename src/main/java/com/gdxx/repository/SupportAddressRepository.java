package com.gdxx.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gdxx.entity.SupportAddress;

public interface SupportAddressRepository extends CrudRepository<SupportAddress, Long> {
	// 根据行政级别获取对应地址信息
	List<SupportAddress> findAllByLevel(String level);

	List<SupportAddress> findAllByLevelAndBelongTo(String value, String cityName);

	SupportAddress findByEnNameAndLevel(String cityEnName, String value);

	SupportAddress findByEnNameAndBelongTo(String regionEnName, String enName);
}
