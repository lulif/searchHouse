package com.gdxx.service;

import com.gdxx.entity.User;
import com.gdxx.service.result.ServiceResult;
import com.gdxx.web.dto.UserDTO;


public interface UserService {
	User findUserByName(String userName);

	ServiceResult<UserDTO> findById(Long adminId);

	User findUserByTelephone(String telephone);

	User addUserByTelephone(String telephone);

	ServiceResult modifyUserProfile(String profile, String value);
}
