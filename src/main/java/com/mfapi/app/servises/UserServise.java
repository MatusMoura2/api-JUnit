package com.mfapi.app.servises;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mfapi.app.domain.User;
import com.mfapi.app.domain.dto.UserDto;

@Service
public interface UserServise {

	User findById(Integer id);
	List<User> findAll();
	User create(UserDto userDto);
	
}
