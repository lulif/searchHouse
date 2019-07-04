package com.gdxx.entity;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gdxx.SearchHouseApplicationTests;
import com.gdxx.repository.UserRepository;

public class UserRepositoryTest extends SearchHouseApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindOne() {
		User user = userRepository.findOne(1L);
		System.out.println(user.toString());
	}

}
