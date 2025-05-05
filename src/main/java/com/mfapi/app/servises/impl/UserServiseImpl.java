package com.mfapi.app.servises.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfapi.app.domain.User;
import com.mfapi.app.repositories.UserRepository;
import com.mfapi.app.servises.UserServise;
import com.mfapi.app.servises.exception.ObjectNotFoundException;

@Service
public class UserServiseImpl implements UserServise{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(Integer id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
 	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

}
