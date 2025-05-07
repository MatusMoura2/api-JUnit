package com.mfapi.app.resourse;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mfapi.app.domain.User;
import com.mfapi.app.domain.dto.UserDto;
import com.mfapi.app.servises.UserServise;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserServise userServise;

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(modelMapper.map(userServise.findById(id), UserDto.class));
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		return ResponseEntity.ok().body(userServise.findAll().stream().map(x -> modelMapper.map(x, UserDto.class))
				.collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userServise.create(userDto).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<UserDto> update(@PathVariable Integer id, @RequestBody UserDto userDto){
		userDto.setId(id);
		return ResponseEntity.ok().body(modelMapper.map(userServise.update(userDto), UserDto.class));
	}
}
