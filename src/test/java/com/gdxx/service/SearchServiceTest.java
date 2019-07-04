package com.gdxx.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gdxx.SearchHouseApplicationTests;
import com.gdxx.service.result.ServiceMultiResult;
import com.gdxx.web.form.RentSearch;

import junit.framework.Assert;

public class SearchServiceTest extends SearchHouseApplicationTests {
	@Autowired
	private SearchService searchService;

//	@Test
//	public void testIndex() {
//		Long targetHouseId = 15L;
//		
//		searchService.index(targetHouseId);
//	}

	@Test
	public void testRemove() {
		Long targetHouseId = 15L;

		searchService.remove(targetHouseId);
	}
	
	@Test
    public void testQuery() {
        RentSearch rentSearch = new RentSearch();
        rentSearch.setCityEnName("bj");
        rentSearch.setStart(0);
        rentSearch.setSize(10);
        rentSearch.setKeywords("国贸");
        ServiceMultiResult<Long> serviceResult = searchService.query(rentSearch);
        Assert.assertTrue(serviceResult.getTotal() > 0);
    }
//
//	@Test
//	public void testQuery() {
//		RentSearch rentSearch = new RentSearch();
//		rentSearch.setCityEnName("bj");
//		rentSearch.setStart(0);
//		rentSearch.setSize(10);
//		rentSearch.setKeywords("国贸");
//		ServiceMultiResult<Long> serviceResult = searchService.query(rentSearch);
//		Assert.assertTrue(serviceResult.getTotal() > 0);
//	}
}
