package com.mfapi.app.servises;

import org.springframework.stereotype.Service;

import com.mfapi.app.domain.User;

@Service
public interface UserServise {

	User findById(Integer id);
}
