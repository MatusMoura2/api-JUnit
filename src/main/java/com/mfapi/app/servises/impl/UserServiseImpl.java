package com.mfapi.app.servises.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfapi.app.domain.User;
import com.mfapi.app.domain.dto.UserDto;
import com.mfapi.app.repositories.UserRepository;
import com.mfapi.app.servises.UserServise;
import com.mfapi.app.servises.exception.DataIntegratyViolationException;
import com.mfapi.app.servises.exception.ObjectNotFoundException;

@Service
public class UserServiseImpl implements UserServise {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public User findById(Integer id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User create(UserDto userDto) {
		findByEmail(userDto);
		return userRepository.save(modelMapper.map(userDto, User.class));
	}

	@Override
	public User update(UserDto userDto) {
		findByEmail(userDto);
		return userRepository.save(modelMapper.map(userDto, User.class));
	}

	@Override
	public void delete(Integer id) {
		findById(id);
		userRepository.deleteById(id);
	}

	private void findByEmail(UserDto userDto) {
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		if (optionalUser.isPresent() && !optionalUser.get().getId().equals(userDto.getEmail())) {
			throw new DataIntegratyViolationException("Email ja cadastrado no sistema");
		}
	}
}
